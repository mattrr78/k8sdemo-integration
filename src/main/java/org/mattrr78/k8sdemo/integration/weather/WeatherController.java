package org.mattrr78.k8sdemo.integration.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Value("${k8sdemo.weather.base-url}")
    private String baseUrl;

    @Value("${k8sdemo.weather.units}")
    private String units;

    @Value("${k8sdemo.weather.api-key}")
    private String apiKey;

    @GetMapping
    public ResponseEntity<WeatherData> getWeatherData(@RequestParam String city,
                                                      @RequestParam String state,
                                                      @RequestParam String country) {
        Map responseMap = new RestTemplate().getForObject(createUrl(city, state, country), Map.class);

        WeatherData data = new WeatherData();

        Map weatherMap = (Map)((List)responseMap.get("weather")).get(0);
        String description = weatherMap.get("description").toString();
        data.setDescription(description);

        Map mainMap = (Map)responseMap.get("main");
        String temperatureStr = mainMap.get("temp").toString();
        data.setTemperature(new BigDecimal(temperatureStr));

        String humidityStr = mainMap.get("humidity").toString();
        data.setHumidity(new BigDecimal(humidityStr));

        return ResponseEntity.ok(data);
    }

    private String createUrl(String city, String state, String country) {
        String queryString = city + ',' + state + ',' + country;
        String url = baseUrl + "?q=" + queryString + "&units=" + units + "&appid=" + apiKey;
        return url;
    }

}
