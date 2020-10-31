package org.dimcloud.ddd.example.infra.db.mybatis.model;

import lombok.Data;

/**
 * du user do
 *
 * @author hehe
 * 2020/10/26 9:32 下午
 **/
@Data
public class UserDO {

    private Long id;

    private String phone;

    private String password;

}
