package com.example.sugandhkumar.payme.service;

import android.util.Log;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

/**
 * Created by Sugandh kumar on 04-02-2018.
 */

public class PaymeService {
    private static final String TAG = "MyFirebaseIIDService";


    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = "token"; /*FirebaseMessaging.getInstance().getToken();*/
        FirebaseMessaging.getInstance().subscribeToTopic("all");
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        /* If you want to send messages to this application instance or manage this apps subscriptions on the server side, send the Instance ID token to your app server.*/

        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String refreshedToken) {
        Log.d("TOKEN ", refreshedToken);
    }
}
