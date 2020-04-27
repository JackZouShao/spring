package com.wlw.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ComponentA implements Compliment ,  SmartLifecycle {
	public ComponentA(){
		System.out.println("执行A构造方法");
	}

	// 循环 引用
	@Autowired
	Compliment complimentB;


	@PostConstruct
	public void init(){
		System.out.println("执行A @PostConstruct 方法");
	}
	Boolean flag = false;
	@Override
	public void start() {
		flag = true;
		System.out.println("A SmartLiftCycle Start");
	}

	@Override
	public void stop() {
		flag = false;
		System.out.println("A SmartLiftCycle Stop");
	}

	@Override
	public boolean isRunning() {
		return false;
	}
}
