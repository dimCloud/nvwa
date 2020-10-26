package org.dimcloud.ddd.example.facade;

import org.dimcloud.ddd.example.facade.dto.cmd.UserRegistryCmd;

/**
 * user facade
 *
 * @author hehe
 * 2020/10/26 4:26 下午
 **/
public interface UserFacade {

    /**
     * user registry
     * @param cmd
     */
    Boolean registry(UserRegistryCmd cmd);

}
