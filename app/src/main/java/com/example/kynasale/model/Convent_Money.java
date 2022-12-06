package com.example.kynasale.model;

import android.icu.text.NumberFormat;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Convent_Money {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String money(Double money)
    {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        String tien = nf.format(money);
        return tien.replace("$","").substring(0,tien.indexOf(".")-1)+ "\u20AB";
    }
    public static String ngay(String value)
    {
        String[] test = value.split("T");
        return test[0];
    }
    public static String date()
    {
        Date date = new Date(Calendar.getInstance().getTimeInMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time_ngay = simpleDateFormat.format(date);
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("hh:mm:ss");
        String time_gio = simpleDateFormat1.format(date);
        return time_ngay+"T"+time_gio;
    }
}
