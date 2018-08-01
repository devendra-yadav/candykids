package com.candykids.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.candykids")
public class CandyKidsWebConfig implements WebMvcConfigurer{
	
		
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver theViewResolver=new InternalResourceViewResolver("/WEB-INF/view/", ".jsp");
		return theViewResolver;
	}

	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
		//multipartResolver.setMaxUploadSizePerFile(10000000);
		return multipartResolver;
	}
}
