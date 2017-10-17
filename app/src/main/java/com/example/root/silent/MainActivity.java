package com.example.root.silent;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            long delay = 24 * 60 * 60 * 1000;
            Intent intent = new Intent(this, BRC.class);
            Calendar Scal = Calendar.getInstance();
            Scal.set(Calendar.HOUR_OF_DAY, 1);
            Scal.set(Calendar.MINUTE, 14);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, Scal.getTimeInMillis(), delay,pendingIntent);
            Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show();


        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("IST"));
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("hh:mm a");
// you can get seconds by adding  "...:ss" to it
        String localTime = date.format(currentLocalTime);
        TextView tv = (TextView)findViewById(R.id.textView);
        tv.setText(localTime);
    }
}
