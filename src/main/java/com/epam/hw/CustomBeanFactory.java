package com.epam.hw;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class CustomBeanFactory extends DefaultListableBeanFactory {

  private final static Logger logger = LoggerFactory.getLogger(CustomBeanFactory.class);
  private static final String PACKAGE = "com.epam.hw.bean.";
  private final Map<String, Object> beans = new HashMap<>();

  public CustomBeanFactory(String directory) {
    try {
      Path path = Paths.get(ClassLoader.getSystemResource(directory).toURI());
      Files.list(path)
          .filter(Files::isRegularFile)
          .filter(Files::isReadable)
          .map(file -> file.toFile().getName())
          .forEach(bean -> beans.put(bean, createBean(bean)));
    } catch (IOException | URISyntaxException e) {
      logger.error("Directory read error");
      throw new RuntimeException(e);
    }
  }

  private Object createBean(String name) {
    try {
      Class<?> beanClass = Class.forName(PACKAGE + name);
      return beanClass.getConstructor().newInstance();
    } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException
        | IllegalAccessException | InvocationTargetException e) {
      logger.error("Bean {} creation error", name);
      throw new BeanCreationException(name, "Can't create bean", e);
    }
  }

  @Override
  public <T> T getBean(Class<T> requiredType) throws BeansException {
    return (T) beans.get(requiredType.getSimpleName());
  }

  @Override
  public Object getBean(String name) throws BeansException {
    return beans.get(name);
  }

  @Override
  public boolean containsBean(String name) {
    return beans.containsKey(name);
  }
}
