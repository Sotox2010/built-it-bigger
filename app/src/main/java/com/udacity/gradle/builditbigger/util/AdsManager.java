package com.udacity.gradle.builditbigger.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;

public interface AdsManager {

    void setupAdView(FrameLayout adViewContainer);

    void showInterstitialAd();
}
