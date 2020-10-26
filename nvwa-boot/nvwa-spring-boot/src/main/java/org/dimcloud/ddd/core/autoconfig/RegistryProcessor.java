package org.dimcloud.ddd.core.autoconfig;

import org.dimcloud.nvwa.core.registry.Registry;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * RegistryProcessor
 *
 * @author feiyu
 * 2020/10/26 9:13 下午
 **/
@Component
public class RegistryProcessor implements BeanPostProcessor {

    @Autowired
    private Registry registry;

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        registry.regist(bean);
        return bean;
    }
}
