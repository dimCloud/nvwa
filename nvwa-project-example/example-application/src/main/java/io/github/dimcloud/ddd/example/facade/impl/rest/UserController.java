package io.github.dimcloud.ddd.example.facade.impl.rest;

import io.github.dimcloud.ddd.example.facade.dto.cmd.UserRegistryCmd;
import io.github.dimcloud.ddd.example.facade.UserFacade;
import io.github.dimcloud.nvwa.core.bus.NvwaBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * user rest api
 *
 * @author hehe
 * 2020/10/26 5:25 下午
 **/
@RestController("/user")
public class UserController implements UserFacade {

    @Autowired
    private NvwaBus nvwaBus;

    @PostMapping("/registry")
    public Boolean registry(UserRegistryCmd cmd) {
        return nvwaBus.dispatch(cmd);
    }
}
