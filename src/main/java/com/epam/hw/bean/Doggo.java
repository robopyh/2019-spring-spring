package com.epam.hw.bean;

import com.epam.hw.annotation.LogMethods;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@LogMethods
@Component
@Scope("custom")
public class Doggo {

  private String name;
  private String breed;
  private boolean goodBoy;

  public Doggo() {
  }

  @PostConstruct
  private void init() {
    System.out.println("Setting up doggo bean...");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBreed() {
    return breed;
  }

  public void setBreed(String breed) {
    this.breed = breed;
  }

  public boolean isGoodBoy() {
    return goodBoy;
  }

  public void setGoodBoy(boolean goodBoy) {
    this.goodBoy = goodBoy;
  }

  @PreDestroy
  private void dispose() {
    System.out.println("Destroying doggo bean...");
    name = "";
    breed = "";
    goodBoy = false;
  }
}
