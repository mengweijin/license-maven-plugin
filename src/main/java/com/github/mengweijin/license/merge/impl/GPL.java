package com.github.mengweijin.license.merge.impl;

import com.github.mengweijin.license.merge.License;

/**
 * @author mengweijin
 * @date 2022/3/21
 */
public class GPL implements License {

    @Override
    public String[] getLicenses() {
        return new String[] {
                "GPL",
                "GNU General Public License (GPL) version 1.0",
                "GNU General Public License (GPL) version 2.0",
                "GNU General Public License (GPL) version 3.0",
        };
    }
}
