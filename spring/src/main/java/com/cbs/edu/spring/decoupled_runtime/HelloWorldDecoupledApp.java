package com.cbs.edu.spring.decoupled_runtime;

public class HelloWorldDecoupledApp {
    public static void main(String[] args) {
        DecoupledMessageFactory messageFactory = DecoupledMessageFactory.getInstance();
        MessageProvider messageProvider = messageFactory.getMessageProvider();
        MessageRenderer messageRenderer = messageFactory.getMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider);
        messageRenderer.render();
    }
}
