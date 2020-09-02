package com.example.theplug.NetworkOperations;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import com.example.theplug.NetworkOperations.NetworkUtils;

public class PostsLoader extends AsyncTaskLoader<String> {


    public final static String TAG1 = "ASYNCTASKLOADER: ";
    private String mQueryString ;
    public PostsLoader(@NonNull Context context, String queryString) {
        super(context);
        mQueryString = queryString;
        Log.i(TAG1,"vo Konstruktor na Loaderot ");
    }

    @Override
    protected void onStartLoading() {
        Log.i(TAG1,"onStartLoading ");
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        Log.i(TAG1,"vo loadInBackground");
        if(mQueryString.equals("SNEAKERS"))
        {
            return NetworkUtils.getPostsSneakers();
        }
        else if(mQueryString.equals("HOODIES"))
        {
            return NetworkUtils.getPostsHoodies();
        }
        else
            return null;
    }
}
