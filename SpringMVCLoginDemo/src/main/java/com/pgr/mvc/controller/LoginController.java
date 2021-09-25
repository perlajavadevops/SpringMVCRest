package com.pgr.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pgr.mvc.bean.LoginBean;
import com.pgr.mvc.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {

		
		if (loginBean != null) {
			boolean flag  = loginService.validateUser(loginBean.getUserName(), loginBean.getPassword());
			if (flag) {
				model.addAttribute("msg", loginBean.getUserName());
				return "success";
			} else {
				model.addAttribute("msg", "Please Enter Your Login Details");
				model.addAttribute("error", "Invalid Details");
				return "login";
			}
		} else {
			model.addAttribute("error", "Please enter Details");
			return "login";
		}
	}
}
