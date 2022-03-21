package com.github.mengweijin.license.merge.impl;

import com.github.mengweijin.license.merge.License;

/**
 * @author mengweijin
 * @date 2022/3/21
 */
public class CC0 implements License {

    @Override
    public String[] getLicenses() {
        return new String[] {
                "CC0",
                "Creative Commons CC0",
                "CC0 1.0",
                "Public Domain, per Creative Commons CC0"
        };
    }
}
