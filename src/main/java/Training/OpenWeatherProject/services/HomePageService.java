package Training.OpenWeatherProject.services;

import Training.OpenWeatherProject.entity.User;
import Training.OpenWeatherProject.models.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Service
public class HomePageService {

    private final ForecastWeatherService forecastWeatherService;
    private final OneCallApiService oneCallApiService;
    public HomePageService(ForecastWeatherService forecastWeatherService,
                           OneCallApiService oneCallApiService) {
        this.forecastWeatherService = forecastWeatherService;
        this.oneCallApiService = oneCallApiService;
    }

    public void process(Model model, User user) {
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // One call API
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        OneCallApiRoot root = oneCallApiService.getOneCallApiRoot(user.getLat(), user.getLon());
        OneCallApiRootCurrent current = root.getCurrent();
        List<OneCallApiRootMinutely> minutely = root.getMinutely();
        List<OneCallApiRootHourly> hourly = root.getHourly();
        List<OneCallApiRootDaily> daily = root.getDaily();

        // Process precipitation chart data
        Map<String, Double> chartData = new LinkedHashMap<String, Double>();
        int idx = 0;
        double maxValue = 0;
        for (OneCallApiRootMinutely item : minutely) {

            Double tmpPrecipitation = item.getPrecipitation();
            if (user.getPrecipitation() == 1) {
                model.addAttribute("unitFormat", "<br/>mm/h");
            } else {
                // Convert mm to inches
                tmpPrecipitation *= 0.0393701;
                model.addAttribute("unitFormat", "<br/>in/h");
            }

            if (idx == 0) {
                chartData.put("now",tmpPrecipitation);
                maxValue = tmpPrecipitation;
            } else {
                chartData.put(idx + "min",tmpPrecipitation);
                if (maxValue < tmpPrecipitation) {
                    maxValue = tmpPrecipitation;
                }
            }
            idx++;
        }

        model.addAttribute("current", current);
        model.addAttribute("minutely", minutely);
        model.addAttribute("hourly", hourly);
        model.addAttribute("daily", daily);
        model.addAttribute("iconUrl", "http://openweathermap.org/img/wn/");
        model.addAttribute("iconExt", ".png");
        model.addAttribute("keySet", chartData.keySet());
        model.addAttribute("values", chartData.values());
        model.addAttribute("maxValue",maxValue);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Forecast API
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        ForecastWeather forecastRoot = forecastWeatherService.getForecastWeather(user.getLat(), user.getLon());
        List<ForecastWeatherList> forecastWeatherList = forecastRoot.getList();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        DateTimeFormatter timeFormat24hour = DateTimeFormatter.ofPattern("H:mm").localizedBy(Locale.US);
        DateTimeFormatter timeFormat12hour = DateTimeFormatter.ofPattern("ha").localizedBy(Locale.US);

        List<MultiValueMap<String, Integer>> listMap = new ArrayList<>();
        MultiValueMap<String, Integer> map0 = new LinkedMultiValueMap<>();
        MultiValueMap<String, Integer> map1 = new LinkedMultiValueMap<>();
        MultiValueMap<String, Integer> map2 = new LinkedMultiValueMap<>();
        MultiValueMap<String, Integer> map3 = new LinkedMultiValueMap<>();
        MultiValueMap<String, Integer> map4 = new LinkedMultiValueMap<>();
        MultiValueMap<String, Integer> map5 = new LinkedMultiValueMap<>();
        MultiValueMap<String, Integer> map6 = new LinkedMultiValueMap<>();

        LocalDateTime now = null;
        int i = 0;
        for (ForecastWeatherList item : forecastWeatherList) {

            Integer tmpTemp = item.getMain().getTemp(1).intValue();
            String tmpHour = item.getDt().format(timeFormat12hour).toLowerCase();

            model.addAttribute("tempUnit", "{y}°C");
            if (user.getTemperature() != 1) {
                tmpTemp = item.getMain().getTemp(2).intValue();
                model.addAttribute("tempUnit", "{y}°F");
            }

            if (user.getTimeFormat() != 1) {
                tmpHour = item.getDt().format(timeFormat24hour).toLowerCase();
            }

            if (i == 0) {
                now = item.getDt();
            }
            if (now.format(dateTimeFormatter).equals(item.getDt().format(dateTimeFormatter))) {
                map0.put(tmpHour, Arrays.asList(tmpTemp,item.getMain().getHumidity().intValue()));
            }
            if (now.plusDays(1).format(dateTimeFormatter).equals(item.getDt().format(dateTimeFormatter))) {
                map1.put(tmpHour, Arrays.asList(tmpTemp,item.getMain().getHumidity().intValue()));
            }
            if (now.plusDays(2).format(dateTimeFormatter).equals(item.getDt().format(dateTimeFormatter))) {
                map2.put(tmpHour, Arrays.asList(tmpTemp,item.getMain().getHumidity().intValue()));
            }
            if (now.plusDays(3).format(dateTimeFormatter).equals(item.getDt().format(dateTimeFormatter))) {
                map3.put(tmpHour, Arrays.asList(tmpTemp,item.getMain().getHumidity().intValue()));
            }
            if (now.plusDays(4).format(dateTimeFormatter).equals(item.getDt().format(dateTimeFormatter))) {
                map4.put(tmpHour, Arrays.asList(tmpTemp,item.getMain().getHumidity().intValue()));
            }
            if (now.plusDays(5).format(dateTimeFormatter).equals(item.getDt().format(dateTimeFormatter))) {
                map5.put(tmpHour, Arrays.asList(tmpTemp,item.getMain().getHumidity().intValue()));
            }
            if (now.plusDays(6).format(dateTimeFormatter).equals(item.getDt().format(dateTimeFormatter))) {
                map6.put(tmpHour, Arrays.asList(tmpTemp,item.getMain().getHumidity().intValue()));
            }
            i++;
        }
        listMap.add(map0);
        listMap.add(map1);
        listMap.add(map2);
        listMap.add(map3);
        listMap.add(map4);
        listMap.add(map5);
        listMap.add(map6);

        model.addAttribute("forecastWeatherList", forecastWeatherList);
        model.addAttribute("listMap", listMap);
    }
}
