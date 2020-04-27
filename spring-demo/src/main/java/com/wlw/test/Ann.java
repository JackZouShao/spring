package com.wlw.test;

import javax.annotation.PostConstruct;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Ann {
	String value() default "ann";
	String desc();
	String author();
	int age() default 19;

}


class Demo{
	@Ann(desc = "1", author = "2")
	private static  String name;

	public static void main(String[] args) {
		System.out.println(name);
	}
}