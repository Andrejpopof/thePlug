package com.example.theplug;

import android.net.Uri;
import android.util.Log;
import android.widget.TabHost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtils {
    private static final String BASE_URL = "https://localhost:44332/posts";

    public static final String TAG2 = "NETWORK UTILS: ";

    public static String getPosts(){
        Log.i(TAG2, "vo getPosts()");
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String json = null;

        try {

            Uri builtUri = Uri.parse(BASE_URL).buildUpon().build();
            URL url = new URL(builtUri.toString());
            Log.i(TAG2, "URL: " + url);


            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();


            InputStream inputStream = urlConnection.getInputStream();


            StringBuilder builder = new StringBuilder();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line + "\n");
            }

            if (builder.length() == 0) {

                return null;
            }
            json = builder.toString();

            // Catch errors.
        } catch (IOException e) {
            e.printStackTrace();

            // Close the connections.
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        Log.i(TAG2,"json: "+json);
        return json;

    }
}
