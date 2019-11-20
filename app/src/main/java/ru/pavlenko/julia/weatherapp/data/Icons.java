package ru.pavlenko.julia.weatherapp.data;

import ru.pavlenko.julia.weatherapp.R;

public enum Icons {
    CLEAR_SKY("01d", R.drawable.ic_clear_sky_white),
    FEW_CLOUDS("02d", R.drawable.ic_few_clouds_white),
    SCATTERED_CLOUDS("03d", R.drawable.ic_clouds_white),
    BROKEN_CLOUDS("04d", R.drawable.ic_clouds_white),
    SHOWER_RAIN("09d", R.drawable.ic_shower_rain_white),
    RAIN("10d", R.drawable.ic_rain_white),
    THUNDERSTORM("11d", R.drawable.ic_thunderstorm_white),
    SNOW("13d", R.drawable.ic_snow_white),
    MIST("50d", R.drawable.ic_mist_white);

    private String mIndex;

    private int mIcon;

    Icons(String index, int icon) {
        mIndex = index;
        mIcon = icon;
    }

    public int getIcon() {
        return mIcon;
    }

    public int getIconByIndex(String index) {
        switch (index) {
            case "01d":
                return CLEAR_SKY.getIcon();
            case "02d":
                return FEW_CLOUDS.getIcon();
            case "03d":
                return SCATTERED_CLOUDS.getIcon();
            case "04d":
                return BROKEN_CLOUDS.getIcon();
            case "09d":
                return SHOWER_RAIN.getIcon();
            case "10d":
                return RAIN.getIcon();
            case "11d":
                return THUNDERSTORM.getIcon();
            case "13d":
                return SNOW.getIcon();
            case "50d":
                return MIST.getIcon();
            default:
                return CLEAR_SKY.getIcon();
        }
    }
}
