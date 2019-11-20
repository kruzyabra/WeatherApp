package ru.pavlenko.julia.weatherapp.openweathermap;

import com.google.gson.annotations.SerializedName;

public class Main {
    @SerializedName("temp") String temp;
    @SerializedName("pressure") String pressure;
    @SerializedName("humidity") String humidity;

    public String getTemp() {
        float tempFloat = Float.valueOf(temp) - 273.15f;
        int tempInt = Math.round(tempFloat);

        return tempInt + "°C";
    }
}
