package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.backend.jokeAPI.JokeAPI;

import java.io.IOException;

import static com.udacity.gradle.jokedisplayer.MainActivity.jokeKey;

/**
 * Created by Tanmay.godbole on 28-12-2016
 */

public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private static JokeAPI myApiService = null;
    private Context context;


    @Override
    protected String doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once
            JokeAPI.Builder builder = new JokeAPI.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://build-it-bigger-153908.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

        this.context = params[0];

        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        Intent displayIntent = new Intent(context,com.udacity.gradle.jokedisplayer.MainActivity.class);
        displayIntent.putExtra(jokeKey, result);
        context.startActivity(displayIntent);
    }
}