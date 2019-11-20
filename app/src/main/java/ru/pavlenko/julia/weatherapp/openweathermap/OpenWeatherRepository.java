package ru.pavlenko.julia.weatherapp.openweathermap;

import ru.pavlenko.julia.weatherapp.util.Consumer;

public interface OpenWeatherRepository {

    void getWeatherData(String name, String country, Consumer<WeatherData> weatherData);
}
