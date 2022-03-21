package com.github.mengweijin.license.merge.impl;

import com.github.mengweijin.license.merge.License;

/**
 * @author mengweijin
 * @date 2022/3/21
 */
public class FDL implements License {

    @Override
    public String[] getLicenses() {
        return new String[] {
                "FDL",
                "GNU Free Documentation License (FDL) version 1.3",
        };
    }
}
