package ru.pavlenko.julia.weatherapp.plaselist;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.miguelcatalan.materialsearchview.SearchAdapter;

import java.util.List;
import java.util.Set;

import ru.pavlenko.julia.weatherapp.R;
import ru.pavlenko.julia.weatherapp.data.Place;
import ru.pavlenko.julia.weatherapp.data.PlaceList;
import ru.pavlenko.julia.weatherapp.geonames.GeoNamesRepository;
import ru.pavlenko.julia.weatherapp.geonames.GeoNamesRepositoryImpl;
import ru.pavlenko.julia.weatherapp.util.Consumer;

public class PlaceListFragment extends Fragment{
    public static final int RV_VERTICAL_SPACE = 32;

    private RecyclerView mRecyclerView;

    private PlaceListAdapter mRecyclerAdapter;

    private GeoNamesRepository mRepository;

    private MaterialSearchView mSearchView;

    private String[] mArrOfCities;

    private String mCurrentPlace;

    private Parcelable mInstanceState;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRecyclerAdapter = new PlaceListAdapter(getContext());
        mRepository = new GeoNamesRepositoryImpl();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_place_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = view.findViewById(R.id.place_list);
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addItemDecoration(new VerticalSpaceItemDecoration(RV_VERTICAL_SPACE));

        mSearchView = getActivity().findViewById(R.id.search_view);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_place_list, menu);
        MenuItem searchItem = menu.findItem(R.id.search);

        mSearchView.setMenuItem(searchItem);
        mSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                processQuery(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                processQuery(newText);
                return false;
            }
        });

        mSearchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {
                Place place = new Place();
                place.setName(mCurrentPlace);
                PlaceList.getInstance().createWeek(place);
                PlaceList.getInstance().addPlace(place);
                mCurrentPlace = "";
            }
        });

        mSearchView.setSubmitOnClick(true);
    }

    private void processQuery(String query) {
        mRepository.getListing(query, new Consumer<List<String>>() {
            @Override
            public void apply(List<String> value) {
                mArrOfCities = new String[value.size()];
                value.toArray(mArrOfCities);

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mSearchView.setSuggestions(mArrOfCities);
                    }
                });
            }
        });

        if (query != null && !query.equals(""))
            mCurrentPlace = query;
    }
}
