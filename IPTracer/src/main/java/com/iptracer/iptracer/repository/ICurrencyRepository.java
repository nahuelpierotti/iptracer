package com.iptracer.iptracer.repository;

import com.iptracer.iptracer.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICurrencyRepository extends JpaRepository<Currency, Integer> {
    Currency findByCountryName(String countryName);
}
