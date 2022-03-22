package com.github.mengweijin.license.mojo;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.codehaus.mojo.license.UpdateProjectLicenseMojo;

/**
 * @author mengweijin
 * @date 2022/3/22
 */
@Mojo( name = "update-project-license", defaultPhase = LifecyclePhase.GENERATE_RESOURCES )
public class ExtendUpdateProjectLicenseMojo extends UpdateProjectLicenseMojo {
}
