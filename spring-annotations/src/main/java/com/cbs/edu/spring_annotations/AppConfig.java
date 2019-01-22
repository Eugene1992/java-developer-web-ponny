package com.cbs.edu.spring_annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Configuration
public class AppConfig {

    @Bean(name = "duke777")
    @Scope(scopeName = SCOPE_PROTOTYPE)
    public Juggler duke() {
        return new Juggler(10);
    }
}
