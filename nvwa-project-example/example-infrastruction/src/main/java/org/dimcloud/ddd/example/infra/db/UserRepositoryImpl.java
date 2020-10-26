package org.dimcloud.ddd.example.infra.db;

import org.dimcloud.ddd.example.domain.user.User;
import org.dimcloud.ddd.example.domain.user.UserId;
import org.dimcloud.ddd.example.domain.user.UserRepository;
import org.dimcloud.ddd.example.infra.db.converter.UserConverter;
import org.dimcloud.ddd.example.infra.db.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * description
 *
 * @author hehe
 * 2020/10/26 9:30 下午
 **/
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserMapper userMapper;

    public boolean exist(UserId id) {
        return false;
    }

    public void save(User user) {
        userMapper.insert(UserConverter.convert(user));
    }
}
