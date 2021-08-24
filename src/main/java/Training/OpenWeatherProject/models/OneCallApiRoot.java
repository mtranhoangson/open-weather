package Training.OpenWeatherProject.models;

import java.io.Serializable;
import java.util.List;

public class OneCallApiRoot implements Serializable {
    private Double lat;
    private Double lon;
    private String timezone;
    private Integer timezone_offset;
    private OneCallApiRootCurrent current;
    private List<OneCallApiRootMinutely> minutely;
    private List<OneCallApiRootHourly> hourly;
    private List<OneCallApiRootDaily> daily;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Integer getTimezone_offset() {
        return timezone_offset;
    }

    public void setTimezone_offset(Integer timezone_offset) {
        this.timezone_offset = timezone_offset;
    }

    public OneCallApiRootCurrent getCurrent() {
        return current;
    }

    public void setCurrent(OneCallApiRootCurrent current) {
        this.current = current;
    }

    public List<OneCallApiRootMinutely> getMinutely() {
        return minutely;
    }

    public void setMinutely(List<OneCallApiRootMinutely> minutely) {
        this.minutely = minutely;
    }

    public List<OneCallApiRootHourly> getHourly() {
        return hourly;
    }

    public void setHourly(List<OneCallApiRootHourly> hourly) {
        this.hourly = hourly;
    }

    public List<OneCallApiRootDaily> getDaily() {
        return daily;
    }

    public void setDaily(List<OneCallApiRootDaily> daily) {
        this.daily = daily;
    }
}
