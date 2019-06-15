package com.epam.homework.task4;

import com.epam.homework.beans.Music;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Music) {
            Music beanMusic = (Music) bean;
            beanMusic.setMusician("Custom musician");
        } else {
            System.out.println("Bean does not implementing Music interface");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
