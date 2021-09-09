package com.example.restapi;

import com.example.restapi.filters.Authfilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.RegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class RestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }

/*
    @Bean
    public FilterRegistrationBean<CorsFilter> corsfilter(){
        FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>();
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        source.registerCorsConfiguration("/**",corsConfiguration);
    registrationBean.setFilter(new CorsFilter(source));

    registrationBean.setOrder(0);

    return registrationBean;
    }
*/
    @Bean
    public FilterRegistrationBean<Authfilter> filterRegistrationBean(){
        FilterRegistrationBean<Authfilter> registrationBean = new FilterRegistrationBean<>();
        Authfilter authfilter = new Authfilter();
        registrationBean.setFilter(authfilter);
        registrationBean.addUrlPatterns("/post/*");
        registrationBean.addUrlPatterns("/post");
        registrationBean.addUrlPatterns("/upload");
        registrationBean.addUrlPatterns("/profileimage");
        registrationBean.addUrlPatterns("/challenge/*");
        registrationBean.addUrlPatterns("/dashboard");
        registrationBean.addUrlPatterns("/diary/*");
        return registrationBean;

    }






}
