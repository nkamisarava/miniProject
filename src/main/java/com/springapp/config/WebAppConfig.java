package com.springapp.config;

import com.springapp.service.UserService;
import com.springapp.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@EnableWebMvc
@ComponentScan("com.springapp")
@Order(2)
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public UrlBasedViewResolver viewResolver() {
	UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
	viewResolver.setViewClass(TilesView.class);

	return viewResolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
	TilesConfigurer tilesConfigurer = new TilesConfigurer();
	tilesConfigurer.setDefinitions(new String[]{
	    "/WEB-INF/pages/tiles.xml"
	});
	tilesConfigurer.setCheckRefresh(true);

	return tilesConfigurer;
    }

   /* @Bean
    public UserServiceImpl getUserService() {
	return new UserServiceImpl();
    }*/

    @Bean
    public ShaPasswordEncoder getShaPasswordEncoder(){
	return new ShaPasswordEncoder();
    }
}