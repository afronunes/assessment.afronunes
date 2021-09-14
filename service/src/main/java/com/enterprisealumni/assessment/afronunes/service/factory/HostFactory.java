/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service.factory;

import com.enterprisealumni.assessment.afronunes.service.bo.Host;
import com.enterprisealumni.assessment.afronunes.service.singleton.ValueBusinessSingleton;
import com.enterprisealumni.assessment.afronunes.service.type.HostFilesType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Factory responsible to provide methods related {@link Host}
 */
public class HostFactory {

    final static int DEFAULT_HOST_VALUE_SCALE = 2;

    /**
     * Instance
     */
    private static HostFactory singleInstance = null;

    /**
     * Provides an instance of {@link HostFactory}
     *
     * @return
     */
    public HostFactory getInstance() {
        if (singleInstance == null) {
            singleInstance = new HostFactory();
        }

        return singleInstance;
    }

    /**
     * Create a {@link Host} having a String and a {@link HostFilesType}.
     *
     * @param pLineModel
     * @param pHostFileType
     * @return
     */
    public static Host createHost(final String pLineModel, final HostFilesType pHostFileType) {

        // create new host instance
        final Host host = new Host();

        // goes after host name on file
        final Pattern hostNamePattern = Pattern.compile(pHostFileType.getHostNamePattern());
        final Matcher hostNameMatcher = hostNamePattern.matcher(pLineModel);
        if (!hostNameMatcher.find()) {
            // no host here.
            return null;
        }
        host.setName(hostNameMatcher.group(1));

        // goes after values on file
        final Pattern valuesPattern = Pattern.compile(pHostFileType.getValuesPattern());
        final Matcher matcherValues = valuesPattern.matcher(pLineModel);

        if (matcherValues.find()) {
            final Pattern patternValue = Pattern.compile(pHostFileType.getValuePattern());
            final Matcher matcherValue = patternValue.matcher(matcherValues.group(1));

            final List<BigDecimal> values = new ArrayList<>();
            while (matcherValue.find()) {
                values.add(new BigDecimal(matcherValue.group(1)));
            }

            final ValueBusinessSingleton valueBusinessSingleton = ValueBusinessSingleton.getInstance();

            // could use values.sort and get first and last here but is a good opportunity to exemplify a Singleton
            // set rest of attr
            host.setMax(valueBusinessSingleton.getMaxValue(values));
            host.setMin(valueBusinessSingleton.getMinValue(values));
            host.setAverage(valueBusinessSingleton.average(values, DEFAULT_HOST_VALUE_SCALE));

        }
        return host;
    }

}
