package com.github.mengweijin.license;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.codehaus.mojo.license.AddThirdPartyMojo;
import java.util.List;

/**
 * 原来的 AggregatorAddThirdPartyMojo 类 会调用这个插件：org.codehaus.mojo:license-maven-plugin:add-third-party
 * 但由于这个项目是扩展了原来的项目，再根据上面的 groupId 和 Artifact 就找不到对应的插件了。
 * 因此，我们需要自己添加一个类 LicenseAddThirdPartyMojo 继承原来的 AddThirdPartyMojo 类，功能保持不变。
 * 这样我们自己的插件中就有一个：com.github.mengweijin:license-maven-plugin:add-third-party 插件可以使用了。
 * @author mengweijin
 * @date 2022/3/21
 */
@Mojo( name = "check-add-third-party", requiresDependencyResolution = ResolutionScope.TEST, defaultPhase = LifecyclePhase.GENERATE_RESOURCES )
public class LicenseAddThirdPartyMojo extends AddThirdPartyMojo {

    @Parameter
    protected List<String> licenseMerges;

    /**
     * 存在未知的 license 时执行失败。默认 true
     */
    @Parameter(property = "license.failOnMissing", defaultValue = "true")
    protected boolean failOnMissing;

    /**
     * 黑名单中有则执行失败。默认 true
     */
    @Parameter(property = "license.failOnBlacklist", defaultValue = "true")
    protected boolean failOnBlacklist;

    /**
     * 白名单
     */
    @Parameter(property = "license.includedLicenses")
    protected IncludedLicenses includedLicenses;

    /**
     * 黑名单
     */
    @Parameter(property = "license.excludedLicenses")
    protected ExcludedLicenses excludedLicenses;


    @Override
    protected void init() throws Exception {
        licenseMerges = Utils.resetLicenseMerges(Utils.listToMap(licenseMerges));
        // IncludedLicenses
        Utils.addDefaultIncludedLicenses(includedLicenses);
        // ExcludedLicenses
        Utils.addDefaultExcludedLicenses(excludedLicenses);

        super.init();
    }
}
