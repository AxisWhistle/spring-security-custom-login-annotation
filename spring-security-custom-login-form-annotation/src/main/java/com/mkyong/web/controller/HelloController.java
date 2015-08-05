package com.mkyong.web.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.web.model.User;

@Controller
public class HelloController {

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/office", method = RequestMethod.GET)
	public @ResponseBody User officePage() {
		User user = new User("office", "123456", 30, new Date(
				System.currentTimeMillis()));
		return user;

	}

	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public @ResponseBody User managerPage() {
		User user = new User("manager", "123456", 30, new Date(
				System.currentTimeMillis()));
		return user;

	}

	@RequestMapping(value = "/department", method = RequestMethod.GET)
	public @ResponseBody User departmentPage() {
		User user = new User("department", "123456", 30, new Date(
				System.currentTimeMillis()));
		return user;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

}