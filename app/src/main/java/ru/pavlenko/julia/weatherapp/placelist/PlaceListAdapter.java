package ru.pavlenko.julia.weatherapp.placelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.pavlenko.julia.weatherapp.R;
import ru.pavlenko.julia.weatherapp.data.Place;
import ru.pavlenko.julia.weatherapp.data.PlaceList;

public class PlaceListAdapter extends RecyclerView.Adapter<PlaceListAdapter.PlaceListViewHolder> {
    private Context mContext;

    private List<Place> mPlaceList;

    private OnPlaceClickListener mListener;

    public PlaceListAdapter(Context context) {
        mContext = context;
        mPlaceList = PlaceList.getInstance().getPlaces();
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceListViewHolder holder, int position) {
        holder.mPlaceName.setText(mPlaceList.get(position).getName());
        holder.mPlaceTemperature.setText(mPlaceList.get(position).getCurrentDay().getDayTemperature());
        // Добавить текущее время
        holder.mPlaceCountry.setText(mPlaceList.get(position).getCountry());

        holder.setListener(mListener, position);
    }

    public void setListener(OnPlaceClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public PlaceListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_place_list, parent, false);
        return new PlaceListViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return mPlaceList.size();
    }

    static class PlaceListViewHolder extends RecyclerView.ViewHolder{
        private TextView mPlaceName;
        private TextView mPlaceCountry;
        private TextView mPlaceTemperature;

        private View mView;

        public PlaceListViewHolder(@NonNull View itemView) {
            super(itemView);

            mView = itemView;

            mPlaceName = itemView.findViewById(R.id.place_name);
            mPlaceCountry = itemView.findViewById(R.id.place_country);
            mPlaceTemperature = itemView.findViewById(R.id.place_temperature);
        }

        public void setListener(final OnPlaceClickListener listener, final int position) {
            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnItemClick(position);
                }
            });
        }

    }
}
