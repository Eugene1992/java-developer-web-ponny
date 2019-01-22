package com.cbs.edu.spring_xml;

public class Stage {
    private static Stage instance = new Stage();

    public static Stage getInstance() {
        return instance;
    }

    private Stage() {
    }
}
