package io.github.dimcloud.ddd.example.service;

import io.github.dimcloud.ddd.example.domain.user.PhoneNumber;
import io.github.dimcloud.ddd.example.domain.user.User;
import io.github.dimcloud.ddd.example.domain.user.UserRepository;
import io.github.dimcloud.ddd.example.domain.user.UserSpecification;
import io.github.dimcloud.ddd.example.facade.dto.cmd.UserRegistryCmd;
import io.github.dimcloud.nvwa.core.base.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * user service
 *
 * @author hehe
 * 2020/10/26 5:43 下午
 **/
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @CommandHandler(desc = "handle user registry command")
    public void handleUserRegistry(UserRegistryCmd cmd){
        User user = new User(null, PhoneNumber.of(cmd.getPhoneNumber()),cmd.getPassword());
        UserSpecification userSpecification = new UserSpecification(user);
        userSpecification.registry(userRepository);
    }
}
