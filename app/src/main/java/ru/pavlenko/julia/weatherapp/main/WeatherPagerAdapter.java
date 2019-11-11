package ru.pavlenko.julia.weatherapp.main;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import ru.pavlenko.julia.weatherapp.plaselist.PlaceListFragment;

public class WeatherPagerAdapter extends FragmentPagerAdapter {
    private static final int FRAGMENT_NUMBER = 1;

    public WeatherPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        PlaceListFragment mPlaceListFragment = new PlaceListFragment();

        return mPlaceListFragment;
    }

    @Override
    public int getCount() {
        return FRAGMENT_NUMBER;
    }
}
