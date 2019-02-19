package com.jesussoto.android.jokedisplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class JokeDisplayerActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE_HTML = JokeDisplayerActivity.class.getName()
            + ".extra.joke_html";

    public static void start(FragmentActivity launcher, String htmlJoke) {
        Intent startIntent = new Intent(launcher, JokeDisplayerActivity.class);
        startIntent.putExtra(EXTRA_JOKE_HTML, htmlJoke);
        launcher.startActivity(startIntent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_displayer);

        if (!getIntent().hasExtra(EXTRA_JOKE_HTML)) {
            throw new IllegalStateException("JokeDisplayerActivity must have an extra argument "
                    + EXTRA_JOKE_HTML);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        String htmlJoke = getIntent().getStringExtra(EXTRA_JOKE_HTML);
        TextView jokeView = findViewById(R.id.jokeView);
        jokeView.setText(Html.fromHtml(htmlJoke));
    }
}
