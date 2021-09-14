/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service.singleton;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Provides methods related to processing values.
 */
public class ValueBusinessSingleton {

    /**
     * Instance
     */
    private static ValueBusinessSingleton singleInstance = null;

    /**
     * Provides an instance of {@link ValueBusinessSingleton}
     *
     * @return
     */
    public static ValueBusinessSingleton getInstance() {
        if (singleInstance == null) {
            singleInstance = new ValueBusinessSingleton();
        }

        return singleInstance;
    }

    /**
     * Private constructor to this Singleton class.
     */
    private ValueBusinessSingleton() {
    }

    /**
     * Return the average value of the values
     * Be aware with RoundingMode.HALF_UP
     *
     * @param pValues
     * @param pScale
     * @return
     */
    public static BigDecimal average(final List<BigDecimal> pValues, final int pScale) {

        // avoiding nullPointerException
        if (pValues == null || pValues.isEmpty()) {
            return null;
        }

        BigDecimal sum = pValues.stream()
                .map(Objects::requireNonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum.setScale(pScale, RoundingMode.HALF_UP).divide(new BigDecimal(pValues.size()), RoundingMode.UP);
    }

    /**
     * Return the highest value of the List.
     *
     * @param pValues
     * @return
     */
    public static BigDecimal getMaxValue(final List<BigDecimal> pValues) {

        // avoiding nullPointerException
        if (pValues == null || pValues.isEmpty()) {
            return null;
        }
        Optional<BigDecimal> max = pValues.stream()
                .max(Comparator.naturalOrder());

        // no need to include isPresent here
        return max.get();
    }

    /**
     * Return the lowest value of the List
     *
     * @param pValues
     * @return
     */
    public static BigDecimal getMinValue(final List<BigDecimal> pValues) {

        // avoiding nullPointerException
        if (pValues == null || pValues.isEmpty()) {
            return null;
        }
        Optional<BigDecimal> min = pValues.stream()
                .min(Comparator.naturalOrder());

        // no need to include isPresent here
        return min.get();
    }

}
