package com.cbs.edu.spring.decoupled_runtime;

import java.io.FileInputStream;
import java.util.Properties;

public class DecoupledMessageFactory {
    private static DecoupledMessageFactory instance;

    private MessageRenderer messageRenderer;
    private MessageProvider messageProvider;
    private Properties properties;

    static {
        instance = new DecoupledMessageFactory();
    }

    private DecoupledMessageFactory() {
        properties = new Properties();
        try {
//            properties.load(new FileInputStream("context.properties"));
            properties.load(getClass().getClassLoader().getResourceAsStream("context.properties"));
            String messageRendererClass = properties.getProperty("message.renderer");
            String messageProviderClass = properties.getProperty("message.provider");
            messageRenderer = (MessageRenderer) Class.forName(messageRendererClass).newInstance();
            messageProvider = (MessageProvider) Class.forName(messageProviderClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DecoupledMessageFactory getInstance() {
        return instance;
    }

    public MessageRenderer getMessageRenderer() {
        return messageRenderer;
    }

    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
