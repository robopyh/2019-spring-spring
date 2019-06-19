package com.epam.hw;

import com.epam.hw.annotation.LogMethods;
import java.util.Arrays;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    Class<?> beanClass = bean.getClass();
    LogMethods annotation = beanClass.getAnnotation(LogMethods.class);
    if (annotation != null) {
      MethodInterceptor interceptor = (obj, method, args, proxy) -> {
        System.out.println(String
            .format("Call method %s.%s with args [%s]", beanClass, method.getName(),
                Arrays.toString(args)));
        return proxy.invoke(bean, args);
      };
      return Enhancer.create(beanClass, interceptor);
    }
    return bean;
  }
}
