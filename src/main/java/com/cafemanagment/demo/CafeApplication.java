package com.cafemanagment.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableJpaRepositories
@EnableWebMvc
@EnableWebSecurity
@SpringBootApplication
public class CafeApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(CafeApplication.class, args);
	}
	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver resourceViewResolver = new InternalResourceViewResolver();
		resourceViewResolver.setPrefix("/WEB-INF/pages/");
		resourceViewResolver.setSuffix(".jsp");
		resourceViewResolver.setViewClass(JstlView.class);
		return resourceViewResolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
