package com.epam.hw;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;

public class CustomApplicationContext extends AbstractApplicationContext {

  private final ConfigurableListableBeanFactory beanFactory;

  public CustomApplicationContext(String directory) {
    beanFactory = new CustomBeanFactory(directory);
  }

  @Override
  protected void refreshBeanFactory() throws BeansException, IllegalStateException {
  }

  @Override
  protected void closeBeanFactory() {
  }

  @Override
  public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
    return beanFactory;
  }
}
