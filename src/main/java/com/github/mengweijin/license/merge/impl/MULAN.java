package com.github.mengweijin.license.merge.impl;

import com.github.mengweijin.license.merge.License;

/**
 * @author mengweijin
 * @date 2022/3/21
 */
public class MULAN implements License {

    @Override
    public String[] getLicenses() {
        return new String[] {
                "MULAN",
                "Mulan",
                "MulanPSL - 2.0",
                "Mulan Permissive Software License v2",
                "Mulan Permissive Software License，Version 2"
        };
    }
}
