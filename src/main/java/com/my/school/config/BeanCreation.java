package com.my.school.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanCreation {

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
