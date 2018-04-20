package com.wangbin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wangbin.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public ModelAndView showStudentForm() {
		/**
		 * modelAndView�д�����һ����Ϊ��command���Ŀն�����Ϊ�����JSP��ʹ��<form��form>��ǩ��
		 * spring�����Ҫһ����Ϊ��command���Ķ����ļ��� 
		 */
		ModelAndView modelAndView = new ModelAndView("student", "command", new Student());
		return modelAndView;
	}

	@RequestMapping(value = "addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("SpringWeb") Student student, ModelMap modelMap) {
		modelMap.addAttribute("id", student.getId());
		modelMap.addAttribute("name", student.getName());
		modelMap.addAttribute("age", student.getAge());
		return "result";
	}

}
