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

    private List<BigDecimal> values = new ArrayList<>();

    @Test
    public void averageTest() {

        final BigDecimal expected = new BigDecimal("10619.17");

        values.add(new BigDecimal("14554"));
        values.add(new BigDecimal("7899.5"));
        values.add(new BigDecimal("12124.05"));
        values.add(new BigDecimal("7899.10"));
        assertTrue(utilSingleton.average(values, 2).compareTo(expected) == 0);
    }

}