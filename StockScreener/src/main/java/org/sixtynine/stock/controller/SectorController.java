package org.sixtynine.stock.controller;

import org.sixtynine.stock.model.Sector;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class SectorController {

	@RequestMapping(value = "/addSector", method = RequestMethod.POST)
	public String addSector(@ModelAttribute("contact") Sector sector,
			BindingResult result) {

		System.out.println("First Name:" + sector.getName()
				+ "Last Name:" + sector.getCode());

		return "redirect:sectors.htm";
	}

	@RequestMapping("/sectors")
	public ModelAndView showSector() {

		return new ModelAndView("sector", "command", new Sector());
	}
}
