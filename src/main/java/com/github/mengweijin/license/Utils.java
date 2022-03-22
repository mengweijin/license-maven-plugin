package com.github.mengweijin.license;

import cn.hutool.core.collection.CollUtil;
import com.github.mengweijin.license.merge.License;
import com.github.mengweijin.license.merge.impl.AGPL;
import com.github.mengweijin.license.merge.impl.APACHE;
import com.github.mengweijin.license.merge.impl.BSD;
import com.github.mengweijin.license.merge.impl.CC0;
import com.github.mengweijin.license.merge.impl.CDDL;
import com.github.mengweijin.license.merge.impl.EDL;
import com.github.mengweijin.license.merge.impl.EPL;
import com.github.mengweijin.license.merge.impl.EUPL;
import com.github.mengweijin.license.merge.impl.FDL;
import com.github.mengweijin.license.merge.impl.GPL;
import com.github.mengweijin.license.merge.impl.LGPL;
import com.github.mengweijin.license.merge.impl.MIT;
import com.github.mengweijin.license.merge.impl.MPL;
import com.github.mengweijin.license.merge.impl.MULAN;
import org.apache.maven.plugin.MojoExecutionException;
import org.codehaus.mojo.license.AbstractAddThirdPartyMojo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/**
 * @author mengweijin
 * @date 2022/3/21
 */
public abstract class Utils {

    private static final List<License> LICENSE_MERGE_OBJECT_LIST = new ArrayList<>();

    static {
        LICENSE_MERGE_OBJECT_LIST.add(new AGPL());
        LICENSE_MERGE_OBJECT_LIST.add(new APACHE());
        LICENSE_MERGE_OBJECT_LIST.add(new BSD());
        LICENSE_MERGE_OBJECT_LIST.add(new CC0());
        LICENSE_MERGE_OBJECT_LIST.add(new CDDL());
        LICENSE_MERGE_OBJECT_LIST.add(new EDL());
        LICENSE_MERGE_OBJECT_LIST.add(new EPL());
        LICENSE_MERGE_OBJECT_LIST.add(new EUPL());
        LICENSE_MERGE_OBJECT_LIST.add(new FDL());
        LICENSE_MERGE_OBJECT_LIST.add(new GPL());
        LICENSE_MERGE_OBJECT_LIST.add(new LGPL());
        LICENSE_MERGE_OBJECT_LIST.add(new MIT());
        LICENSE_MERGE_OBJECT_LIST.add(new MPL());
        LICENSE_MERGE_OBJECT_LIST.add(new MULAN());
    }

    public static List<String> addDefaultLicenseMerges(List<String> list) {
        if (list == null) {
            list = new ArrayList<>();
        }

        Map<String, LinkedHashSet<String>> map = new HashMap<>(list.size());
        list.forEach(value -> {
            String[] split = value.split("\\|");
            map.put(split[0], new LinkedHashSet<>(Arrays.asList(split)));
        });

        LICENSE_MERGE_OBJECT_LIST.forEach(licenseMerge -> {
            String mainlyLicense = licenseMerge.getMainlyLicense();
            List<String> licenseList = Arrays.asList(licenseMerge.getLicenses());
            if (map.containsKey(mainlyLicense)) {
                map.get(mainlyLicense).addAll(licenseList);
            } else {
                map.put(mainlyLicense, new LinkedHashSet<>(licenseList));
            }
        });

        list.clear();

        for (Map.Entry<String, LinkedHashSet<String>> entry: map.entrySet()) {
            list.add(String.join("|", entry.getValue()));
        }

        return list;
    }

    public static void addDefaultIncludedLicensesIfEmpty(AbstractAddThirdPartyMojo.IncludedLicenses includedLicenses) throws MojoExecutionException {
        if(CollUtil.isEmpty(includedLicenses.getData())) {
            String[] split = Const.INCLUDED_LICENSES.split("\\|");
            Arrays.stream(split).forEach(includedLicenses::setIncludedLicense);
        }
    }

    public static void addDefaultExcludedLicensesIfEmpty(AbstractAddThirdPartyMojo.ExcludedLicenses excludedLicenses) throws MojoExecutionException {
        if(CollUtil.isEmpty(excludedLicenses.getData())) {
            String[] split = Const.EXCLUDED_LICENSES.split("\\|");
            Arrays.stream(split).forEach(excludedLicenses::setExcludedLicense);
        }
    }

}
