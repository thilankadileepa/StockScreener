package org.sixtynine.stock.controller;

import java.util.HashMap;
import java.util.Map;

import org.sixtynine.stock.model.DailySectorData;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class DailySectorController {

	@RequestMapping(value = "/addDailySectorData", method = RequestMethod.POST)
	public String addDailySectorData(@ModelAttribute("dailySectorData") DailySectorData dailySectorData,
			BindingResult result) {

		System.out.println("No of Trades:" + dailySectorData.getNoOfTrades()
				+ "Turn Over:" + dailySectorData.getTurnOver());

		return "redirect:dailysectors.htm";
	}

	@RequestMapping("/dailysectors")
	public ModelAndView showDailySectorData() {
		ModelAndView mv = new ModelAndView("dailysectordata", "command", new DailySectorData());
		
		 Map< String, String > sector1 = new HashMap<String, String>();  
	        sector1.put("BFI", "Bank");  
	        sector1.put("BFT", "Finance");  
	        sector1.put("C&P", "Cop");  
	        
		mv.addObject("sectorsMap" ,sector1);
		return mv;
	}
	
}
