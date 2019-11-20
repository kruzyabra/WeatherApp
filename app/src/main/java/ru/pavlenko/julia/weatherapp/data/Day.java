package ru.pavlenko.julia.weatherapp.data;

import java.util.Date;
import java.util.Random;

public class Day {
    private int dayTemperature;
    private int nightTemperature;
    private int humidity;
    private int windSpeed;
    private DaysOfWeek dayOfWeek;
    private Date date;

    public Day() {
        Random random = new Random();

        this.dayTemperature = random.nextInt(31) - 15;
        this.nightTemperature = random.nextInt(21) - 10;
        this.humidity = random.nextInt(101);
        this.windSpeed = random.nextInt(5) + 1;
        this.dayOfWeek = DaysOfWeek.randomDayOfWeek();
        this.date = new Date();
    }

    public String getDayTemperature() {
        return String.valueOf(dayTemperature) + "°C";
    }

    public String getHumidity() {
        return String.valueOf(humidity) + "%";
    }

    public String getWindSpeed() {
        return String.valueOf(windSpeed) + " km/h";
    }

    public String getNightTemperature() {
        return String.valueOf(nightTemperature) + "°C";
    }

    public String getDayOfWeek() {
        return dayOfWeek.getDescription();
    }

    public void setDayOfWeek(DaysOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
