package com.epam.hw;

import com.epam.hw.bean.Doggo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomContextListenerTest {

  public static final String CORGI = "Corgi";

  @Test
  public void task3() {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
        "com.epam.hw");
    Doggo doggo = applicationContext.getBean(Doggo.class);
    String actualBreed = doggo.getBreed();
    Assertions.assertEquals(CORGI, actualBreed);
  }
}
