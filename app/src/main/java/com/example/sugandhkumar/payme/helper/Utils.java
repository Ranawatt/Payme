package com.example.sugandhkumar.payme.helper;

import android.content.Context;
import android.net.ConnectivityManager;

import androidx.annotation.NonNull;

public class Utils {

    public static boolean isNetworkAvailable(@NonNull Context context) {
        ConnectivityManager conMan = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return conMan.getActiveNetworkInfo() != null && conMan.getActiveNetworkInfo().isConnected();
    }
}
