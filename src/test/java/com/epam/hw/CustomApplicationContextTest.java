package com.epam.hw;

import com.epam.hw.bean.Doggo;
import com.epam.hw.bean.Human;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.context.support.AbstractApplicationContext;

@TestInstance(Lifecycle.PER_CLASS)
public class CustomApplicationContextTest {

  private AbstractApplicationContext applicationContext;

  @BeforeAll
  public void setUp() {
    applicationContext = new CustomApplicationContext("beans");
    applicationContext.refresh();
  }

  @Test
  public void getBeanByName() {
    Object doggo = applicationContext.getBean("Doggo");
    Assertions.assertTrue(doggo instanceof Doggo);
  }

  @Test
  public void getBeanByType() {
    Human human = applicationContext.getBean(Human.class);
    Assertions.assertNotNull(human);
  }
}
