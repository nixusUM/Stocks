package com.example.nixus.stocks;

import android.app.Application;

import com.example.nixus.stocks.api.StocksApi;

import java.util.logging.Level;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nixus on 22.01.2018.
 */

public class App extends Application {

    private static App app;
    private static StocksApi stocksApi;
    private static final String BASE_URL = "http://phisix-api3.appspot.com/";

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        stocksApi = retrofit.create(StocksApi.class);
    }

    public static App getInstance() {
        return app;
    }

    public static StocksApi getStocksApi() {
        return stocksApi;
    }
}