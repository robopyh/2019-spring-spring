package com.epam.hw;

import com.epam.hw.bean.Doggo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class CustomContextListener implements ApplicationListener<ContextRefreshedEvent> {

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    ApplicationContext applicationContext = event.getApplicationContext();
    Doggo doggo = applicationContext.getBean(Doggo.class);
    System.out.println("Context has been refreshed.");
    System.out.println("Doggo's name: " + doggo.getName());
    doggo.setBreed("Corgi");
  }
}
