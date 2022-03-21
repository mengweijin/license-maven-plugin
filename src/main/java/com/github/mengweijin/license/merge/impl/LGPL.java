package com.github.mengweijin.license.merge.impl;

import com.github.mengweijin.license.merge.License;

/**
 * @author mengweijin
 * @date 2022/3/21
 */
public class LGPL implements License {

    @Override
    public String[] getLicenses() {
        return new String[] {
                "LGPL",
                "LGPL-2.0",
                "GNU Library General Public License, version 2",
                "GNU Library General Public License v2.1 or later",
                "LGPL-2.1",
                "GNU Lesser General Public License, version 2.1",
                "GNU General Lesser Public License (LGPL) version 2.1",
                "LGPL-3.0",
                "GNU Lesser General Public License, version 3",
                "GNU General Lesser Public License (LGPL) version 3.0",
        };
    }
}
