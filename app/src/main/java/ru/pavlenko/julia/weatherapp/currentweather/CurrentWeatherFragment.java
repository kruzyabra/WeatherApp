package ru.pavlenko.julia.weatherapp.currentweather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ru.pavlenko.julia.weatherapp.R;
import ru.pavlenko.julia.weatherapp.data.Place;
import ru.pavlenko.julia.weatherapp.data.PlaceList;
import ru.pavlenko.julia.weatherapp.openweathermap.OpenWeatherRepository;
import ru.pavlenko.julia.weatherapp.openweathermap.OpenWeatherRepositoryImpl;
import ru.pavlenko.julia.weatherapp.openweathermap.Weather;
import ru.pavlenko.julia.weatherapp.openweathermap.WeatherData;
import ru.pavlenko.julia.weatherapp.util.Consumer;

public class CurrentWeatherFragment extends Fragment {
    private Place mPlace;

    private OpenWeatherRepository mRepository;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int position = this.getArguments().getInt("position");
        mPlace = PlaceList.getInstance().getPlaces().get(position);

        mRepository = new OpenWeatherRepositoryImpl();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_current_weather, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRepository.getWeatherData(mPlace.getName(), "RU", new Consumer<WeatherData>() {
            @Override
            public void apply(final WeatherData value) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView currentTemp = view.findViewById(R.id.current_temperature);
                        currentTemp.setText(value.getMain().getTemp());
                        TextView currentDescr = view.findViewById(R.id.current_description);
                        currentDescr.setText(value.getWeather().getMain());
                    }
                });
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_current_weather, menu);
    }


}
