package com.epam.homework.task1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;

public class CustomApplicationContext extends AbstractApplicationContext {

    private ConfigurableListableBeanFactory customBeanFactory;

    public CustomApplicationContext(String fileName, String beansPackage) {
        this.customBeanFactory = new CustomBeanFactory(fileName, beansPackage);
    }

    @Override
    protected void refreshBeanFactory() throws BeansException, IllegalStateException {

    }

    @Override
    protected void closeBeanFactory() {
        this.close();
    }

    @Override
    public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
        return customBeanFactory;
    }
}
