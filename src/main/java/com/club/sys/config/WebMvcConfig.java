package com.club.sys.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerInterceptor())
        	//addPathPatterns 인터셉터에서 경로 추가 허용할때
        	//excludePathPatterns 인터셉터에서 경로 제외할때
        	.excludePathPatterns("/plugin/**", "/css/**", "/fonts/**", "/js/**", "/img/**");
	}
	
	//@Override
	//public void addResourceHandlers(final ResourceHandlerRegistry registry) {
    //    registry
    //    	.addResourceHandler("/**")
    //    	.addResourceLocations("classpath:/templates/", "classpath:/static/", "classpath:/views/");
	//}
}
