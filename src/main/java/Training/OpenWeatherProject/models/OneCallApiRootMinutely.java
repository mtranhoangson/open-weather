package Training.OpenWeatherProject.models;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class OneCallApiRootMinutely {
    private LocalDateTime dt;
    private Double precipitation;

    public LocalDateTime getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        Instant instant = Instant.ofEpochMilli(1000 * dt);
        LocalDateTime localDateTime = instant.atZone(ZoneId.of("Japan")).toLocalDateTime();
        this.dt = localDateTime;
    }

    public Double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Double precipitation) {
        this.precipitation = precipitation;
    }
}
