package com.wangbin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author wangbin
 *
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	public String sayHello(ModelMap modelMap) {
		modelMap.addAttribute("message", "Hello Spring MVC!");
		return "hello";
	}
}
