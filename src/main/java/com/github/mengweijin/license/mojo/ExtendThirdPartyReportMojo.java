package com.github.mengweijin.license.mojo;

import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.codehaus.mojo.license.ThirdPartyReportMojo;

/**
 * @author mengweijin
 * @date 2022/3/22
 */
@Mojo( name = "third-party-report", requiresDependencyResolution = ResolutionScope.TEST )
public class ExtendThirdPartyReportMojo extends ThirdPartyReportMojo {
}
