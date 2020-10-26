package org.dimcloud.ddd.example.domain.user;

import org.dimcloud.nvwa.ddd.repository.Repository;

/**
 * user repository
 *
 * @author feiyu
 * 2020/10/26 10:39 上午
 **/
public interface UserRepository extends Repository {

    boolean exist(UserId id);

    void save(User user);
}
