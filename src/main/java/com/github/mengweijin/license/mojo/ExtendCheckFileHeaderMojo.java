package com.github.mengweijin.license.mojo;

import org.apache.maven.plugins.annotations.Mojo;
import org.codehaus.mojo.license.CheckFileHeaderMojo;

/**
 * @author mengweijin
 * @date 2022/3/22
 */
@Mojo( name = "check-file-header", threadSafe = true )
public class ExtendCheckFileHeaderMojo extends CheckFileHeaderMojo {
}
