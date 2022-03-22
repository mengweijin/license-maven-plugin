package com.github.mengweijin.license.mojo;

import org.apache.maven.plugins.annotations.Mojo;
import org.codehaus.mojo.license.UpdateFileHeaderMojo;

/**
 * @author mengweijin
 * @date 2022/3/22
 */
@Mojo( name = "update-file-header", threadSafe = true )
public class ExtendUpdateFileHeaderMojo extends UpdateFileHeaderMojo {
}
