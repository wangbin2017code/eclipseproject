package com.wangbin.demo.service.impl;

import com.wangbin.demo.service.HelloWorld;

public class HelloStruts implements HelloWorld {

	@Override
	public void sayHello() {
		System.out.println("hello struts!");
	}

}
