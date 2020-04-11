package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.SampleInterceptor;

@Configuration
public class InterceptorsConfig implements WebMvcConfigurer {
	@Autowired
	private SampleInterceptor sampleInterceptor;

	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(sampleInterceptor);
	}
}
