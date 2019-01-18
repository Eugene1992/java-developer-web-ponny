package com.cbs.edu.spring.decoupled_solid;

public class HelloWorldDecoupledApp {
    public static void main(String[] args) {
        MessageProvider messageProvider = new ConsoleMessageProvider();
        MessageRenderer messageRenderer = new ConsoleMessageRenderer();
        messageRenderer.setMessageProvider(messageProvider);
        messageRenderer.render();
    }
}
