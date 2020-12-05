package io.github.dimcloud.ddd.example.domain.user;

import lombok.AllArgsConstructor;
import io.github.dimcloud.nvwa.ddd.domain.Specification;

/**
 * user domain logic
 *
 * @author hehe
 * 2020/10/26 10:40 上午
 **/
@AllArgsConstructor
public class UserSpecification implements Specification {

    private User user;

    public void registry(UserRepository userRepository){
        if(userRepository.exist(user.getId())){
            throw new RuntimeException("already registry");
        }
        userRepository.save(user);
    }


}
