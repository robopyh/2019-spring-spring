package com.epam.homework.task1;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class CustomBeanFactory extends DefaultListableBeanFactory {
    private Map<String, Object> beans = new HashMap<>();

    public CustomBeanFactory(String fileWithBeans, String beansPackage) {
        if (fileWithBeans == null || fileWithBeans.isEmpty()) {
            throw new RuntimeException("File name is empty");
        }

        try {
            File file = ResourceUtils.getFile("classpath:" + fileWithBeans);
            Files.lines(file.toPath()).forEach(name -> beans.put(name, createBean(beansPackage, name)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Object createBean(String beansPackage, String name) {
        try {
            Class<?> clazz = Class.forName(beansPackage + "." + name);
            Constructor<?>[] constructors = clazz.getConstructors();
            return constructors[0].newInstance(null);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Bean must have one default constructor with no arguments ", e);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return beans.get(name);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) beans.get(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return beans.get(name);
    }

    @Override
    public <T> T getBean(Class<T> requiredType) throws BeansException {
        return (T) beans.get(requiredType.getSimpleName());
    }

    @Override
    public <T> T getBean(Class<T> requiredType, Object... args) throws BeansException {
        return (T) beans.get(requiredType.getSimpleName());
    }

    @Override
    public boolean containsBean(String name) {
        return beans.containsKey(name);
    }
}
