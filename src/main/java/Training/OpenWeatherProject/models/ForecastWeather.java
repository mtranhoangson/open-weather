package Training.OpenWeatherProject.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ForecastWeather implements Serializable {
    private static final long serialVersionUID = 2504173539494539777L;

    private String cod;
    private Integer message;
    private Integer cnt;
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private List<ForecastWeatherList> list = new ArrayList<>();
    private ForecastWeatherCity city;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public List<ForecastWeatherList> getList() {
        return list;
    }

    public void setList(List<ForecastWeatherList> list) {
        this.list = list;
    }

    public ForecastWeatherCity getCity() {
        return city;
    }

    public void setCity(ForecastWeatherCity city) {
        this.city = city;
    }
}
