package com.epam.homework.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class JazzMusic implements Music {
    private String musician = "Louis Armstrong";
    private String song = "What a wonderful world";

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

    @PostConstruct
    public void init() {
        this.song = "Inited jazz song";
    }

    @PreDestroy
    public void preDestroy() {
        this.song = "Predestroyed jazz song";
    }
}
