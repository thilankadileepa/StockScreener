package org.sixtynine.stock.controller;

import org.sixtynine.stock.model.UserCategory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class UserCategoryController {

	@RequestMapping(value = "/addUserCategory", method = RequestMethod.POST)
	public String addUserCategory(@ModelAttribute("userCategory") UserCategory userCategory,
			BindingResult result) {

		System.out.println("Category Name:" + userCategory.getName());

		return "redirect:usercategory.htm";
	}

	@RequestMapping("/usercategory")
	public ModelAndView showUserCategory() {

		return new ModelAndView("usercategory", "command", new UserCategory());
	}
}
