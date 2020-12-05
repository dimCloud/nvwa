package io.github.dimcloud.ddd.core.autoconfig;

import io.github.dimcloud.nvwa.core.registry.Registry;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * RegistryProcessor
 *
 * @author hehe
 * 2020/10/26 9:13 下午
 **/
@Component
public class RegistryProcessor implements BeanPostProcessor, PriorityOrdered {

    @Autowired
    private Registry registry;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        registry.regist(bean);
        return bean;
    }

    @Override
    public int getOrder() {
        return PriorityOrdered.HIGHEST_PRECEDENCE;
    }
}
