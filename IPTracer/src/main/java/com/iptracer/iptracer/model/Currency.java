package com.iptracer.iptracer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency implements Serializable {

    @Id
    private Integer id;

    private String countryName;
    private String code;
    private String description;
}
