package com.wlw.app;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.concurrent.locks.ReentrantLock;
//@MapperScan
@ComponentScan("com.wlw")
@Configuration
/**
 * 也会实例化放入beanDefiniation
 */
public class AppConfig {

	@Bean
	public A getA(){
		System.out.println("Get A");
		return new A();
	}

	@Bean
	public B getB(){
		System.out.println("Get B");
		return new B();
	}
//	@Bean
//	public SqlSessionFactory sqlSessionFactory(DataSource dataSource){
//		return factory;
//	}
}

class A implements Runnable{

	@Override
	public void run() {

		while (true){
			synchronized (A.class){
				synchronized (B.class){};
			}
		}
	}
}
class B extends A implements Runnable {
	@Override
	public void run() {
		while (true){
			synchronized (B.class){
				synchronized (A.class){};
			}
		}
	}
}
