package com.enterprisealumni.assessment.afronunes.controller.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Represents a Dara Transfer Object for {@link com.enterprisealumni.assessment.afronunes.service.bo.Host}
 */
@Data
public class HostDTO implements Comparable<HostDTO>{

    private String name;

    private BigDecimal min;

    private BigDecimal max;

    private BigDecimal average;

    /**
     * Model
     * n10: Average: 55.0 Max: 85.2 Min: 12.1
     */
    @Override
    public String toString() {
        return String.format("%s: Average: %s Max: %s Min: %s \n", name, average.toString(), max.toString(), min.toString());
    }

    @Override
    public int compareTo(HostDTO o) {
        return this.getAverage().compareTo(o.getAverage());
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

}
