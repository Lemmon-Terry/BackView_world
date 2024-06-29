package org.backstage.bvw.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.backstage.bvw.domain.User;

import java.util.List;

@Mapper
public interface UserMapper {

    public List<String> getUserName();

    public List<User> userList();

    public User getUserByName(String name);

    public void insertUser(User user);
}
