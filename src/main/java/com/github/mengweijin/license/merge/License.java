package com.github.mengweijin.license.merge;

/**
 * @author mengweijin
 * @date 2022/3/21
 */
public interface License {

    /**
     * get licenses. The first element in array is the mainly license.
     * @return array
     */
    String[] getLicenses();

    /**
     * get mainly license
     * @return mainly license name
     */
    default String getMainlyLicense() {
        return this.getLicenses()[0].trim();
    }
}
