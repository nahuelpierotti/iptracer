package com.iptracer.iptracer.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iptracer.iptracer.config.MapperConfig;
import com.iptracer.iptracer.dto.CountryResponseDto;
import com.iptracer.iptracer.model.Country;
import com.iptracer.iptracer.model.Currency;
import com.iptracer.iptracer.model.Stat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@Service
public class CountryService implements Serializable {

    private final CurrencyService currencyService;
    private final CotizationService cotizationService;
    private final StatService statService;
    private final MapperConfig mapper;

    final String apiKey="2f24ab6236023a0ca2c2c53ffa73dcc6";


    public CountryResponseDto getCountryCodeFromIP(String ip) throws Exception {
        String url = "http://api.ipapi.com/" + ip+"?access_key="+apiKey;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET().build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Error en llamada al servicio de ipapi: " + response.body());
        }


        JsonNode json = new ObjectMapper().readTree(response.body());
        Country country = mapJsonToCountry(json);
        double distanceDouble = Double.parseDouble(country.getDistance());
        int distanceInt = (int) distanceDouble;
        updateStatistics(country.getCountryName(),Integer.toString(distanceInt));
        setTime(country,ip);
        country.setCotization(cotizationService.findByCurrencyCode(country.getCurrency()));

        return mapper.getModelMapper().map(country,CountryResponseDto.class);
    }

    public Country mapJsonToCountry(JsonNode json) {
        Country country = new Country();
        country.setIp(json.get("ip").asText());
        country.setCountryName(json.get("country_name").asText());
        country.setIsoCode(json.get("country_code").asText());
        country.setLatitude(json.get("latitude").asDouble());
        country.setLongitude(json.get("longitude").asDouble());
        JsonNode locationNode = json.get("location");
        JsonNode languagesArray = locationNode.get("languages");
        JsonNode languageNode =languagesArray.get(0);
        country.setLanguage(languageNode.get("name").asText());

        country.setDistance(calculateDistanceInKmts(json.get("latitude").asDouble(), json.get("longitude").asDouble()));
        setCurrency(country);
        return country;
    }

    public String calculateDistanceInKmts(double latitude, double longitude) {
        String distance="";

        double radioTierra = 6371;
        double lat1Rad = Math.toRadians(-34.61);
        double lon1Rad = Math.toRadians(-58.37);
        double lat2Rad = Math.toRadians(latitude);
        double lon2Rad = Math.toRadians(longitude);
        double diferenciaLatitud = lat2Rad - lat1Rad;
        double diferenciaLongitud = lon2Rad - lon1Rad;

        double a = Math.sin(diferenciaLatitud / 2) * Math.sin(diferenciaLatitud / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.sin(diferenciaLongitud / 2) * Math.sin(diferenciaLongitud / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        distance = Double.toString(radioTierra * c);

        return distance;
    }


    public void setCurrency(Country country) {
        Currency currency =currencyService.findByCountryName(country.getCountryName());
        country.setCurrency(currency.getCode());
        country.setCurrencyDescription(currency.getDescription());
    }

    public void setTime(Country country,String ip) throws IOException, InterruptedException {
        String url = "http://worldtimeapi.org/api/ip/" + ip;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET().build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Error en llamada al servicio de worldtimeapi: " + response.body());
        }

        JsonNode json = new ObjectMapper().readTree(response.body());

        country.setTime(dateConverter(json.get("datetime").asText()));
        country.setTimeUtc(dateConverter(json.get("utc_datetime").asText()));
        country.setGmt(json.get("utc_offset").asText());
    }

    public void updateStatistics(String countryName,String distance) {
        Stat stat =statService.getStatByCountry(countryName);
        if(stat == null) {
            stat = Stat.builder()
                    .country(countryName)
                    .distance(Double.parseDouble(distance))
                    .invocations(1)
                    .build();
            statService.save(stat);
        }else{
            stat.setInvocations(stat.getInvocations() + 1);
            statService.save(stat);
        }

    }

    public String dateConverter(String date){
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(date);
        LocalTime hora = offsetDateTime.toLocalTime();
        return hora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

}
