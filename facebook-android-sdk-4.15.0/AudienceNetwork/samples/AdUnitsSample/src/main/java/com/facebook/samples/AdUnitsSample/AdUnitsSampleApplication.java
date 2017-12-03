package com.facebook.samples.AdUnitsSample;

import android.app.Application;

import com.facebook.samples.ads.debugsettings.DebugSettings;

public class AdUnitsSampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        DebugSettings.initialize(this);
    }
}
