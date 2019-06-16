package com.epam.hw.bean;

import java.util.Set;

public class Human {

  private String name;
  private int age;
  private Set<Doggo> doggos;

  public Human() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Set<Doggo> getDoggos() {
    return doggos;
  }

  public void setDoggos(Set<Doggo> doggos) {
    this.doggos = doggos;
  }
}
