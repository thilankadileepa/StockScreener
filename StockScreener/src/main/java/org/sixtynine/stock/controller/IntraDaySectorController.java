package org.sixtynine.stock.controller;

import java.util.HashMap;
import java.util.Map;

import org.sixtynine.stock.model.IntradaySectorData;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class IntraDaySectorController {

	@RequestMapping(value = "/addIntradaySectorData", method = RequestMethod.POST)
	public String addIntradaySectorData(@ModelAttribute("intradaySectorData") IntradaySectorData intradaySectorData,
			BindingResult result) {

		System.out.println("No of Trades:" + intradaySectorData.getPercentageChange()
				+ "Turn Over:" + intradaySectorData.getSequence());

		return "redirect:intradaysectors.htm";
	}

	@RequestMapping("/intradaysectors")
	public ModelAndView showIntradaySectorData() {
		ModelAndView mv = new ModelAndView("intradaysectordata", "command", new IntradaySectorData());
		
		 Map< String, String > sector1 = new HashMap<String, String>();  
	        sector1.put("BFI", "Bank");  
	        sector1.put("BFT", "Finance");  
	        sector1.put("C&P", "Cop");  
	        
		mv.addObject("sectorsMap" ,sector1);
		return mv;
	}
	
}
