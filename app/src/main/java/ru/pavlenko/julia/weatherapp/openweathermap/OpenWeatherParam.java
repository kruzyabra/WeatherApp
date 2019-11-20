package ru.pavlenko.julia.weatherapp.openweathermap;

public enum OpenWeatherParam {
    APP_ID("3587840324cb3bb02e8358bb5dad0e9d");

    private String value;

    OpenWeatherParam(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
