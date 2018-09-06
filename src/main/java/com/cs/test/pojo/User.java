package com.cs.test.pojo;

public class User {
    /**
     * 
     */
    private Long id;

    /**
     * 名户名
     */
    private String name;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 名户名
     * @return name 名户名
     */
    public String getName() {
        return name;
    }

    /**
     * 名户名
     * @param name 名户名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 密码
     * @return pwd 密码
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 密码
     * @param pwd 密码
     */
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    /**
     * 年龄
     * @return age 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 年龄
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", age="
				+ age + "]";
	}

	public User() {
		super();
	}

	public User(Long id, String name, String pwd, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.age = age;
	}
}