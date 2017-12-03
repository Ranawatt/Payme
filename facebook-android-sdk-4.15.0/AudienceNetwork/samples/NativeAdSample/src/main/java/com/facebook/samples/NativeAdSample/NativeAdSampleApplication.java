package com.facebook.samples.NativeAdSample;

import android.app.Application;

import com.facebook.samples.ads.debugsettings.DebugSettings;

public class NativeAdSampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        DebugSettings.initialize(this);
    }
}
