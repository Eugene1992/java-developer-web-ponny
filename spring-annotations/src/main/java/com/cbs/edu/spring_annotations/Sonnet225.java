package com.cbs.edu.spring_annotations;

import org.springframework.stereotype.Component;

@Component
public class Sonnet225 implements Poem {

    private static String[] LINES = {
            "Когда в раздоре с миром и судьбой,",
            "Припомнив годы, полные невзгод,",
            "Тревожу я бесплодною мольбой",
            "Глухой и равнодушный небосвод"
    };

    @Override
    public void recite() {
        for (int i = 0; i < LINES.length; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(LINES[i]);
        }
    }
}
