package ru.pavlenko.julia.weatherapp.geonames;

import java.util.List;

import ru.pavlenko.julia.weatherapp.openweathermap.WeatherData;
import ru.pavlenko.julia.weatherapp.util.Consumer;

public interface GeoNamesRepository {

    void getListing(String nameStartWith, Consumer<List<String>> geoNames);
}
