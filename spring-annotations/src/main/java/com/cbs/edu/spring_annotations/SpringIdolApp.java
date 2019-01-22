package com.cbs.edu.spring_annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIdolApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        Performer performer = context.getBean("poeticDuke", Performer.class);
        performer.perform();
    }
}
