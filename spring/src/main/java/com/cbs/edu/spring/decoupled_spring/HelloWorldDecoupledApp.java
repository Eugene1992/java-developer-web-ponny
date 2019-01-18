package com.cbs.edu.spring.decoupled_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldDecoupledApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");
        MessageProvider messageProvider = (MessageProvider) applicationContext.getBean("fileLoaderMessageProvider");
        MessageRenderer messageRenderer = (MessageRenderer) applicationContext.getBean("renderer");
        messageRenderer.setMessageProvider(messageProvider);
        messageRenderer.render();
    }
}
