package com.song.reviewlitepal;

import android.app.Application;

import org.litepal.LitePal;

public class LitePalApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }
}
