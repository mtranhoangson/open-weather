package Training.OpenWeatherProject.models;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ForecastWeatherCity {
    private Long id;
    private String name;
    private ForecastWeatherCityCoord coord;
    private String country;
    private Long population;
    private Long timezone;
    private LocalDateTime sunrise;
    private LocalDateTime sunset;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ForecastWeatherCityCoord getCoord() {
        return coord;
    }

    public void setCoord(ForecastWeatherCityCoord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getTimezone() {
        return timezone;
    }

    public void setTimezone(Long timezone) {
        this.timezone = timezone;
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
}
