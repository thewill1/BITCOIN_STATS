package com.moneyTap.bitcoin.Response;

public class Conversion {
    private String type;
    private String conversionSymbol;

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getConversionSymbol() {
        return conversionSymbol;
    }

    public void setConversionSymbol(final String conversionSymbol) {
        this.conversionSymbol = conversionSymbol;
    }
}
