package com.example.nixus.stocks.api;

import com.example.nixus.stocks.model.Stocks;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by nixus on 22.01.2018.
 */

public interface StocksApi {

    @GET("/stocks.json")
    Call<Stocks> getStocks();
}

