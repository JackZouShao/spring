package com.wlw.service;

import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


//@Component
//@Scope(value = "prototype")
// 默认BeanName为usersServie 首字母小写
public class UsersService implements Lifecycle {

	private String name;

	UsersService(){
		System.out.println("UserService Constructor");
	}
	@PostConstruct
	public void init(){
		System.out.println("xxx init");
	}

	@Override
	public void start() {
		System.out.println("Start");
	}

	@Override
	public void stop() {
		System.out.println("Stop");
	}

	@Override
	public boolean isRunning() {
		return false;
	}
}
