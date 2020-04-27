package com.wlw.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


/**
 * BeanPostProcessor，可以在spring容器实例化bean之后，在执行bean的初始化方法前后，添加一些自己的处理逻辑。
 * 这里说的初始化方法，指的是下面两种：
 * 1)  bean中的方法设置 @PostConstrac
 * 2) bean实现了InitializingBean接口，对应的方法为afterPropertiesSet
 * 3) xml 中设置init-method属性
 * BeanPostProcessor是在spring容器加载了bean的定义文件并且实例化bean之后执行的。
 * BeanPostProcessor的执行顺序是在BeanFactoryPostProcessor之后。
 */
@Component
public class BeanPostProcssorTest implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("componentB"))
			System.out.println("BeanPostProcessor，对象" + beanName + "调用初始化方法之前的数据： " + bean.toString());
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("componentB"))
			System.out.println("BeanPostProcessor，对象" + beanName + "调用初始化方法之h后的数据： " + bean.toString());
		return null;
	}
}
