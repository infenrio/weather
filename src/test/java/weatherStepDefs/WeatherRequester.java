package weatherStepDefs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import weatherStepDefs.model.WeatherModel;

import java.io.IOException;

public class WeatherRequester {
    private String weatherURLPrefix = "http://samples.openweathermap.org/data/2.5/weather?q=";
    private String weatherURLPostfix = ",uk&appid=b1b15e88fa797225412429c1c50c122a1";

    public WeatherModel getWeather(String cityName) throws IOException {
        String weatherURL = weatherURLPrefix + cityName + weatherURLPostfix;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(weatherURL, String.class);
        String jsonResponse = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherModel weatherModel = objectMapper.readValue(jsonResponse, WeatherModel.class);
        return weatherModel;
    }
}
