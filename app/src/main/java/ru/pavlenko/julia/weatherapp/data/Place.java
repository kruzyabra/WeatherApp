package ru.pavlenko.julia.weatherapp.data;

import java.util.List;

public class Place {
    final int CURRENT_DAY_NUMBER = 0;

    private String name;
    private String country;
    private int timeZone;
    private List<Day> week;

    public Place() {
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getTimeZone() {
        return timeZone;
    }

    public List<Day> getWeek() {
        return week;
    }

    public Day getCurrentDay() {
        return week.get(CURRENT_DAY_NUMBER);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeZone(int timeZone) {
        this.timeZone = timeZone;
    }

    public void setWeek(List<Day> week) {
        this.week = week;
    }
}
