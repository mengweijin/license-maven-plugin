package com.github.mengweijin.license.merge.impl;

import com.github.mengweijin.license.merge.License;

/**
 * @author mengweijin
 * @date 2022/3/21
 */
public class EDL implements License {

    @Override
    public String[] getLicenses() {
        return new String[] {
                "EDL",
                "EDL 1.0",
                "Eclipse Distribution License - v 1.0",
                "Eclipse Distribution License v. 1.0"
        };
    }
}
