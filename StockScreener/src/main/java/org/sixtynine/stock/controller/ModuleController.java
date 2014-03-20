package org.sixtynine.stock.controller;

import org.sixtynine.stock.model.Module;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class ModuleController {

	@RequestMapping(value = "/addModule", method = RequestMethod.POST)
	public String addModule(@ModelAttribute("module") Module module,
			BindingResult result) {

		System.out.println("First Name:" + module.getName());

		return "redirect:modules.htm";
	}

	@RequestMapping("/modules")
	public ModelAndView showModule() {

		return new ModelAndView("module", "command", new Module());
	}
}
