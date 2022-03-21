package com.github.mengweijin.license.merge.impl;

import com.github.mengweijin.license.merge.License;

/**
 * @author mengweijin
 * @date 2022/3/21
 */
public class CDDL implements License {

    @Override
    public String[] getLicenses() {
        return new String[] {
                "CDDL",
                "COMMON DEVELOPMENT AND DISTRIBUTION LICENSE",
                "COMMON DEVELOPMENT AND DISTRIBUTION LICENSE (CDDL) Version 1.0"
        };
    }
}
