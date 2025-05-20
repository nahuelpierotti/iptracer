package com.iptracer.iptracer;

import org.redisson.spring.starter.RedissonAutoConfigurationV2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@EnableAutoConfiguration(exclude = {RedissonAutoConfigurationV2.class})
public class IpTracerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpTracerApplication.class, args);
	}

}
