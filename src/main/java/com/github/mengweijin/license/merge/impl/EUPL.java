package com.github.mengweijin.license.merge.impl;

import com.github.mengweijin.license.merge.License;

/**
 * @author mengweijin
 * @date 2022/3/21
 */
public class EUPL implements License {

    @Override
    public String[] getLicenses() {
        return new String[] {
                "EUPL",
                "European Union Public License v1.1",
        };
    }
}
