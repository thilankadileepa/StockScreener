package org.sixtynine.stock.controller;

import org.sixtynine.stock.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class UserRegistrtionController {

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user,
			BindingResult result) {

		System.out.println("User Name:" + user.getUserName()
				+ "User Name:" + user.getEmail());

		return "redirect:users.htm";
	}

	@RequestMapping("/users")
	public ModelAndView showUsers() {

		return new ModelAndView("user", "command", new User());
	}
}
