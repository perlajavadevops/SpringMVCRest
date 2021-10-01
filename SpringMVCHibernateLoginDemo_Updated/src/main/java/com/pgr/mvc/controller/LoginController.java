package com.pgr.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pgr.mvc.dto.LoginBean;
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
			boolean flag = loginService.validateUser(loginBean.getUserName(), loginBean.getPassword());
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

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "login";
		/*return "redirect:/";*/
	}
	
	@RequestMapping(value = "/forgotPasswordForm", method = RequestMethod.GET)
	public String forgotPasswordForm(Model model) {
		model.addAttribute("forgotMeg", "Forgot Password");
		return "forgotpassword";
	}
	
	@RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
	public String resetPassword(@RequestParam("userName") String userName, Model model) {
		loginService.resetPassword(userName);
		model.addAttribute("forgotSuccessMsg", "Reset Password is success... Please use default password as password");
		return "forgotpassword";
	}
	
	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm(Model model) {
		model.addAttribute("registerForm", "Register Form");
		return "user_register";
	}
	
	@RequestMapping(value = "/userRegisterForm", method = RequestMethod.POST)
	public String registerForm(Model model, @ModelAttribute("userRegisterForm") LoginBean userRegisterForm) {
		boolean flag = loginService.registerForm(userRegisterForm);
		if (flag) {
			model.addAttribute("successMsg", "Registration is success....");
			return "user_register";
		} else {
			model.addAttribute("successMsg", "Registration is faile...Please check ....");
			return "user_register";
		}
	}
	
	
	
}
