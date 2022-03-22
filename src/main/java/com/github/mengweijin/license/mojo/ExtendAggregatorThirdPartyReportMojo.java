package com.github.mengweijin.license.mojo;

import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.codehaus.mojo.license.AggregatorThirdPartyReportMojo;

/**
 * @author mengweijin
 * @date 2022/3/22
 */
@Mojo( name = "aggregate-third-party-report", aggregator = true, requiresDependencyResolution = ResolutionScope.TEST )
public class ExtendAggregatorThirdPartyReportMojo extends AggregatorThirdPartyReportMojo {
}
