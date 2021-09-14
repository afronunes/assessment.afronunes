/**
 * Name: Afro Netto Nunes Faria
 * Date: 21-09-14
 */
package com.enterprisealumni.assessment.afronunes.service.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Represents a Dara Transfer Object for {@link com.enterprisealumni.assessment.afronunes.service.bo.Host}
 */
@Data
public class HostDTO implements Comparable<HostDTO>{

    private String name;
    private BigDecimal average;
    private BigDecimal max;
    private BigDecimal min;

    @Override
    public int compareTo(HostDTO o) {
        return this.getAverage().compareTo(o.getAverage());
    }

    /**
     * Model
     * n10: Average: 55.0 Max: 85.2 Min: 12.1
     */
    public String getFullInfo() {
        return String.format("%s: Average: %s Max: %s Min: %s ", name, average.toString(), max.toString(), min.toString());
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
