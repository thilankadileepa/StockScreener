package org.sixtynine.stock.controller;

import java.util.HashMap;
import java.util.Map;

import org.sixtynine.stock.model.QuarterlyShareData;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class QuarterlyShareController {

	@RequestMapping(value = "/addQuarterlyShareData", method = RequestMethod.POST)
	public String addDailyShareData(@ModelAttribute("quarterlyShareData") QuarterlyShareData quarterlyShareData,
			BindingResult result) {

		System.out.println("No of Trades:" + quarterlyShareData.getAverageEquity()
				+ "Turn Over:" + quarterlyShareData.getAverageTotalAsse());

		return "redirect:quarterlyshares.htm";
	}

	@RequestMapping("/quarterlyshares")
	public ModelAndView showQuarterlyShareData() {
		ModelAndView mv = new ModelAndView("quarterlysharedata", "command", new QuarterlyShareData());
		
		 Map< String, String > sector1 = new HashMap<String, String>();  
	        sector1.put("BFI", "Bank");  
	        sector1.put("BFT", "Finance");  
	        sector1.put("C&P", "Cop");  
	        
		mv.addObject("companyMap" ,sector1);
		return mv;
	}
	
}
