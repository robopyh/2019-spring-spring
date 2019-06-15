package com.epam.homework.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class PopMusic implements Music {
    private String musician = "Michael Jackson";
    private String song = "Billie Jean";

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
        this.song = "Inited pop song";
    }

    @PreDestroy
    public void preDestroy() {
        this.song = "Predestroyed pop song";
    }
}
