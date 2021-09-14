/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service.type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Defines HostFilesType.
 * <p>
 * This class gives the possibility to read different file formats. These regexes could be registered in the database, for example.
 */
public enum HostFilesType {

    DEFAULT("([a-z]{1,3}[0-9]{1,4})", ".*\\|(.+)", "([0-9,\\.]{1,5}),");

    HostFilesType(final String pHostNamePattern, final String pValuesPattern, final String pValuePattern) {
        hostNamePattern = pHostNamePattern;
        valuesPattern = pValuesPattern;
        valuePattern = pValuePattern;
    }

    final private String hostNamePattern;

    final private String valuesPattern;

    final private String valuePattern;

    public String getHostNamePattern() {
        return hostNamePattern;
    }

    public String getValuesPattern() {
        return valuesPattern;
    }

    public String getValuePattern() {
        return valuePattern;
    }

}
