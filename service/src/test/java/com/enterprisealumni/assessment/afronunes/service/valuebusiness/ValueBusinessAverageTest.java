/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service.valuebusiness;

import com.enterprisealumni.assessment.afronunes.service.singleton.ValueBusinessSingleton;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The purpose of this class is to test  {@link ValueBusinessSingleton#average(List, int)}.
 */
public class ValueBusinessAverageTest {

    final static ValueBusinessSingleton utilSingleton = ValueBusinessSingleton.getInstance();

    private final List<BigDecimal> values = new ArrayList<>();

    @Test
    public void averageTest() {

        final BigDecimal expected = new BigDecimal("72.87");

        values.add(new BigDecimal(100));
        values.add(new BigDecimal(57.0));
        values.add(new BigDecimal(84.0));
        values.add(new BigDecimal(35.0));
        values.add(new BigDecimal(87.0));
        values.add(new BigDecimal(67.0));
        values.add(new BigDecimal(66.0));
        values.add(new BigDecimal(92.0));
        values.add(new BigDecimal(39.0));
        values.add(new BigDecimal(57.0));
        values.add(new BigDecimal(65.0));
        values.add(new BigDecimal(65.0));
        values.add(new BigDecimal(60.0));
        values.add(new BigDecimal(39.0));
        values.add(new BigDecimal(89.0));
        values.add(new BigDecimal(49.0));
        values.add(new BigDecimal(71.0));
        values.add(new BigDecimal(77.0));
        values.add(new BigDecimal(89.0));
        values.add(new BigDecimal(67.0));
        values.add(new BigDecimal(74.0));
        values.add(new BigDecimal(70.0));
        values.add(new BigDecimal(52.0));
        values.add(new BigDecimal(69.0));
        values.add(new BigDecimal(88.0));
        values.add(new BigDecimal(85.0));
        values.add(new BigDecimal(99.0));
        values.add(new BigDecimal(100));
        values.add(new BigDecimal(97.0));
        values.add(new BigDecimal(97.0));

        assertTrue(ValueBusinessSingleton.average(values, 2).compareTo(expected) == 0);
    }

}