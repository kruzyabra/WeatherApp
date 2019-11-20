package ru.pavlenko.julia.weatherapp.openweathermap;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherData {

    @SerializedName("weather") List<Weather> weather;
    @SerializedName("main") Main main;
    @SerializedName("wind") Wind wind;
    @SerializedName("timezone") long timezone;

    public Weather getWeather(){
        if (weather.size() >= 1) {
            return weather.get(0);
        }

        return null;
    }

    public Main getMain() {
        return main;
    }
}
