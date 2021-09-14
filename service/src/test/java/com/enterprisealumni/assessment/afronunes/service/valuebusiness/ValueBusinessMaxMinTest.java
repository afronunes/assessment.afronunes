/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service.valuebusiness;

import com.enterprisealumni.assessment.afronunes.service.singleton.ValueBusinessSingleton;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The purpose of this class is to test functions  {@link ValueBusinessSingleton#getMaxValue(List)} and {@link ValueBusinessSingleton#getMinValue(List)}.
 */
public class ValueBusinessMaxMinTest {

    final static ValueBusinessSingleton utilSingleton = ValueBusinessSingleton.getInstance();

    private List<BigDecimal> values = new ArrayList<>();

    private BigDecimal MIN_EXPECTED = new BigDecimal(28);

    private BigDecimal MAX_EXPECTED = new BigDecimal(100);

    @Before
    public void setUp() throws Exception {

        final String valuesString = "37.0,65.0,87.0,41.0,100.0,76.0,83.0,82.0,50.0,54.0,46.0,28.0,68.0,69.0,94.0,90.0,57.0,47.0,94.0,83.0,79.0,85.0,99.0,77.0,85.0,70.0,91.0,88.0,64.0,89.0";
        List<String> myList = new ArrayList<String>(Arrays.asList(valuesString.split(",")));
        myList.forEach(valueString ->{
            values.add(new BigDecimal(valueString));
        });
    }

    @Test
    public void maxTest() {
        assertTrue(utilSingleton.getMaxValue(values).compareTo(MAX_EXPECTED) == 0);
    }

    @Test
    public void minTest() {
        assertTrue(utilSingleton.getMinValue(values).compareTo(MIN_EXPECTED) == 0);
    }

}