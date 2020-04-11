package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.ProfilesService;

@Configuration
public class Config {

	@Bean
	public ProfilesService getProfilesService() {
		return new ProfilesService();
	}
}
