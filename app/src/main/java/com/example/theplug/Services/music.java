package com.example.theplug.Services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.example.theplug.R;

public class music extends Service {
    private MediaPlayer player;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action=intent.getAction();
        if(action.equals("play"))
        {
            if(player!=null)
            {
                player.stop();
                player.reset();
            }

            player=MediaPlayer.create(this, R.raw.muzika);
            player.start();

        }
        else if(action.equals("stop"))
        {
            player.stop();
            player.reset();
        }
        return  START_STICKY;
    }
    public music() {
    }



    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
