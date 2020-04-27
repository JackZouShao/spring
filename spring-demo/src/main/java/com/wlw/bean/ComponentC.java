package com.wlw.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("C")
public class ComponentC {
	@Autowired
	private Compliment componentA;

	public ComponentC(){
		System.out.println("C构造方法");
	}
	@PostConstruct
	private void init() {
		System.out.println("这是BeanA的 init 方法");
	}
	public void printA(){
		System.out.println(componentA);
	}
}
