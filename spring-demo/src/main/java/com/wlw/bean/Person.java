package com.wlw.bean;

public class Person {
	//定义成员变量
	private String name;//姓名
	private int age;//年龄
	private char gendar;//性别

	//定义成员方法
	public void study(){
		System.out.println("好好学学习，天天向上");
	}

	public void sleep(){
		System.out.println("学习一天了，可以睡觉了");
	}

	// 静态方法 static修饰
	static void walk(){
		System.out.println(11111111);
	}

	// main方法程序入口
	public static void main(String[] args) {
		// 成员变量，方法要通过新建对象调用
		new Person().age = 1;
		new Person().sleep();
		// 静态成员变量，静态方法要通过类名.调用
		Person.walk();
	}
}