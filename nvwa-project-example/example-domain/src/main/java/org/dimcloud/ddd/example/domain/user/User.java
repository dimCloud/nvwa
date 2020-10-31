package org.dimcloud.ddd.example.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dimcloud.nvwa.ddd.domain.Entity;

/**
 * domain entity
 *
 * @author hehe
 * 2020/10/26 10:37 上午
 **/
@AllArgsConstructor
public class User implements Entity<UserId> {

    @Getter
    private UserId userId;

    @Getter
    private PhoneNumber phoneNumber;

    @Getter
    private String password;

    public UserId getId() {
        return this.userId;
    }
}
