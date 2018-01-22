package com.example.nixus.stocks;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by nixus on 22.01.2018.
 */

public class Utils {

    public static boolean isNetworkAvailable() {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) App.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE));
        assert connectivityManager != null;
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
