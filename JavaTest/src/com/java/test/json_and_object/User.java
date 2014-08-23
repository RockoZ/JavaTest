package com.java.test.json_and_object;

import java.io.Serializable;

/**
 * 实体类
 * 
 * @author Mr.Zheng
 * @date 2014年7月15日01:55:48
 * 
 */
public class User implements Serializable
{
	private String name;
	private int age;
	private String[] hoby;
	private Small small;

	public String[] gethoby()
	{
		return hoby;
	}

	public void sethoby(String[] hoby)
	{
		this.hoby = hoby;
	}

	public User()
	{

	}

	public User(String name, int age)
	{
		super();
		this.name = name;
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public void setSmall(Small small)
	{
		this.small = small;
	}

	public Small getSmall()
	{
		return small;
	}
}