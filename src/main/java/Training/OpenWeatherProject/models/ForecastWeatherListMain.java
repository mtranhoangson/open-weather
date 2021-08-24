package Training.OpenWeatherProject.models;

public class ForecastWeatherListMain {

    private Double temp;
    private Integer feels_like;
    private Integer temp_min;
    private Integer temp_max;
    private Integer pressure;
    private Integer sea_level;
    private Integer grnd_level;
    private Double humidity;
    private Integer temp_kf;

    public Double getTemp(Integer sts) {
        // Celsius to Fahrenheit formula
        // °F =°C * 1.8000+ 32.00
        if ( sts == 2) {
            return temp * 1.8 + 32;
        } else {
            return temp;
        }
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Integer getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(Integer feels_like) {
        this.feels_like = feels_like;
    }

    public Integer getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(Integer temp_min) {
        this.temp_min = temp_min;
    }

    public Integer getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(Integer temp_max) {
        this.temp_max = temp_max;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getSea_level() {
        return sea_level;
    }

    public void setSea_level(Integer sea_level) {
        this.sea_level = sea_level;
    }

    public Integer getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(Integer grnd_level) {
        this.grnd_level = grnd_level;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Integer getTemp_kf() {
        return temp_kf;
    }

    public void setTemp_kf(Integer temp_kf) {
        this.temp_kf = temp_kf;
    }
}
