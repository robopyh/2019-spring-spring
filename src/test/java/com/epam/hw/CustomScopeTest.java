package com.epam.hw;

import com.epam.hw.bean.Doggo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomScopeTest {

  @Test
  public void task5() {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
        "com.epam.hw");

    Doggo doggo = applicationContext.getBean(Doggo.class);
    doggo.setGoodBoy(true);

    doggo = applicationContext.getBean(Doggo.class);
    Assertions.assertTrue(doggo.isGoodBoy());

    doggo = applicationContext.getBean(Doggo.class);
    Assertions.assertFalse(doggo.isGoodBoy());
  }
}
