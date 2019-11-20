package ru.pavlenko.julia.weatherapp.openweathermap;

import com.google.gson.annotations.SerializedName;

public class Weather {
    @SerializedName("main") String main;
    @SerializedName("icon") String icon;

    public String getMain() {
        return main;
    }

    public String getIcon() {
        return icon;
    }
}
