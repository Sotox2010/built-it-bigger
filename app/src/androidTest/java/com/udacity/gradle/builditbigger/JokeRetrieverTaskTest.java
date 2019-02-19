package com.udacity.gradle.builditbigger;

import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static junit.framework.TestCase.assertNotNull;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class JokeRetrieverTaskTest {

    @Test
    public void testGetJokeTask() throws ExecutionException, InterruptedException {
        JokeRetrieverTask task = new JokeRetrieverTask(new JokeCallbacks() {
            @Override
            public void onJokeLoaded(String joke) {

            }

            @Override
            public void onJokeLoadError(Exception ex) {

            }
        });

        task.execute();
        String result = task.get();
        assertNotNull(result);
    }
}
