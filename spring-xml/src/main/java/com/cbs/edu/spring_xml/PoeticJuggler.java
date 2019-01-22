package com.cbs.edu.spring_xml;

public class PoeticJuggler extends Juggler {

    private Poem poem;

    public PoeticJuggler(int beanBags, Poem poem) {
        super(beanBags);
        this.poem = poem;
    }

    @Override
    public void perform() {
        super.perform();
        poem.recite();
    }
}
