package org.sixtynine.stock.controller;

import java.util.HashMap;
import java.util.Map;

import org.sixtynine.stock.model.DailyShareData;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class DailyShareController {

	@RequestMapping(value = "/addDailyShareData", method = RequestMethod.POST)
	public String addDailyShareData(@ModelAttribute("dailySectorData") DailyShareData dailyShareData,
			BindingResult result) {

		System.out.println("No of Trades:" + dailyShareData.getSharePrice()
				+ "Turn Over:" + dailyShareData.getTurnOver());

		return "redirect:dailyshares.htm";
	}

	@RequestMapping("/dailyshares")
	public ModelAndView showDailyShareData() {
		ModelAndView mv = new ModelAndView("dailysharedata", "command", new DailyShareData());
		
		 Map< String, String > sector1 = new HashMap<String, String>();  
	        sector1.put("BFI", "Bank");  
	        sector1.put("BFT", "Finance");  
	        sector1.put("C&P", "Cop");  
	        
		mv.addObject("companyMap" ,sector1);
		return mv;
	}
	
}
