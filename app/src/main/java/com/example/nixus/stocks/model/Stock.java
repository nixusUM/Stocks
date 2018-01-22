package com.example.nixus.stocks.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Stock {

    @SerializedName("name")
    private String name;
    @SerializedName("percent_change")
    private double percentChange;
    @SerializedName("price")
    private com.example.nixus.stocks.model.Price price;
    @SerializedName("symbol")
    private String symbol;
    @SerializedName("volume")
    private Long volume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(double percentChange) {
        this.percentChange = percentChange;
    }

    public com.example.nixus.stocks.model.Price getPrice() {
        return price;
    }

    public void setPrice(com.example.nixus.stocks.model.Price price) {
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

}
