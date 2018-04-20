package com.wangbin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/testStatic")
public class TestStaticPageController {

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	// 重定向到新的url
	@RequestMapping(value = "pageUrl", method = RequestMethod.GET)
	public String redirectUrl() {
		return "redirect:staticPage";
	}

	// 重定向到一个页面
	@RequestMapping(value = "staticPage", method = RequestMethod.GET)
	public String redirectPage() {
		return "redirect:/static/test.html";
	}
}
