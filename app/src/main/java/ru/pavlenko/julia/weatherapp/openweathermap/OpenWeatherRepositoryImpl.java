package ru.pavlenko.julia.weatherapp.openweathermap;

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

public class OpenWeatherRepositoryImpl implements OpenWeatherRepository {
    private OpenWeatherApi mApi;

    public OpenWeatherRepositoryImpl() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.OW_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .callbackExecutor(Executors.newFixedThreadPool(4))
                .client(okHttpClient)
                .build();

        mApi = retrofit.create(OpenWeatherApi.class);
    }

    @Override
    public void getWeatherData(String name, String country, final Consumer<WeatherData> weatherData) {
        mApi.getWeatherData(name,
                BuildConfig.OW_API_KEY)
                .enqueue(new Callback<WeatherData>() {
                    @Override
                    public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                        weatherData.apply(response.body());

                    }

                    @Override
                    public void onFailure(Call<WeatherData> call, Throwable t) {
                        String str = "";
                    }
                });

    }
}
