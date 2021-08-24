package Training.OpenWeatherProject.models;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class ForecastWeatherList {
    private LocalDateTime dt;
    private ForecastWeatherListMain main;
    private List<ForecastWeatherListWeather> weather;
    private ForecastWeatherListClouds clouds;
    private ForecastWeatherListWind wind;
    private String visibility;
    private Double pop;
    private ForecastWeatherListRain rain;
    private ForecastWeatherListSys sys;
    private String dt_txt;

    public LocalDateTime getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        Instant instant = Instant.ofEpochMilli(1000 * dt);
        LocalDateTime localDateTime = instant.atZone(ZoneId.of("Japan")).toLocalDateTime();
        this.dt = localDateTime;
    }

    public ForecastWeatherListMain getMain() {
        return main;
    }

    public void setMain(ForecastWeatherListMain main) {
        this.main = main;
    }

    public List<ForecastWeatherListWeather> getWeather() {
        return weather;
    }

    public void setWeather(List<ForecastWeatherListWeather> weather) {
        this.weather = weather;
    }

    public ForecastWeatherListClouds getClouds() {
        return clouds;
    }

    public void setClouds(ForecastWeatherListClouds clouds) {
        this.clouds = clouds;
    }

    public ForecastWeatherListWind getWind() {
        return wind;
    }

    public void setWind(ForecastWeatherListWind wind) {
        this.wind = wind;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Double getPop() {
        return pop;
    }

    public void setPop(Double pop) {
        this.pop = pop;
    }

    public ForecastWeatherListRain getRain() {
        return rain;
    }

    public void setRain(ForecastWeatherListRain rain) {
        this.rain = rain;
    }

    public ForecastWeatherListSys getSys() {
        return sys;
    }

    public void setSys(ForecastWeatherListSys sys) {
        this.sys = sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}
