package com.github.mengweijin.license.mojo;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.codehaus.mojo.license.AggregateDownloadLicensesMojo;

/**
 * @author mengweijin
 * @date 2022/3/22
 */
@Mojo( name = "aggregate-download-licenses", requiresDependencyResolution = ResolutionScope.TEST,
        defaultPhase = LifecyclePhase.PACKAGE, aggregator = true )
public class ExtendAggregateDownloadLicensesMojo extends AggregateDownloadLicensesMojo {
}
