package com.example.restapi;

import com.example.restapi.filters.Authfilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }


    @Bean
    public FilterRegistrationBean<Authfilter> filterRegistrationBean(){
        FilterRegistrationBean<Authfilter> registrationBean = new FilterRegistrationBean<>();
        Authfilter authfilter = new Authfilter();
        registrationBean.setFilter(authfilter);
        registrationBean.addUrlPatterns("/post/*");
        registrationBean.addUrlPatterns("/upload");
        registrationBean.addUrlPatterns("/profileimage");
        registrationBean.addUrlPatterns("/challenge/*");
        return registrationBean;

    }

}
