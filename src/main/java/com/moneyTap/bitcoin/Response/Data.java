package com.moneyTap.bitcoin.Response;

public class Data {
    private int id;
    private String name;
    private String symbol;
    private String website_slug;
    private int rank;
    private long circulating_supply;
    private long total_supply;
    private long max_supply;
    private Quotes quotes;
    private String last_updated;


    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(final String symbol) {
        this.symbol = symbol;
    }

    public String getWebsite_slug() {
        return website_slug;
    }

    public void setWebsite_slug(final String website_slug) {
        this.website_slug = website_slug;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(final int rank) {
        this.rank = rank;
    }

    public long getCirculating_supply() {
        return circulating_supply;
    }

    public void setCirculating_supply(final long circulating_supply) {
        this.circulating_supply = circulating_supply;
    }

    public long getTotal_supply() {
        return total_supply;
    }

    public void setTotal_supply(final long total_supply) {
        this.total_supply = total_supply;
    }

    public long getMax_supply() {
        return max_supply;
    }

    public void setMax_supply(final long max_supply) {
        this.max_supply = max_supply;
    }

    public Quotes getQuotes() {
        return quotes;
    }

    public void setQuotes(final Quotes quotes) {
        this.quotes = quotes;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(final String last_updated) {
        this.last_updated = last_updated;
    }
}
