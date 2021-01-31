package com.qinli.mapper;

import com.qinli.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author supermantx
 * @time 2021/1/25 13:06
 */
@Repository
public interface ILoginDao {

    /**
     * 查询用户是否存在
     * @return
     */
    @Select("select * from users where username = #{username}")
    public List<User> findUser(String username);

    /**
     * 判断账号是否正确
     * @param user
     * @return
     */
    @Select("select * from users where username = #{username} and pwd = #{pwd}")
    public List<User> judge(User user);
}
