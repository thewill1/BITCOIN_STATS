package com.moneyTap.bitcoin.CustomResponse;

import java.util.Objects;

public class CustomResponseBody {
    private Double average;
    private Double median;

    public CustomResponseBody(Double average, Double median) {
        this.average = average;
        this.median = median;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(final Double average) {
        this.average = average;
    }

    public Double getMedian() {
        return median;
    }

    public void setMedian(final Double median) {
        this.median = median;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomResponseBody that = (CustomResponseBody) o;
        return Objects.equals(average, that.average) &&
                Objects.equals(median, that.median);
    }

    @Override
    public int hashCode() {

        return Objects.hash(average, median);
    }

    @Override
    public String toString() {
        return "CustomResponseBody{" +
                "average=" + average +
                ", median=" + median +
                '}';
    }
}
