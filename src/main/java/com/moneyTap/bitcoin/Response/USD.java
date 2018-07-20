package com.moneyTap.bitcoin.Response;

import java.math.BigDecimal;

public class USD {
    private BigDecimal price;
    private BigDecimal volume_24h;
    private BigDecimal market_cap;
    private BigDecimal percent_change_1h;
    private BigDecimal percent_change_24h;
    private BigDecimal percent_change_7d;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getVolume_24h() {
        return volume_24h;
    }

    public void setVolume_24h(final BigDecimal volume_24h) {
        this.volume_24h = volume_24h;
    }

    public BigDecimal getMarket_cap() {
        return market_cap;
    }

    public void setMarket_cap(final BigDecimal market_cap) {
        this.market_cap = market_cap;
    }

    public BigDecimal getPercent_change_1h() {
        return percent_change_1h;
    }

    public void setPercent_change_1h(final BigDecimal percent_change_1h) {
        this.percent_change_1h = percent_change_1h;
    }

    public BigDecimal getPercent_change_24h() {
        return percent_change_24h;
    }

    public void setPercent_change_24h(final BigDecimal percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
    }

    public BigDecimal getPercent_change_7d() {
        return percent_change_7d;
    }

    public void setPercent_change_7d(final BigDecimal percent_change_7d) {
        this.percent_change_7d = percent_change_7d;
    }
}
