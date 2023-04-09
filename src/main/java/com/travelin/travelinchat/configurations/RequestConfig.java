package com.travelin.travelinchat.configurations;

import com.travelin.travelinchat.components.GetRequestFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : Mihai-Cristian Popescu
 * @since : 4/14/2023, Fri
 **/

@Configuration
public class RequestConfig {
    @Bean
    public FilterRegistrationBean<GetRequestFilter> filterRegistrationBean() {
        FilterRegistrationBean<GetRequestFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new GetRequestFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
