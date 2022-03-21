package com.github.mengweijin.license.merge.impl;

import com.github.mengweijin.license.merge.License;

/**
 * @author mengweijin
 * @date 2022/3/21
 */
public class AGPL implements License {

    @Override
    public String[] getLicenses() {
        return new String[] {
                "AGPL",
                "GNU Affero General Public License (AGPL) version 3.0"
        };
    }
}
