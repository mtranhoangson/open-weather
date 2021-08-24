package Training.OpenWeatherProject.models;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class OneCallApiRootCurrent {
    private LocalDateTime dt;
    private Long sunrise;
    private Long sunset;
    private Double temp;
    private Double feels_like;
    private Double pressure;
    private Double humidity;
    private Double dew_point;
    private Double uvi;
    private Double clouds;
    private Double visibility;
    private Double wind_speed;
    private Double wind_deg;
    private Double wind_gust;
    private List<OneCallApiRootWeather> weather;

    public LocalDateTime getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        Instant instant = Instant.ofEpochMilli(1000 * dt);
        LocalDateTime localDateTime = instant.atZone(ZoneId.of("Japan")).toLocalDateTime();
        this.dt = localDateTime;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = 1000 * sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = 1000 * sunset;
    }

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

    public Double getFeels_like(Integer sts) {
        // Celsius to Fahrenheit formula
        // °F =°C * 1.8000+ 32.00
        if ( sts == 2) {
            return feels_like * 1.8 + 32;
        } else {
            return feels_like;
        }
    }

    public void setFeels_like(Double feels_like) {
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

    public Double getDew_point(Integer sts) {
        // Celsius to Fahrenheit formula
        // °F =°C * 1.8000+ 32.00
        if ( sts == 2) {
            return dew_point * 1.8 + 32;
        } else {
            return dew_point;
        }
    }

    public void setDew_point(Double dew_point) {
        this.dew_point = dew_point;
    }

    public Double getUvi() {
        return uvi;
    }

    public void setUvi(Double uvi) {
        this.uvi = uvi;
    }

    public Double getClouds() {
        return clouds;
    }

    public void setClouds(Double clouds) {
        this.clouds = clouds;
    }

    public Double getVisibility(Integer sts) {
        if ( sts == 1) {
            // Convert m to km
            return visibility / 1000;
        } else {
            // Convert m to miles
            return visibility / 1609.344;
        }
    }

    public void setVisibility(Double visibility) {
        this.visibility = visibility;
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
}
