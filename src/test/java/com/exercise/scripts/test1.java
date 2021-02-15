package com.exercise.scripts;

import com.exercise.rest.jsonclass.SearchWeatherDataResponse;
import com.exercise.rest.util.RestCalls;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.junit.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test1 {

  @Test
  @Parameters({"responseCode", "cityName", "recordsFound"})
  public  void test(int responseCode, String cityName, int recordsFound){
    // Define message header
    MultivaluedMap<String,String> requestHeaders = new MultivaluedHashMap<>();
    requestHeaders.add("x-rapidapi-key", "4fbdb54002msh9b43e0d51a37af3p106cd8jsn3c4ad5e766ed");
    requestHeaders.add("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com");

    String url = "https://community-open-weather-map.p.rapidapi.com";
    String path = "/find";

    // Define message query parameter
    Map<String,String> queryParameters = new HashMap<>();
    queryParameters.put("q", "london");

    // Set request and get response
    Response originalResponse = RestCalls.get(url, path, requestHeaders, queryParameters);

    // Validate response code
    int actResponseCode = originalResponse.getStatus();
    Assert.assertEquals(responseCode, actResponseCode);

    // Convert original response to java class
    SearchWeatherDataResponse searchWeatherDataResponse = RestCalls.parseResponseToPojo(originalResponse, SearchWeatherDataResponse.class);

    // Validate city name in the response
    for(int i=0; i<searchWeatherDataResponse.getList().size();i++){
      String actCityName = ((LinkedHashMap<String, Object>) searchWeatherDataResponse.getList().get(i)).get("name").toString();
      Assert.assertEquals(cityName, actCityName);
    }

    // Validate how many records found in the response
    int actRecordsFound = searchWeatherDataResponse.getCount();
    Assert.assertEquals(recordsFound, actRecordsFound);

  }






}
