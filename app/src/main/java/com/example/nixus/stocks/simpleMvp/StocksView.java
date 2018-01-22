package com.example.nixus.stocks.simpleMvp;

import com.example.nixus.stocks.model.Stock;

import java.util.List;

/**
 * Created by nixus on 22.01.2018.
 */

public interface StocksView {
    void showStocks(List<Stock> stocksList);
    void showMessage(int message);
    void loading(boolean show);
}
