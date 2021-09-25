package com.pgr.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pgr.mvc.dto.User;
import com.pgr.mvc.service.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	RegisterService registerService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("userDto") User user) {

		boolean flag = registerService.registerUser(user);
		if (flag) {
			ModelAndView view = new ModelAndView("adduser-success");
			return view;
			/* return "redirect:/adduser-success"; */
		} else {
			ModelAndView view = new ModelAndView("adduser-error");
			return view;
		}

	}

	@RequestMapping(value = "/addUserForm", method = RequestMethod.GET)
	public String addUserForm() {
		return "adduserform";
	}

	@RequestMapping(value = "/editUserForm", method = RequestMethod.GET)
	public String editUserForm(@RequestParam("id") int id, Model model) {// /editUserForm?id=12
		User user = registerService.getUserDetailsById(id);
		model.addAttribute("u", user);
		return "editform";
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("userDto") User user) {

		registerService.updateUser(user);
		return "redirect:/allUsers";

	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String deleteUser(@RequestParam("id") int id, Model model) {// /editUserForm?id=12
		registerService.deleteUserByID(id);
		model.addAttribute("msg", "User deleted Successfully...");

		return "redirect:/allUsers";
		/* return "viewusers"; */
	}

	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public ModelAndView getAllUsers() {

		List<User> list = registerService.getAllUsers();
		ModelAndView view = new ModelAndView("viewusers");
		view.addObject("msg1", "User deleted Successfully...");
		view.addObject("msg2", "User updated Successfully...");
		view.addObject("list", list);
		return view;

	}

}
