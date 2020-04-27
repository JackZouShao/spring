package com.wlw.bean;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;


public  class Com implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
//		实例化mybatis内部扫描器 scanner
//		List<bd> list = scanner.scan()
//		for (循环扫描出来的所有dao)
//			GenericBeanDefinition g = new GenericBeanDefinition(fb);
//			g.getPropertyValues().add("dao")
	}
}
