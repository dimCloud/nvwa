package org.dimcloud.ddd.example.facade.impl.dubbo;

import org.apache.dubbo.config.annotation.DubboService;
import org.dimcloud.ddd.example.facade.UserFacade;
import org.dimcloud.ddd.example.facade.dto.cmd.UserRegistryCmd;
import org.dimcloud.nvwa.core.bus.NvwaBus;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * user rpc api with dubbo
 *
 * @author hehe
 * 2020/10/26 5:27 下午
 **/
@DubboService(interfaceClass = UserFacade.class)
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private NvwaBus nvwaBus;

    public Boolean registry(UserRegistryCmd cmd) {
        return nvwaBus.dispatch(cmd);
    }


}
