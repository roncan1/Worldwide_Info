package com.wwi.worldwide_info;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

class WorldTimeThread extends Thread{

    String[] country;
    DateFormat df;
    int countryNum;
    Date dt;
    TimeZone tz;
    String time;

    public WorldTimeThread(int country) {
        countryNum = country;
    }

    public void run() {
        country = new String[] { "Asia/Tokyo", "Asia/Seoul", "Asia/Shanghai", "Calcutta", "Europe/Moscow", "Egypt", "Europe/Rome", "Europe/Paris", "America/Santiago", "America/New_york"};
        df = new SimpleDateFormat("HH:mm:ss");
        dt = new Date();
        tz = TimeZone.getTimeZone(country[countryNum]);
        while (true) {
            try {
                Log.d("쓰레드", "run: 오류");
                 df.setTimeZone(tz);
                 time = df.format(dt);
                 Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public String getTime() {
        return time;
    }

}
