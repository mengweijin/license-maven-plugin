package com.github.mengweijin.license.merge.impl;

import com.github.mengweijin.license.merge.License;

/**
 * @author mengweijin
 * @date 2022/3/21
 */
public class MIT implements License {

    @Override
    public String[] getLicenses() {
        return new String[] {
                "MIT",
                "MIT-License",
                "MIT License",
                "MIT Licensed",
                "The MIT License",
                "The MIT License (MIT)"
        };
    }
}
