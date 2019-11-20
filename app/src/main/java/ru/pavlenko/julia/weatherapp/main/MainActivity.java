package ru.pavlenko.julia.weatherapp.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import ru.pavlenko.julia.weatherapp.R;
import ru.pavlenko.julia.weatherapp.currentweather.CurrentWeatherFragment;
import ru.pavlenko.julia.weatherapp.data.PlaceList;
import ru.pavlenko.julia.weatherapp.placelist.PlaceListFragment;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new PlaceListFragment())
                .commit();
    }

    public void openCurrentWeatherFragment(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);

        CurrentWeatherFragment fragment = new CurrentWeatherFragment();
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();

        mToolbar.setTitle(PlaceList.getInstance()
                .getPlaces().get(position)
                .getName());
    }
}
