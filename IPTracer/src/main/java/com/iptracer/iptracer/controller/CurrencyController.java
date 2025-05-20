package com.iptracer.iptracer.controller;

import com.iptracer.iptracer.config.MapperConfig;
import com.iptracer.iptracer.dto.CurrencyDto;
import com.iptracer.iptracer.service.CurrencyService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@Data
@AllArgsConstructor
@RequestMapping("/api/currencies")
public class CurrencyController {
    private final CurrencyService currencyService;
    private final MapperConfig mapperConfig;

    @GetMapping
    public ResponseEntity<List<CurrencyDto>> getStats() {

        List<CurrencyDto> currencyDtoList=mapperConfig.mapList(currencyService.getCurrencyRepository().findAll(),CurrencyDto.class);

        return ResponseEntity.ok(currencyDtoList);
    }
}
