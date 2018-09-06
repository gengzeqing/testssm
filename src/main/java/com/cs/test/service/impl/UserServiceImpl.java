package com.cs.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.test.dao.UserMapper;
import com.cs.test.pojo.User;
import com.cs.test.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	public User getUserById(Integer userid) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(User user) {
		return userMapper.insert(user);
	}

   
}
