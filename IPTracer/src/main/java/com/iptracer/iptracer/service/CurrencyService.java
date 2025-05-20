package com.iptracer.iptracer.service;

import com.iptracer.iptracer.model.Currency;
import com.iptracer.iptracer.repository.ICurrencyRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class CurrencyService {

    private ICurrencyRepository currencyRepository;

    public Currency findByCountryName(String countryName) {
        return currencyRepository.findByCountryName(countryName);
    }


}
