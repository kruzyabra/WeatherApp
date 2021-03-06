package ru.pavlenko.julia.weatherapp.geonames;

public enum GeoNamesParam {
    ORDER_BY("relevance"),
    COUNTRY("RU");

    private String value;

    GeoNamesParam(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
