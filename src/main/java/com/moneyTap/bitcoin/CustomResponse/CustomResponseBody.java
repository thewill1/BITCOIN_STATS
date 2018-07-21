package com.moneyTap.bitcoin.CustomResponse;

public class CustomResponseBody {
    private Double average;
    private Double median;

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
    public String toString() {
        return "CustomResponseBody{" +
                "average=" + average +
                ", median=" + median +
                '}';
    }
}
