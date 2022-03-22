package com.github.mengweijin.license.mojo;

import org.apache.maven.plugins.annotations.Mojo;
import org.codehaus.mojo.license.LicenseListMojo;

/**
 * @author mengweijin
 * @date 2022/3/22
 */
@Mojo( name = "license-list", requiresProject = false, requiresDirectInvocation = true )
public class ExtendLicenseListMojo extends LicenseListMojo {
}
