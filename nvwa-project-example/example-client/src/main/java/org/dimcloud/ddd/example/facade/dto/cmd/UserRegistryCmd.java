package org.dimcloud.ddd.example.facade.dto.cmd;

import lombok.Data;
import org.dimcloud.nvwa.core.base.Command;

/**
 * user registry command
 *
 * @author hehe
 * 2020/10/26 5:15 下午
 **/
@Data
public class UserRegistryCmd implements Command<Boolean> {

    private String phoneNumber;

    private String password;

}
