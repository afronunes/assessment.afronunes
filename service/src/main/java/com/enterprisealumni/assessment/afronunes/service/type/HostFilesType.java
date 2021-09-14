/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service.type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Defines HostFilesType.
 *
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

    public static void main(String[] args) {
        String a = "n34,1366829460,1366831260,60|48.0,46.0,75.0,95.0,71.0,63.0,36.0,59.0,76.0,100.0,79.0,61.0,79.0,60.0,94.0,98.0,56.0,76.0,68.0,92.0,97.0,99.0,68.0,72.0,63.0,98.0,74.0,98.0,58.0,91.0";

        final Pattern hostNamePattern = Pattern.compile(HostFilesType.DEFAULT.hostNamePattern);
        Matcher matcher = hostNamePattern.matcher(a);
        if (matcher.find()) {
            System.out.println(matcher.group());
        }

        Pattern patternValues = Pattern.compile(HostFilesType.DEFAULT.valuesPattern);
        Matcher matcherValues = patternValues.matcher(a);
        if (matcherValues.find()) {
            Pattern patternValue = Pattern.compile(HostFilesType.DEFAULT.valuePattern);
            Matcher matcherValue = patternValue.matcher(matcherValues.group(1));

            while (matcherValue.find()){
               System.out.println(matcherValue.group(1));
            }

        }
    }

}
