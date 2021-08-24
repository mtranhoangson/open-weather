package Training.OpenWeatherProject.models;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class OneCallApiRootDaily {
    private LocalDateTime dt;
    private LocalDateTime sunrise;
    private LocalDateTime sunset;
    private LocalDateTime moonrise;
    private LocalDateTime moonset;
    private Double moon_phase;
    private OneCallApiRootDailyTemp temp;
    private OneCallApiRootDailyFeelsLike feels_like;
    private Double pressure;
    private Double humidity;
    private Double dew_point;
    private Double wind_speed;
    private Double wind_deg;
    private Double wind_gust;
    private List<OneCallApiRootWeather> weather;
    private Double clouds;
    private Double pop;
    private Double rain;
    private Double uvi;

    public LocalDateTime getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        Instant instant = Instant.ofEpochMilli(1000 * dt);
        LocalDateTime localDateTime = instant.atZone(ZoneId.of("Japan")).toLocalDateTime();
        this.dt = localDateTime;
    }

    public LocalDateTime getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        Instant instant = Instant.ofEpochMilli(1000 * sunrise);
        LocalDateTime localDateTime = instant.atZone(ZoneId.of("Japan")).toLocalDateTime();
        this.sunrise = localDateTime;
    }

    public LocalDateTime getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        Instant instant = Instant.ofEpochMilli(1000 * sunset);
        LocalDateTime localDateTime = instant.atZone(ZoneId.of("Japan")).toLocalDateTime();
        this.sunset = localDateTime;
    }

    public LocalDateTime getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(Long moonrise) {
        Instant instant = Instant.ofEpochMilli(1000 * moonrise);
        LocalDateTime localDateTime = instant.atZone(ZoneId.of("Japan")).toLocalDateTime();
        this.moonrise = localDateTime;
    }

    public LocalDateTime getMoonset() {
        return moonset;
    }

    public void setMoonset(Long moonset) {
        Instant instant = Instant.ofEpochMilli(1000 * moonset);
        LocalDateTime localDateTime = instant.atZone(ZoneId.of("Japan")).toLocalDateTime();
        this.moonset = localDateTime;
    }

    public Double getMoon_phase() {
        return moon_phase;
    }

    public void setMoon_phase(Double moon_phase) {
        this.moon_phase = moon_phase;
    }

    public OneCallApiRootDailyTemp getTemp() {
        return temp;
    }

    public void setTemp(OneCallApiRootDailyTemp temp) {
        this.temp = temp;
    }

    public OneCallApiRootDailyFeelsLike getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(OneCallApiRootDailyFeelsLike feels_like) {
        this.feels_like = feels_like;
    }

    public Double getPressure(Integer sts) {
        if ( sts == 1) {
            // in hPa
            return pressure;
        } else {
            // Convert hPa to inHg
            // 1 hpa to inHg = 0.02953 inHg
            return pressure * 0.02953;
        }
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getDew_point() {
        return dew_point;
    }

    public void setDew_point(Double dew_point) {
        this.dew_point = dew_point;
    }

    public Double getWind_speed(Integer sts) {
        // m/s to km/h and mph
        if ( sts == 1) {
            return wind_speed;
        } else if (sts == 2) {
            // 1 meter/second is equal to 3.6 km/h
            return wind_speed * 3.6;
        } else {
            // 1 meter/second is equal to 2.2369362920544 mph
            return wind_speed * 2.23694;
        }
    }

    public void setWind_speed(Double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public Double getWind_deg() {
        return wind_deg;
    }

    public void setWind_deg(Double wind_deg) {
        this.wind_deg = wind_deg;
    }

    public Double getWind_gust() {
        return wind_gust;
    }

    public void setWind_gust(Double wind_gust) {
        this.wind_gust = wind_gust;
    }

    public List<OneCallApiRootWeather> getWeather() {
        return weather;
    }

    public void setWeather(List<OneCallApiRootWeather> weather) {
        this.weather = weather;
    }

    public Double getClouds() {
        return clouds;
    }

    public void setClouds(Double clouds) {
        this.clouds = clouds;
    }

    public Double getPop() {
        return pop;
    }

    public void setPop(Double pop) {
        this.pop = pop;
    }

    public Double getRain(Integer sts) {
        if ( sts == 1) {
            // in mm
            if (rain != null) {
                return rain;
            } else {
                return 0.0;
            }
        } else {
            // Convert mm to inches
            if (rain != null) {
                return rain * 0.039370;
            } else {
                return 0.0;
            }
        }
    }

    public void setRain(Double rain) {
        this.rain = rain;
    }

    public Double getUvi() {
        return uvi;
    }

    public void setUvi(Double uvi) {
        this.uvi = uvi;
    }
}
