package com.travelin.travelinchat;

import com.travelin.travelinchat.converters.StringToChatActionsConverter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TravelinChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelinChatApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new StringToChatActionsConverter());
        return modelMapper;
    }

}
