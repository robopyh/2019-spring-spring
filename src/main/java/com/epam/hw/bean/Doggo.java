package com.epam.hw.bean;

import com.epam.hw.annotation.LogMethods;
import org.springframework.stereotype.Component;

@LogMethods
@Component
public class Doggo {

  private String name;
  private String breed;
  private boolean goodBoy;

  public Doggo() {
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
}
