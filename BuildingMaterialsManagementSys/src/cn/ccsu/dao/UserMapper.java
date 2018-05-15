package cn.ccsu.dao;

import org.springframework.stereotype.Repository;
import cn.ccsu.entity.User;

@Repository
public interface UserMapper {

	public void addUser(User user);

	public User queryUserByName(String name);

}
