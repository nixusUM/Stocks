package com.example.nixus.stocks.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Stocks {

    @SerializedName("as_of")
    private String asOf;
    @SerializedName("stock")
    private List<com.example.nixus.stocks.model.Stock> stock;

    public String getAsOf() {
        return asOf;
    }

    public void setAsOf(String asOf) {
        this.asOf = asOf;
    }

    public List<com.example.nixus.stocks.model.Stock> getStock() {
        return stock;
    }

    public void setStock(List<com.example.nixus.stocks.model.Stock> stock) {
        this.stock = stock;
    }

}
