package com.cbs.edu.spring_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "poeticDuke")
public class PoeticJuggler implements Performer {

    private Poem poem;

    @Autowired
    public PoeticJuggler(@Qualifier("sonnet225") Poem poem) {
        this.poem = poem;
    }

    @Override
    public void perform() {
        System.out.println("Juggling and recite some poem!");
        poem.recite();
    }
}
