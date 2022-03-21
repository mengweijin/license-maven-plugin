package com.github.mengweijin.license.merge.impl;

import com.github.mengweijin.license.merge.License;

/**
 * @author mengweijin
 * @date 2022/3/21
 */
public class APACHE implements License {

    @Override
    public String[] getLicenses() {
        return new String[] {
                "APACHE",
                "Apache",
                "Apache License",
                "The Apache Software License",
                "Apache 2",
                "Apache 2.0",
                "ASF 2.0",
                "Apache v2",
                "Apache License 2.0",
                "Apache License version 2.0",
                "Apache License, version 2.0",
                "Apache License, Version 2.0",
                "The Apache License, Version 2.0",
                "The Apache Software License, Version 2.0"
        };
    }
}
