package ru.pavlenko.julia.weatherapp.util;

public interface Consumer<T> {
    void apply(T value);
}
