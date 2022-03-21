package com.github.mengweijin.license;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.codehaus.mojo.license.CustomerAggregatorAddThirdPartyMojo;
import java.util.List;

/**
 * 注释说明：@Execute(phase = LifecyclePhase.PACKAGE) 在执行当前 Mojo 前先打包
 *
 * @author mengweijin
 */
@Mojo(name = "check", aggregator = true, defaultPhase = LifecyclePhase.GENERATE_RESOURCES, requiresDependencyResolution = ResolutionScope.TEST, threadSafe = true)
public class LicenseCheckMojo extends CustomerAggregatorAddThirdPartyMojo {

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
