package com.example.theplug.Activities;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import com.example.theplug.BroadcastReceiver.NotificationReceiver;
import com.example.theplug.R;
import com.example.theplug.RecyclerView.Shop;
import com.example.theplug.Services.music;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.SystemClock;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private Button mPlay , mPause,notifCancel;

    private NotificationManager notificationManager = null;
    private AlarmManager alarmManager = null;
    private static final int NOTIFICATION_ID = 0;
    private static final String ACTION_NOTIFY = "com.example.theplug.ACTION_NOTIFY";
    NotificationReceiver receiver = new NotificationReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("dPlug");
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        final Intent notifyIntent = new Intent(ACTION_NOTIFY);
        mPause=findViewById(R.id.stop);
        mPlay=findViewById(R.id.play);






        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, music.class);
                intent.setAction("play");
                startService(intent);
            }
        });
        mPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,music.class);
                intent.setAction("stop");
                startService(intent);
            }
        });
        ToggleButton toggle = findViewById(R.id.alarmToggle);




        boolean alarmUp = (PendingIntent.getBroadcast(this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_NO_CREATE) != null);
        toggle.setChecked(alarmUp);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String toastMessage;
                PendingIntent notifyPendingIntent = null;
                if (isChecked) {
                    toastMessage = "Notifications turned on";
                    notifyPendingIntent = PendingIntent.getBroadcast(MainActivity.this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                    //deliverNotification(MainActivity.this);
                    alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 10*1000, AlarmManager.INTERVAL_FIFTEEN_MINUTES, notifyPendingIntent);
                }
                else {
                    toastMessage = "Notifications turned off";

                    notifyPendingIntent = PendingIntent.getBroadcast(MainActivity.this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_NO_CREATE);
                    alarmManager.cancel(notifyPendingIntent);
                    notificationManager.cancelAll();
                    notifyPendingIntent.cancel();
                }
                Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();
            }
        });



        final Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String keyWord;
                if(spinner.getSelectedItem().equals("NO CATEGORY SELECTED")){
                    Toast.makeText(getApplicationContext(), "Please select a category from the shop", Toast.LENGTH_LONG).show();
                }
                else if(spinner.getSelectedItem().equals("SNEAKERS")){
                    String product=spinner.getSelectedItem().toString();
                    Intent intent = new Intent(MainActivity.this, Shop.class);
                    intent.putExtra("kluc",product);
                    startActivity(intent);
                }
                else if(spinner.getSelectedItem().equals("HOODIES")){
                    String product=spinner.getSelectedItem().toString();
                    Intent intent = new Intent(MainActivity.this,Shop.class);
                    intent.putExtra("kluc",product);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.settings) {
            Toast.makeText(this, "Clicked on settings", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.profile)
        {
            Intent intent = new Intent(this, Profile.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


}
