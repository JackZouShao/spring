package com.wlw.app;


import com.wlw.bean.Compliment;
import com.wlw.bean.ComponentB;
import com.wlw.bean.ComponentC;
import com.wlw.factory.BEF;
import com.wlw.factory.BeanPostProcssorTest;
import com.wlw.factory.LBeanFactoryPostProcesser;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Stream;

public class SpringTest{


	public static void main(String[] args) {


		String[] strs = {"12345","67891","12347809933","12345","98765432102","67891","12347809933"};

		List<String> list = new ArrayList();
		for (int i = 0; i < strs.length; i++) {
			if(!list.contains(strs[i])){
				list.add(strs[i]);
			}
		}

		// 增强
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		// 换行
		System.out.println();
		// for 循环
		for(int i=0; i< list.size(); i++){
			System.out.println(list.get(i));
		}





		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);

		// 要手动注入, 否则只加注解不作用
		//context.addBeanFactoryPostProcessor(new BEF());
		//context.addBeanFactoryPostProcessor(new LBeanFactoryPostProcesser() );
		context.refresh();
		context.getBean("C");



		new SpringTest().test(() ->{
			System.out.println("C");
		});
//		ComponentC c = (ComponentC)context.getBean(ComponentC.class);
//		c.printA();

		//System.out.println(context.getBean(ComponentA.class));
		// System.out.println(context.getBean(ComponentB.class));
		//System.out.println(context.getBean(ComponentC.class));

		// 获取类元 -> 类文件地址
//		BeanDefinition bd = context.getBeanDefinition("A");
//		Object source = bd.getSource();
//		System.out.println(source);
//		BeanDefinition bd = context.getBeanDefinition("A");
//		Object source = bd.getSource();
//		System.out.println(source);
	}

	public int test(Runnable r){

		new Thread(r).start();
		return 1;
	}

}
