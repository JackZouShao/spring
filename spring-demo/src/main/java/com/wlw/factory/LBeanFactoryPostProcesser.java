package com.wlw.factory;

import com.wlw.bean.ComponentC;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

import java.util.Iterator;

/**
 * 在spring扫描完成之后
 * parse put beanDefinition到 bd map 之后执行方法
 * 现该接口，可以在spring的bean创建之前，修改bean的定义属性。
 * 也就是说，Spring允许BeanFactoryPostProcessor在容器实例化任何其它bean之前读取配置元数据，
 * 并可以根据需要进行修改，例如可以把bean的scope从singleton改为prototype，也可以把property的值给修改掉。
 * 可以同时配置多个BeanFactoryPostProcessor，并通过设置'order'属性来控制各个BeanFactoryPostProcessor的执行次序。
 */
@Component
public class LBeanFactoryPostProcesser implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {


		BeanDefinition c = beanFactory.getBeanDefinition("C");
		// 执行c bean中方法名为destory的销毁方法
		c.setDestroyMethodName(AbstractBeanDefinition.INFER_METHOD);
		System.out.println("BeanFactoryPostProcessor--->postProcessBeanFactory");
		System.out.println(this);
	}
}
