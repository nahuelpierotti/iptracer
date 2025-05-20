package com.iptracer.iptracer.model;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Country implements Serializable {


    private String ip;
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
