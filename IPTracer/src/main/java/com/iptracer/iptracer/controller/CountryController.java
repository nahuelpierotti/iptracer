package com.iptracer.iptracer.controller;

import com.iptracer.iptracer.config.MapperConfig;
import com.iptracer.iptracer.dto.CountryResponseDto;
import com.iptracer.iptracer.dto.StatResponseDto;
import com.iptracer.iptracer.service.CountryService;
import com.iptracer.iptracer.service.StatService;
import com.iptracer.iptracer.service.RequestCoalescerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@Data
@AllArgsConstructor
@RequestMapping("/api/country")
public class CountryController {

    private final CountryService countryService;
    private final RequestCoalescerService requestCoalescerService;
    private final StatService statsService;
    private final MapperConfig modelMapper;

    @GetMapping("/info")
    public ResponseEntity<?> getCountryInfo(@RequestParam String ip) {
        try {
            Map<String,Object> response=requestCoalescerService.coalesce(ip,()->{
                try {

                    CountryResponseDto country = countryService.getCountryCodeFromIP(ip);
                    Map<String,Object> result=new HashMap<>();
                    result.put("IP: ", ip);
                    result.put("Pais: ", country.getCountryName());
                    result.put("ISO Code: ", country.getIsoCode());
                    result.put("Idiomas: ", country.getLanguage());
                    result.put("Moneda: ", country.getCurrency()+ "-"+country.getCurrencyDescription());
                    result.put("Hora: ", country.getTimeUtc() + " (UTC) " + country.getTime() +" (UTC"+country.getGmt()+")");
                    result.put("Cotization: ", country.getCotization() +" Euros");
                    return result;
                }catch (Exception e){
                    throw new RuntimeException("Error getting country data from IP: "+ip,e);
                }

            });

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/statistics")
    public ResponseEntity<Map<String,Object>> getStats() {
        Map<String,Object> response=new HashMap<>();
        List<StatResponseDto> statsList=statsService.getAll();
        int i=0;
        for(StatResponseDto stats:statsList){
            response.put("File"+i,stats);
            i++;
        }
        response.put("Max Distance: ",statsService.getMaxOrMinDistance("max"));
        response.put("Min Distance: ",statsService.getMaxOrMinDistance("min"));
        response.put("Average Distance: ",statsService.getDistanceAvg());

        return ResponseEntity.ok(response);
    }

}
