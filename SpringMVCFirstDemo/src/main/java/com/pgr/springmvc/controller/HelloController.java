package com.pgr.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	/*@RequestMapping(method=RequestMethod.GET, value="/")
	public String display() {
		return "index";
	}*/
	
	@RequestMapping(method=RequestMethod.GET, value="/")
	public ModelAndView display() {
		
		ModelAndView view = new ModelAndView("index");
		view.addObject("message", "PerlaReddy Spring MVC Tutorial");
		
		return view;
	}
}
