package com.cs.test.service;

import com.cs.test.pojo.User;

public interface UserService {
    //根据id查找
    public User getUserById(Integer userid);

    //添加一条数据
    public int insert(User user);
}
