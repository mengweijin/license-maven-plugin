package com.github.mengweijin.license.merge.impl;

import com.github.mengweijin.license.merge.License;

/**
 * @author mengweijin
 * @date 2022/3/21
 */
public class BSD implements License {

    @Override
    public String[] getLicenses() {
        return new String[] {
                "BSD",
                "BSD License",
                "BSD-2-Clause",
                "BSD 2-Clause License",
                "BSD License 3",
                "BSD 3-Clause",
                "BSD-3-Clause",
                "BSD 3-Clause License",
                "BSD 3-clause New License",
                "The BSD 3-Clause License"
        };
    }
}
