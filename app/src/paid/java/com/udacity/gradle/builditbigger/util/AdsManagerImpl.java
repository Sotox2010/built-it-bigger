package com.udacity.gradle.builditbigger.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.FrameLayout;

import com.udacity.gradle.builditbigger.OnAdClosedListener;

public class AdsManagerImpl implements AdsManager {

    @NonNull
    private OnAdClosedListener mAdClosedListener;

    public AdsManagerImpl(@NonNull Context context, @NonNull OnAdClosedListener adClosedListener) {
        mAdClosedListener = adClosedListener;
    }

    @Override
    public void setupAdView(FrameLayout adViewContainer) {
        adViewContainer.setVisibility(View.GONE);
    }

    @Override
    public void showInterstitialAd() {
        mAdClosedListener.onAdClosed();
    }
}
