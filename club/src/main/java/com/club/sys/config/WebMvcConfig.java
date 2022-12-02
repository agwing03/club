package com.club.sys.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//addPathPatterns 인터셉터에서 경로 추가 허용할때 
		//excludePathPatterns 인터셉터에서 경로 제외할때
        registry.addInterceptor(new LoggerInterceptor())
        .excludePathPatterns("/css/**", "/fonts/**", "/plugin/**", "/scripts/**","/images/**");
	}

}
