package org.dimcloud.ddd.core.autoconfig;

import org.dimcloud.nvwa.core.bus.DefaultNvwaBus;
import org.dimcloud.nvwa.core.bus.NvwaBus;
import org.dimcloud.nvwa.core.dispatch.DefaultNvwaDispatcher;
import org.dimcloud.nvwa.core.dispatch.Dispatcher;
import org.dimcloud.nvwa.core.registry.DefaultNvwaRegistry;
import org.dimcloud.nvwa.core.registry.Registry;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * nvwa framework autoconfig
 *
 * @author feiyu
 * 2020/10/26 5:49 下午
 **/
@Configuration
public class NvwaAutoConfiguration {

    @ConditionalOnMissingBean
    @Bean
    public Registry registry(){
        return new DefaultNvwaRegistry();
    }

    @ConditionalOnMissingBean
    @Bean
    public Dispatcher dispatcher(){
        return new DefaultNvwaDispatcher();
    }

    @ConditionalOnMissingBean
    @Bean
    public NvwaBus bus(Registry registry,Dispatcher dispatcher){
        return new DefaultNvwaBus(registry, dispatcher);
    }

    @Bean
    @ConditionalOnMissingBean
    public RegistryProcessor registryProcessor(){
        return new RegistryProcessor();
    }

}
