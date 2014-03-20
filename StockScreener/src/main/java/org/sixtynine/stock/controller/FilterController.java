package org.sixtynine.stock.controller;

import java.util.HashMap;
import java.util.Map;

import org.sixtynine.stock.model.Filter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class FilterController {

	@RequestMapping(value = "/addFilter", method = RequestMethod.POST)
	public String addFilter(@ModelAttribute("filter") Filter filter,
			BindingResult result) {

		System.out.println("First Name:" + filter.getFilterValues());

		return "redirect:filters.htm";
	}

	@RequestMapping("/filters")
	public ModelAndView showFilter() {
		ModelAndView mv = new ModelAndView("filter", "command", new Filter());
		
		 Map< String, String > module = new HashMap<String, String>();  
		 	module.put("BFI", "Bank");  
		 	module.put("BFT", "Finance");  
		 	module.put("C&P", "Cop");  
	        
		mv.addObject("filterMap" ,module);
		return mv;
	}
	
}
