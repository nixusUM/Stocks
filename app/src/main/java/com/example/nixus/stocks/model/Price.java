package com.example.nixus.stocks.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Price {

    @SerializedName("amount")
    private float amount;
    @SerializedName("currency")
    private String currency;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
