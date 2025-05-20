package com.iptracer.iptracer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryResponseDto implements Serializable {

    private String countryName;
    private String countryNameSpanish;
    private String isoCode;
    private double latitude;
    private double longitude;
    private String language;
    private String distance;
    private String currency;
    private String currencyDescription;
    private String time;
    private String timeUtc;
    private String gmt;
    private String cotization;
}
