package com.example.nixus.stocks.simpleMvp;

import com.example.nixus.stocks.App;
import com.example.nixus.stocks.R;
import com.example.nixus.stocks.Utils;
import com.example.nixus.stocks.model.Stocks;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nixus on 22.01.2018.
 */

public class StocksPresenter extends BasePresenter<StocksView> {

    public void getStocks() {
        if (!Utils.isNetworkAvailable()) {
            view.showMessage(R.string.network_error);
            return;
        }
        view.loading(true);
        App.getStocksApi().getStocks().enqueue(new Callback<Stocks>() {
            @Override
            public void onResponse(Call<Stocks> call, Response<Stocks> response) {
                view.loading(false);
                if (response.body() == null) {
                    view.showMessage(R.string.body_error);
                    return;
                }
                view.showMessage(R.string.success_update);
                view.showStocks(response.body().getStock());
            }

            @Override
            public void onFailure(Call<Stocks> call, Throwable t) {
                view.loading(false);
                view.showMessage(R.string.api_error);
            }
        });
    }
}