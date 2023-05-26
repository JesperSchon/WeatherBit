package com.example.weatherbit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
public class WeatherController {

  @Value("${weatherbit.api.key}")
  private String apiKey;

  @GetMapping("/current")
  public ResponseEntity<String> getCurrentWeather() {
    String apiUrl = "https://api.weatherbit.io/v2.0/current?city=Stockholm&key=" + apiKey;

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

    return response;
  }
}
