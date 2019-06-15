package com.epam.homework.task3;

import com.epam.homework.beans.JazzMusic;
import com.epam.homework.beans.PopMusic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.*;
import org.springframework.context.support.AbstractApplicationContext;

@Configuration
public class CustomContextListener implements ApplicationListener<ApplicationContextEvent> {

    private AbstractApplicationContext applicationContext;

    @Autowired
    public CustomContextListener(AbstractApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(ApplicationContextEvent event) {
        JazzMusic jazzMusic = applicationContext.getBeanFactory().getBean(JazzMusic.class);
        if (event instanceof ContextStartedEvent) {
            jazzMusic.setMusician("Started musician");
        } else if (event instanceof ContextRefreshedEvent) {
            jazzMusic.setMusician("Refreshed musician");
        } else if (event instanceof ContextStoppedEvent) {
            jazzMusic.setMusician("Stopped musician");
        } else if (event instanceof ContextClosedEvent) {
            jazzMusic.setMusician("Closed musician");
        }
    }
}
