package com.wangbin.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ����spring��IOC������ע��(setterע��).
 * @author ����
 *
 */
public class HelloSpringProgram {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		HelloWorldService helloWorldService = (HelloWorldService) applicationContext.getBean("helloWorldService");
		helloWorldService.getHelloWorld().sayHello();
	}

}
