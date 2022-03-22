package com.github.mengweijin.license.mojo;

import org.apache.maven.plugins.annotations.Mojo;
import org.codehaus.mojo.license.CommentStyleListMojo;

/**
 * @author mengweijin
 * @date 2022/3/22
 */
@Mojo( name = "comment-style-list", requiresProject = false, requiresDirectInvocation = true )
public class ExtendCommentStyleListMojo extends CommentStyleListMojo {
}
