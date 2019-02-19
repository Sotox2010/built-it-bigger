package com.udacity.gradle.builditbigger.util;

import android.view.View;
import android.widget.FrameLayout;

public class AdsManagerImpl implements AdsManager {

    @Override
    public void setupAdView(FrameLayout adViewContainer) {
        adViewContainer.setVisibility(View.GONE);
    }
}
