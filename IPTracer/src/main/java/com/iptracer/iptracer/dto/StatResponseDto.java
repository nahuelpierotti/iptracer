package com.iptracer.iptracer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatResponseDto implements Serializable {

    private String country;
    private Double distance;
    private int invocations;
}
