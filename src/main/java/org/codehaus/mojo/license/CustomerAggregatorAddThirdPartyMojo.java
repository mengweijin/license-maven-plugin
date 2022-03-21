package org.codehaus.mojo.license;

import org.apache.commons.collections.CollectionUtils;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.model.Plugin;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.codehaus.mojo.license.model.LicenseMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

/**
 * 为什么写在这个目录下？
 * 因为要修改 doAction() 方法，而这个方法中使用了父类中的一些受保护的方法（default 范围），因此，这些方法只能在同一个包中才能使用。
 * @author mengweijin
 * @date 2022/3/21
 */
public class CustomerAggregatorAddThirdPartyMojo extends AggregatorAddThirdPartyMojo {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerAggregatorAddThirdPartyMojo.class);

    @Parameter( property = "reactorProjects", readonly = true, required = true )
    private List<MavenProject> reactorProjects;

    /**
     * 原来的 AggregatorAddThirdPartyMojo 类 会调用这个插件：org.codehaus.mojo:license-maven-plugin:add-third-party
     * 但由于这个项目是扩展了原来的项目，再根据上面的 groupId 和 Artifact 就找不到对应的插件了。
     * 因此，我们需要自己添加一个类 LicenseAddThirdPartyMojo 继承原来的 AddThirdPartyMojo 类，功能保持不变。
     * 这样我们自己的插件中就有一个：com.github.mengweijin:license-maven-plugin:add-third-party 插件可以使用了。
     * 然后把 doAcation() 方法中的参数改为下面的 PLUGIN_GROUP_ARTIFACT
     */
    private static final String PLUGIN_GROUP_ARTIFACT = "com.github.mengweijin:license-maven-plugin";
    private static final String MOJO_NAME= "add-third-party";

    @Override
    protected void doAction() throws Exception {
        if (isVerbose()) {
            LOG.info("After executing on {} project(s)", reactorProjects.size());
        }

        licenseMap = new LicenseMap();

        Artifact pluginArtifact = (Artifact) project.getPluginArtifactMap().get(PLUGIN_GROUP_ARTIFACT);

        String groupId = null;
        String artifactId = null;
        String version = null;
        if (pluginArtifact == null) {
            Plugin plugin = (Plugin) project.getPluginManagement().getPluginsAsMap().get(PLUGIN_GROUP_ARTIFACT);
            if (plugin != null) {
                groupId = plugin.getGroupId();
                artifactId = plugin.getArtifactId();
                version = plugin.getVersion();
            }
        } else {
            groupId = pluginArtifact.getGroupId();
            artifactId = pluginArtifact.getArtifactId();
            version = pluginArtifact.getVersion();
        }
        if (groupId == null) {
            throw new IllegalStateException("Can't find license-maven-plugin");
        }

        String addThirdPartyRoleHint = groupId + ":" + artifactId + ":" + version + ":" + MOJO_NAME;

        for (MavenProject reactorProject : reactorProjects) {
            if (getProject().equals(reactorProject) && !acceptPomPackaging) {
                // does not process this pom unless specified
                continue;
            }

            AddThirdPartyMojo mojo = (AddThirdPartyMojo) getSession()
                    .lookup(AddThirdPartyMojo.ROLE, addThirdPartyRoleHint);

            mojo.initFromMojo(this, reactorProject, new ArrayList<>(this.reactorProjects));

            LicenseMap childLicenseMap = mojo.licenseMap;
            if (isVerbose()) {
                LOG.info("Found {} license(s) in module {}:{}",
                        childLicenseMap.size(), mojo.project.getGroupId(), mojo.project.getArtifactId());
            }
            licenseMap.putAll(childLicenseMap);

        }

        LOG.info("Detected {} license(s).", licenseMap.size());
        if (isVerbose()) {
            for (Map.Entry<String, SortedSet<MavenProject>> entry : licenseMap.entrySet()) {
                LOG.info(" - {} for {} artifact(s).", entry.getKey(), entry.getValue().size());
            }
        }

        consolidate();

        checkUnsafeDependencies();

        boolean safeLicense = checkForbiddenLicenses();

        checkBlacklist(safeLicense);

        writeThirdPartyFile();

        checkMissing(CollectionUtils.isNotEmpty(unsafeDependencies));
    }
}