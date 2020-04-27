package com.wlw.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class AService {

	/**
	 * 1、 joobService == null 没有自动装配成功，正常
	 * 2、 beanService != null 此时不等于null
	 * @param joobService
	 */
	public  AService( JoobService joobService){
		System.out.println(joobService);
	}
}
