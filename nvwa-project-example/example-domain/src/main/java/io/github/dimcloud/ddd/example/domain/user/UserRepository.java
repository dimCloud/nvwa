package io.github.dimcloud.ddd.example.domain.user;

import io.github.dimcloud.nvwa.ddd.repository.Repository;

/**
 * user repository
 *
 * @author hehe
 * 2020/10/26 10:39 上午
 **/
public interface UserRepository extends Repository {

    boolean exist(UserId id);

    void save(User user);
}
