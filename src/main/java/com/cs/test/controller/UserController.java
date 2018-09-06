package com.cs.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cs.test.pojo.User;
import com.cs.test.service.UserService;


@Controller
@RequestMapping("/userController")
public class UserController {
    /**
     * 使用@Autowired也可以，@Autowired默认按类型装配
     * @Resource 默认按名称装配，当找不到与名称匹配的bean才会按类型装配。
     */
	@Autowired
    private UserService userService;
    /**
     * 测试查询
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/showUser")
    public String showUser(@RequestParam(value = "id") Integer id) {
        System.out.println("id:" + id);
        User user = userService.getUserById(id);
        return "showUser";
    }

    /**
     * 测试添加数据
     * 
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/insertUser")
    public String insertUser() {
        User user = new User();
        user.setName("李清照");
        user.setPwd("3232322");
        user.setAge(22);
        int count = userService.insert(user);
        System.out.println("插入" + count + "条数据成功");
        return "showUser";
    }
}
