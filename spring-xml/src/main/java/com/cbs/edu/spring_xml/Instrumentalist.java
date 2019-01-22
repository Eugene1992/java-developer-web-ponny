package com.cbs.edu.spring_xml;

public class Instrumentalist implements Performer {

    private Instrument instrument;
    private String song;

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    @Override
    public void perform() {
        System.out.println("Playing song '" + song + "'!");
        instrument.play();
    }
}
