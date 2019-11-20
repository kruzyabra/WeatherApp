package ru.pavlenko.julia.weatherapp.openweathermap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherApi {

    @GET("data/2.5/weather?")
    Call<WeatherData> getWeatherData(@Query("q") String query,
                                     @Query("appid") String appId);
}
