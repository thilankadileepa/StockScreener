package org.sixtynine.stock.controller;

import java.util.HashMap;
import java.util.Map;

import org.sixtynine.stock.model.IntraDayShareData;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class IntraDayShareDataController {

	@RequestMapping(value = "/addIntraDayShareData", method = RequestMethod.POST)
	public String addIntraDayShareData(@ModelAttribute("intraDayShareData") IntraDayShareData intraDayShareData,
			BindingResult result) {

		System.out.println("No of Trades:" + intraDayShareData.getPercentageChange()
				+ "Turn Over:" + intraDayShareData.getClosingPrice());

		return "redirect:intradayshares.htm";
	}

	@RequestMapping("/intradayshares")
	public ModelAndView showIntraDayShareData() {
		ModelAndView mv = new ModelAndView("intradaysharedata", "command", new IntraDayShareData());
		
		 Map< String, String > sector1 = new HashMap<String, String>();  
	        sector1.put("BFI", "Bank");  
	        sector1.put("BFT", "Finance");  
	        sector1.put("C&P", "Cop");  
	        
		mv.addObject("companyMap" ,sector1);
		return mv;
	}
	
}
