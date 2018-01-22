package com.example.nixus.stocks.simpleMvp;

/**
 * Created by nixus on 22.01.2018.
 */

public class BasePresenter<V> {

    protected V view;

    public void attachView(V view) {
        this.view = view;
    }
}