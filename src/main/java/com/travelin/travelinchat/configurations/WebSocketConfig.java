package com.travelin.travelinchat.configurations;

import com.mongodb.lang.NonNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;
import org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory;

/**
 * @author : Mihai-Cristian Popescu
 * @since : 4/2/2023, Sun
 **/

@Log4j2
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // change * to the domain url
        registry.addEndpoint("/socket-endpoint").setAllowedOriginPatterns("*").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
       registry.setApplicationDestinationPrefixes("/chats");
       registry.enableSimpleBroker("/chat", "/user");
       registry.setUserDestinationPrefix("/user");
    }

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
        registration.addDecoratorFactory(webSocketHandlerDecoratorFactory());
    }

    private WebSocketHandlerDecoratorFactory webSocketHandlerDecoratorFactory() {
        return new WebSocketHandlerDecoratorFactory() {
            @NonNull
            @Override
            public WebSocketHandler decorate(@NonNull final WebSocketHandler handler) {
                return new WebSocketHandlerDecorator(handler) {
                    @Override
                    public void afterConnectionEstablished(@NonNull WebSocketSession session) throws Exception {
                        log.info("New client connected");
                        log.info(String.format("ID: %s", session.getId()));
                        log.info(String.format("UTI: %s", session.getUri()));
                        super.afterConnectionEstablished(session);
                    }
                };
            }
        };
    }
}
