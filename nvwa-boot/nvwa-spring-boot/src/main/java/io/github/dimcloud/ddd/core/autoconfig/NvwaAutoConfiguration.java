package io.github.dimcloud.ddd.core.autoconfig;

import io.github.dimcloud.nvwa.core.bus.DefaultNvwaBus;
import io.github.dimcloud.nvwa.core.bus.NvwaBus;
import io.github.dimcloud.nvwa.core.dispatch.DefaultNvwaDispatcher;
import io.github.dimcloud.nvwa.core.dispatch.Dispatcher;
import io.github.dimcloud.nvwa.core.registry.DefaultNvwaRegistry;
import io.github.dimcloud.nvwa.core.registry.Registry;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * nvwa framework autoconfig
 *
 * @author hehe
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
