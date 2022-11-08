package com.projectb.nogo.config;

import com.projectb.nogo.converter.StringToAuthMethod;
import com.projectb.nogo.converter.StringToExpirationPeriod;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToAuthMethod());
        registry.addConverter(new StringToExpirationPeriod());
    }
}
