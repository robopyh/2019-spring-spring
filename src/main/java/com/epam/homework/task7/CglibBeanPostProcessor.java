package com.epam.homework.task7;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Component
public class CglibBeanPostProcessor implements BeanPostProcessor {

    private final Map<String, Object> beans = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        for (Method method : beanClass.getMethods()) {
            ToUpperCase declaredAnnotation = method.getDeclaredAnnotation(ToUpperCase.class);
            if (declaredAnnotation != null) {
                beans.put(beanName, bean);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        MethodInterceptor handler = (obj, method, args, proxy) -> {
            ToUpperCase declaredAnnotation = method.getDeclaredAnnotation(ToUpperCase.class);
            if (declaredAnnotation != null) {
                return ((String) proxy.invoke(bean, args)).toUpperCase();
            }
            return proxy.invoke(bean, args);
        };

        for (String key : beans.keySet()) {
            if (beanName.equals(key)) {
                return Enhancer.create(bean.getClass(), handler);
            }
        }

        return bean;
    }
}
