package com.example.theplug;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class PostsLoader extends AsyncTaskLoader<String> {
    public final static String TAG1 = "ASYNCTASKLOADER: ";
    public PostsLoader(@NonNull Context context) {
        super(context);
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
        return NetworkUtils.getPosts();
    }
}
