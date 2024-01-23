package com.pablitohaddad.footbalfromscratch;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FootbalFromScratchApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


	public static void main(String[] args) {
		SpringApplication.run(FootbalFromScratchApplication.class, args);
	}

}
