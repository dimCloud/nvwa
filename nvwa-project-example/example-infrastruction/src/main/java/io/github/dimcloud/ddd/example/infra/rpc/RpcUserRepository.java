package io.github.dimcloud.ddd.example.infra.rpc;

import io.github.dimcloud.ddd.example.domain.user.User;
import io.github.dimcloud.ddd.example.domain.user.UserId;
import io.github.dimcloud.ddd.example.domain.user.UserRepository;
import io.github.dimcloud.ddd.example.facade.UserFacade;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 * rpc user repository
 *
 * @author hehe
 * 2020/10/26 9:44 下午
 **/
@Repository
public class RpcUserRepository implements UserRepository {

    /**rest rpc*/
    @Autowired
    private RestTemplate restTemplate;

    /**dubbo rpc*/
    @DubboReference
    private UserFacade userFacade;

    public boolean exist(UserId id) {
        return false;
    }

    public void save(User user) {

    }
}
