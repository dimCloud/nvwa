package org.dimcloud.ddd.example.infra.db.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.dimcloud.ddd.example.infra.db.mybatis.model.UserDO;

/**
 * dn opt
 *
 * @author hehe
 * 2020/10/26 9:34 下午
 **/
@Mapper
public interface UserMapper {


    @Select("select * from user where phone = #{phone}")
    UserDO select(@Param("phone")String phone);

    @Insert("insert into user ....")
    UserDO insert(@Param("userDO")UserDO userDO);

}
