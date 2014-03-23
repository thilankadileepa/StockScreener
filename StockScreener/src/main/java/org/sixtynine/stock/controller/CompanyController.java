package org.sixtynine.stock.controller;

import java.util.HashMap;
import java.util.Map;

import org.sixtynine.stock.model.Company;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class CompanyController {

	@RequestMapping(value = "/addCompany", method = RequestMethod.POST)
	public String addCompany(@ModelAttribute("company") Company company,
			BindingResult result) {

		System.out.println("First Name:" + company.getName()
				+ "Last Name:" + company.getCode());

		return "redirect:companies.htm";
	}

	@RequestMapping("/companies")
	public ModelAndView showCompany() {
		ModelAndView mv = new ModelAndView("company", "command", new Company());
		
		 Map< String, String > sector1 = new HashMap<String, String>();  
	        sector1.put("BFI", "Bank");  
	        sector1.put("BFT", "Finance");  
	        sector1.put("C&P", "Cop");  
	        
		mv.addObject("sectorsMap" ,sector1);
		return mv;
	}
	
}
