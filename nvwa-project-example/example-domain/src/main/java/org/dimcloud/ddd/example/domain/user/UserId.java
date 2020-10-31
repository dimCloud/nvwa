package org.dimcloud.ddd.example.domain.user;

import lombok.NonNull;
import org.dimcloud.nvwa.ddd.domain.Identifier;

/**
 * user id
 *
 * @author hehe
 * 2020/10/26 10:26 上午
 **/
public class UserId implements Identifier<UserId> {

    private final Long userId;

    public UserId(@NonNull Long userId){
        this.userId = userId;
    }


    public static UserId of(Long userId){
        return new UserId(userId);
    }

    public Boolean sameAs(UserId other) {
        return this.userId.equals(other.userId);
    }
}
