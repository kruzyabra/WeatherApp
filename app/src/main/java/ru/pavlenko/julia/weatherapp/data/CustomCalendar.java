package ru.pavlenko.julia.weatherapp.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CustomCalendar {
    public static String getCurrentDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        return DaysOfWeek.values()[dayOfWeek - 1].getDescription();
    }

    public static String getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("H:mm");

        return simpleDateFormat.format(calendar.getTime());
    }

    public static int getCurrentDayNumber() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        return dayOfWeek;
    }
}
