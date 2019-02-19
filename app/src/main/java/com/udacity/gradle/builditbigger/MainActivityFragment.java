package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.jesussoto.android.jokedisplayer.JokeDisplayerActivity;
import com.udacity.gradle.builditbigger.util.AdsManager;
import com.udacity.gradle.builditbigger.util.AdsManagerImpl;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements JokeCallbacks {

    private AdsManager mAdsManager;

    private View mProgressView;

    private Button mTellJokeButton;

    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mAdsManager = new AdsManagerImpl();
        mAdsManager.setupAdView((FrameLayout) root.findViewById(R.id.adViewContainer));

        mProgressView = root.findViewById(R.id.progress_view);

        mTellJokeButton = root.findViewById(R.id.button_tell_joke);
        mTellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tellJoke();
            }
        });

        return root;
    }

    public void tellJoke() {
        setProgress(true);
        new JokeRetrieverTask(this).execute();
    }

    @Override
    public void onJokeLoaded(String joke) {
        setProgress(false);
        JokeDisplayerActivity.start(getActivity(), joke);
    }

    @Override
    public void onJokeLoadError(Exception ex) {
        //setProgress(false);
        Toast.makeText(getActivity(), ex.getMessage(), Toast.LENGTH_LONG).show();
    }

    private void setProgress(boolean inProgress) {
        mTellJokeButton.setEnabled(!inProgress);
        mProgressView.setVisibility(inProgress ? View.VISIBLE : View.GONE);
    }
}
