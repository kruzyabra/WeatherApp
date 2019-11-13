package ru.pavlenko.julia.weatherapp.geonames;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GeoNamesApi {

    @GET("searchJSON?")
    Call<Listing> getListing(@Query("name_startsWith") String nameStartWith,
                             @Query("orderby") String orderBy,
                             @Query("username") String userName,
                             //@Query("maxRows") int maxRows,
                             @Query("country") String country);
}
