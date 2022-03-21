package com.github.mengweijin.license.merge.impl;

import com.github.mengweijin.license.merge.License;

/**
 * @author mengweijin
 * @date 2022/3/21
 */
public class EPL implements License {

    @Override
    public String[] getLicenses() {
        return new String[] {
                "EPL",
                "EPL 1.0",
                "Eclipse Public + Distribution License - v 1.0",
                "Eclipse Public License - v 1.0",
                "Eclipse Public License, Version 1.0",
                "EPL 2.0",
                "Eclipse Public License - v 2.0 with Secondary License",
                "Eclipse Public License - v 2.0",
                "Eclipse Public License v2.0",
                "MPL 2.0 or EPL 1.0"
        };
    }
}
