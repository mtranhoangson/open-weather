package Training.OpenWeatherProject.services;

import Training.OpenWeatherProject.models.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@Service
public class OneCallApiService {
    @Value("${weather.apikey}")
    private String apiKey;

    @Value("${oneCallAPI.url}")
    private String oneCallApiUrl;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public OneCallApiService(RestTemplateBuilder restTemplateBuilder, ObjectMapper objectMapper) {
        this.restTemplate = restTemplateBuilder.build();
        this.objectMapper = objectMapper;
    }

    public OneCallApiRoot getOneCallApiRoot(String lat, String lon) {
        URI url = new UriTemplate(oneCallApiUrl).expand(lat, lon, apiKey);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        OneCallApiRootCurrent current;
        List<OneCallApiRootMinutely> minutely;
        List<OneCallApiRootHourly> hourly;
        List<OneCallApiRootDaily> daily;
        OneCallApiRoot oneCallApiRoot = new OneCallApiRoot();

        try {
            JsonNode root = objectMapper.readTree(responseEntity.getBody());

            // Parsing Json
            oneCallApiRoot.setLat(root.path("lat").asDouble());
            oneCallApiRoot.setLon(root.path("lon").asDouble());
            oneCallApiRoot.setTimezone(root.path("timezone").asText());
            oneCallApiRoot.setTimezone_offset(root.path("timezone_offset").asInt());

            TypeReference<OneCallApiRootCurrent> currentRef = new TypeReference<>() {};
            current = objectMapper.readValue(root.path("current").traverse(), currentRef);

            TypeReference<List<OneCallApiRootMinutely>> minutelyRef = new TypeReference<>() {};
            minutely = objectMapper.readValue(root.path("minutely").traverse(), minutelyRef);

            TypeReference<List<OneCallApiRootHourly>> hourlyRef = new TypeReference<>() {};
            hourly = objectMapper.readValue(root.path("hourly").traverse(), hourlyRef);

            TypeReference<List<OneCallApiRootDaily>> dailyRef = new TypeReference<>() {};
            daily = objectMapper.readValue(root.path("daily").traverse(), dailyRef);

            oneCallApiRoot.setCurrent(current);
            oneCallApiRoot.setMinutely(minutely);
            oneCallApiRoot.setHourly(hourly);
            oneCallApiRoot.setDaily(daily);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return oneCallApiRoot;
    }
}
