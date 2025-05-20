package com.iptracer.iptracer.config;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
public class MapperConfig {

    private ModelMapper modelMapper;

    public MapperConfig() {
        this.modelMapper = new ModelMapper();
    }

    @Bean
    public ModelMapper modelMapper() {
        return this.modelMapper;
    }


    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> this.modelMapper.map(element, targetClass))
                .toList();
    }
}