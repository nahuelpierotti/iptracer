package com.iptracer.iptracer.repository;

import com.iptracer.iptracer.model.Stat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatRepository extends JpaRepository<Stat, Integer> {
    Stat getStatByCountry(String countryName);
}
