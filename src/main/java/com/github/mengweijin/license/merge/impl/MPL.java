package com.github.mengweijin.license.merge.impl;

import com.github.mengweijin.license.merge.License;

/**
 * @author mengweijin
 * @date 2022/3/21
 */
public class MPL implements License {

    @Override
    public String[] getLicenses() {
        return new String[] {
                "MPL",
                "Mozilla Public License",
                "MPL 2.0"
        };
    }
}
