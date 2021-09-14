/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-13
 */
package com.enterprisealumni.assessment.afronunes.service.bo;

import java.math.BigDecimal;

/**
 * Represents a Host.
 */
public class Host implements Comparable<Host> {

    private String name;

    private BigDecimal min;

    private BigDecimal max;

    private BigDecimal average;

    @Override
    public String toString() {
        return "Host{" +
                "name='" + name + '\'' +
                ", min=" + min +
                ", max=" + max +
                ", average=" + average +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }

    public BigDecimal getAverage() {
        return average;
    }

    public void setAverage(BigDecimal average) {
        this.average = average;
    }

    @Override
    public int compareTo(Host o) {
        return 0;
    }
}
