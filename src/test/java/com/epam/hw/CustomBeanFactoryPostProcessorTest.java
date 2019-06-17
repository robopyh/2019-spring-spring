package com.epam.hw;

import com.epam.hw.bean.Doggo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomBeanFactoryPostProcessorTest {

  @Test
  public void task2() {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
        "com.epam.hw");
    Doggo doggo = applicationContext.getBean(Doggo.class);

    Assertions.assertEquals("Persik", doggo.getName());
  }
}
