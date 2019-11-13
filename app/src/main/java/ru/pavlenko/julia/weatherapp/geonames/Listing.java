package ru.pavlenko.julia.weatherapp.geonames;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Listing {
    @SerializedName("geonames") private List<City> geoNames;

    public List<City> getCities(){
        return geoNames;
    }
}
