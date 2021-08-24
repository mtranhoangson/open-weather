package Training.OpenWeatherProject.services;

import Training.OpenWeatherProject.models.ForecastWeather;
import Training.OpenWeatherProject.models.ForecastWeatherCity;
import Training.OpenWeatherProject.models.ForecastWeatherList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

@Service
public class ForecastWeatherService {
    @Value("${forecastWeather.url}")
    private String weatherUrl;

    @Value("${weather.apikey}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public ForecastWeatherService(RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {
        this.restTemplate = restTemplateBuilder.build();
        this.objectMapper = objectMapper;
    }

    public ForecastWeather getForecastWeather(String lat, String lon) {
        URI url = new UriTemplate(weatherUrl).expand(lat, lon, apiKey);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        List<ForecastWeatherList> list;
        ForecastWeatherCity cityObj;
        ForecastWeather forecastWeather = new ForecastWeather();
        try {
            JsonNode root = objectMapper.readTree(responseEntity.getBody());

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            TypeReference<List<ForecastWeatherList>> listRef = new TypeReference<>() {};
            list = mapper.readValue(root.path("list").traverse(), listRef);

            TypeReference<ForecastWeatherCity> cityRef = new TypeReference<>() {};
            cityObj = mapper.readValue(root.path("city").traverse(), cityRef);

            forecastWeather.setCod(root.path("cod").asText());
            forecastWeather.setMessage(root.path("message").asInt());
            forecastWeather.setCnt(root.path("cnt").asInt());
            forecastWeather.setList(list);
            forecastWeather.setCity(cityObj);

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return forecastWeather;
    }
}
