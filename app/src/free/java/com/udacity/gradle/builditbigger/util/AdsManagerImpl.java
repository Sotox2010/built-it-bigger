package com.udacity.gradle.builditbigger.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.OnAdClosedListener;
import com.udacity.gradle.builditbigger.R;

public class AdsManagerImpl extends AdListener implements AdsManager {

    private InterstitialAd mInterstitialAd;

    private OnAdClosedListener mAdClosedListener;

    public AdsManagerImpl(@NonNull Context context, @NonNull OnAdClosedListener adClosedListener) {
        mInterstitialAd = new InterstitialAd(context);
        mInterstitialAd.setAdUnitId(context.getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.setAdListener(this);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mAdClosedListener = adClosedListener;
    }

    @Override
    public void setupAdView(FrameLayout adViewContainer) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);

        AdView adView = new AdView(adViewContainer.getContext());
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(adViewContainer.getContext().getString(R.string.banner_ad_unit_id));

        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.setVisibility(View.VISIBLE);
        adView.loadAd(adRequest);

        adViewContainer.addView(adView, params);
    }

    @Override
    public void showInterstitialAd() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
            mAdClosedListener.onAdClosed();
        }
    }

    @Override
    public void onAdClosed() {
        super.onAdClosed();
        // Load the next interstitial.
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mAdClosedListener.onAdClosed();
    }
}
