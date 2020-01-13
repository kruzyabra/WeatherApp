package ru.pavlenko.julia.weatherapp.geonames;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.pavlenko.julia.weatherapp.BuildConfig;
import ru.pavlenko.julia.weatherapp.util.Consumer;

public class GeoNamesRepositoryImpl implements GeoNamesRepository {
    private GeoNamesApi mApi;

    public GeoNamesRepositoryImpl() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.GN_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .callbackExecutor(Executors.newFixedThreadPool(4))
                .client(okHttpClient)
                .build();

       mApi = retrofit.create(GeoNamesApi.class);
    }

    @Override
    public void getListing(String nameStartWith, final Consumer<List<String>> geoNames) {
        mApi.getListing(nameStartWith,
                GeoNamesParam.ORDER_BY.getValue(),
                BuildConfig.GN_API_USERNAME,
                GeoNamesParam.COUNTRY.getValue())
                .enqueue(new Callback<Listing>() {
                    @Override
                    public void onResponse(Call<Listing> call, Response<Listing> response) {
                        List<City> listing= response.body().getCities();

                        List<String> cities = new ArrayList<>();

                        for (City city : listing) {
                            cities.add(city.name + ", " + city.countryName);
                        }

                        geoNames.apply(cities);
                    }

                    @Override
                    public void onFailure(Call<Listing> call, Throwable t) {

                    }
                });
    }
}
