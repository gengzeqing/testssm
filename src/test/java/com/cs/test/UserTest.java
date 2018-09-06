package com.cs.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cs.test.base.BaseTest;
import com.cs.test.pojo.User;
import com.cs.test.service.UserService;

public class UserTest extends BaseTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void query() {
		System.out.println("10086");
	}
	
	@Test
	public void addUser() {
		User user = new User();
		user.setName("王强");
		user.setAge(25);
		user.setPwd("10086");
		int insert = userService.insert(user);
		System.out.println();
	}

}
