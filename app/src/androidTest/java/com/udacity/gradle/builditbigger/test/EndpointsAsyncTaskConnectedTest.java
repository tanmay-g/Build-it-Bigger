package com.udacity.gradle.builditbigger.test;

import android.test.mock.MockContext;
import android.util.Log;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import junit.framework.TestCase;

/**
 * Created by Tanmay.godbole on 05-01-2017
 */
public class EndpointsAsyncTaskConnectedTest extends TestCase {
    private static final String LOG_TAG = "ConnectedTest";

    public void testGet() throws Exception {
        assert true;

        String joke;
        EndpointsAsyncTask e = new EndpointsAsyncTask();
        e.execute(new MockContext());
        joke = e.get();
        Log.i(LOG_TAG, "testGet: " + joke);
        assertNotNull (joke);
    }

}