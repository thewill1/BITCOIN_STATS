package com.moneyTap.bitcoin.Response;

import java.math.BigDecimal;

public class Data {
    private long time;
    private BigDecimal close;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal open;
    private BigDecimal volumefrom;
    private BigDecimal volumeto;

    public long getTime() {
        return time;
    }

    public void setTime(final long time) {
        this.time = time;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(final BigDecimal close) {
        this.close = close;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(final BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(final BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(final BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getVolumefrom() {
        return volumefrom;
    }

    public void setVolumefrom(final BigDecimal volumefrom) {
        this.volumefrom = volumefrom;
    }

    public BigDecimal getVolumeto() {
        return volumeto;
    }

    public void setVolumeto(final BigDecimal volumeto) {
        this.volumeto = volumeto;
    }
}
