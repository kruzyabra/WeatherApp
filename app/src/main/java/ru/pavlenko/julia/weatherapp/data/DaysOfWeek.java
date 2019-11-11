package ru.pavlenko.julia.weatherapp.data;

import java.util.Random;

public enum DaysOfWeek {
    SUNDAY("вс"),
    MONDAY("пн"),
    TUESDAY("вт"),
    WEDNESDAY("ср"),
    THURSDAY("чт"),
    FRIDAY("пт"),
    SATURDAY("сб");

    private String description;

    private static Random random = new Random();

    DaysOfWeek(String description) {
        this.description = description;
    }

    public static DaysOfWeek randomDayOfWeek() {
        int pick = random.nextInt(DaysOfWeek.values().length);
        return DaysOfWeek.values()[pick];
    }

    public String getDescription() {
        return description;
    }
}
