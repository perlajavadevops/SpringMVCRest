package com.pgr.mvc.service.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pgr.mvc.bean.LoginBean;

@Controller
public class LoginController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("msg", "Please Enter Your Login Details");
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean) {

		if (loginBean != null) {
			if (loginBean.getUserName().equals("perlareddy")) {
				model.addAttribute("msg", loginBean.getUserName());
				return "success";
			} else {
				model.addAttribute("error", "Invalid Details");
				return "login";
			}
		} else {
			model.addAttribute("error", "Please enter Details");
			return "login";
		}
	}
}
