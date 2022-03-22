package com.github.mengweijin.license.mojo;

import com.github.mengweijin.license.Utils;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.codehaus.mojo.license.CustomerAggregatorAddThirdPartyMojo;

/**
 * 注释说明：@Execute(phase = LifecyclePhase.PACKAGE) 在执行当前 Mojo 前先打包
 *
 * @author mengweijin
 */
@Mojo(name = "aggregate-add-third-party", aggregator = true, defaultPhase = LifecyclePhase.GENERATE_RESOURCES, requiresDependencyResolution = ResolutionScope.TEST, threadSafe = true)
public class ExtendAggregatorAddThirdPartyMojo extends CustomerAggregatorAddThirdPartyMojo {

    @Override
    protected void init() throws Exception {
        // 存在未知的 license 时执行失败。默认 false，这里改为 true。
        this.failOnMissing = true;
        // 黑名单中有则执行失败。默认 false，这里改为 true。
        this.failOnBlacklist = true;

        // licenseMerges
        this.licenseMerges = Utils.addDefaultLicenseMerges(this.licenseMerges);

        // IncludedLicenses
        Utils.addDefaultIncludedLicensesIfEmpty(this.includedLicenses);

        // ExcludedLicenses
        Utils.addDefaultExcludedLicensesIfEmpty(this.excludedLicenses);

        super.init();
    }
}
