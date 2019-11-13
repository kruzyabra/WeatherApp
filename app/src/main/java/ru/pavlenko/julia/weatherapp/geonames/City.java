package ru.pavlenko.julia.weatherapp.geonames;

import com.google.gson.annotations.SerializedName;

public class City {
    @SerializedName("toponymName") public String toponymName;
    @SerializedName("countryCode") public String countryCode;
    @SerializedName("name")        public String name;
    @SerializedName("countryName") public String countryName;
}
