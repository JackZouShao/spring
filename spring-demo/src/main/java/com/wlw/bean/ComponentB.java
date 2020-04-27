package com.wlw.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ComponentB implements Compliment , InitializingBean , SmartLifecycle {
	boolean flag = false;
	public ComponentB(){
		System.out.println("执行B构造方法");
	}

	// 循环依赖

	@Autowired
	Compliment complimentA;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("执行InitializingBean --> afterPropertiesSet() ");
	}

	@PostConstruct
	public void test(){
		System.out.println("执行B @PostConstruct 方法");
	}

	@Override
	public void start() {
		flag = true;
		System.out.println("B SmartLiftCycle Start");
	}

	@Override
	public void stop() {
		flag = false;
		System.out.println("B SmartLiftCycle Stop");
	}

	@Override
	public boolean isRunning() {
		return false;
	}
}
