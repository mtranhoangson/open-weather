package Training.OpenWeatherProject.models;

public class OneCallApiRootDailyTemp {
    private Double day;
    private Double min;
    private Double max;
    private Double night;
    private Double eve;
    private Double morn;

    public Double getDay() {
        return day;
    }

    public void setDay(Double day) {
        this.day = day;
    }

    public Double getMin(Integer sts) {
        // Celsius to Fahrenheit formula
        // °F =°C * 1.8000+ 32.00
        if ( sts == 2) {
            return min * 1.8 + 32;
        } else {
            return min;
        }
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMax(Integer sts) {
        // Celsius to Fahrenheit formula
        // °F =°C * 1.8000+ 32.00
        if ( sts == 2) {
            return max * 1.8 + 32;
        } else {
            return max;
        }
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public Double getNight() {
        return night;
    }

    public void setNight(Double night) {
        this.night = night;
    }

    public Double getEve() {
        return eve;
    }

    public void setEve(Double eve) {
        this.eve = eve;
    }

    public Double getMorn() {
        return morn;
    }

    public void setMorn(Double morn) {
        this.morn = morn;
    }
}
