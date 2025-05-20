package com.iptracer.iptracer.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

@Service
@Data
@AllArgsConstructor
public class CotizationService {

    final String key="831d7e03dafb76dd4003ff482a81f8a0";

    public String findByCurrencyCode(String currencyCode) throws IOException, InterruptedException {
        Map<String,String> cotizations=getAllCotizations();
        return cotizations.getOrDefault(currencyCode, "Not Found");
    }


    public Map<String,String> getAllCotizations() throws IOException, InterruptedException {
        String url = "https://data.fixer.io/api/latest?access_key=" + key;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET().build();

        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Error en llamada al servicio de fixer.io: " + response.body());
        }
        JsonNode json = new ObjectMapper().readTree(response.body());

       return mapJsonToCotization(json);
    }

    public Map<String,String> mapJsonToCotization(JsonNode json){
        Map<String,String> cotizationMap=new HashMap<>();
        Iterator<Map.Entry<String, JsonNode>> fields = json.get("rates").fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> entry = fields.next();
            double rate=entry.getValue().asDouble();
            cotizationMap.put(entry.getKey(), String.format("%.2f", rate));
        }
        return cotizationMap;
    }

}
