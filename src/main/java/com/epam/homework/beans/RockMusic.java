package com.epam.homework.beans;

public class RockMusic implements Music {
    private String musician = "Queen";
    private String song = "Is this the real life?";

    @Override
    public void play() {
        System.out.println(musician + ": " + song);
    }

    @Override
    public void setMusician(String musician) {
        this.musician = musician;
    }

    @Override
    public void setSong(String song) {
        this.song = song;
    }

    @Override
    public String getMusician() {
        return musician;
    }

    @Override
    public String getSong() {
        return song;
    }
}
