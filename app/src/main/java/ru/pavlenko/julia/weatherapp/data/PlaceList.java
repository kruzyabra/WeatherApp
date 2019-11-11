package ru.pavlenko.julia.weatherapp.data;

import java.util.ArrayList;
import java.util.List;

/*
    Далее будет храниться в БД
 */
public class PlaceList {
    private static final PlaceList ourInstance = new PlaceList();
    private static final int CURRENT_DAY_NUMBER = 0;

    private List<Place> places;
    private int mainPlaceIndex;

    public static PlaceList getInstance() {
        return ourInstance;
    }

    private PlaceList() {
        this.places = new ArrayList<>();

        createList();
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setMainPlaceIndex(int mainPlaceIndex) {
        this.mainPlaceIndex = mainPlaceIndex;
    }

    public int getMainPlaceIndex() {
        return mainPlaceIndex;
    }

    private void createList() {
        this.mainPlaceIndex = 0;

        Place newPlace = new Place();
        newPlace.setName("Москва");

        List<Day> days = new ArrayList<>();
        int currentNumber = CustomCalendar.getCurrentDayNumber() - 1;
        for (int i = 0; i < 6; i++) {
            Day day = new Day();
            if ((currentNumber + i) <= (DaysOfWeek.values().length - 1)) {
                day.setDayOfWeek(DaysOfWeek.values()[currentNumber + i]);
            }
            else {
                day.setDayOfWeek(DaysOfWeek.values()[currentNumber + i - DaysOfWeek.values().length]);
            }
            days.add(day);
        }
        newPlace.setWeek(days);

        places.add(newPlace);

        newPlace = new Place();
        newPlace.setName("Омск");

        days = new ArrayList<>();
        currentNumber = CustomCalendar.getCurrentDayNumber() - 1;
        for (int i = 0; i < 6; i++) {
            Day day = new Day();
            if ((currentNumber + i) <= (DaysOfWeek.values().length - 1)) {
                day.setDayOfWeek(DaysOfWeek.values()[currentNumber + i]);
            }
            else {
                day.setDayOfWeek(DaysOfWeek.values()[currentNumber + i - DaysOfWeek.values().length]);
            }
            days.add(day);
        }
        newPlace.setWeek(days);

        places.add(newPlace);
    }

    public static int getCurrentDayNumber() {
        return CURRENT_DAY_NUMBER;
    }
}
