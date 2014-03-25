package org.sixtynine.stock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sixtynine.stock.entity.BaseEntity;
import org.sixtynine.stock.entity.Company;
import org.sixtynine.stock.entity.Sector;
import org.sixtynine.stock.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompanyController {

	@Autowired
	private GenericService genericService;
	
	@RequestMapping(value = "/company/add")
	public ModelAndView addCompany() {
		ModelAndView modelAndView = new ModelAndView("company/add");
		modelAndView.addObject("company", new Company());
		
		Map<Integer, String > lagrgcap = new HashMap<Integer, String>(); 
	   
	   	lagrgcap.put(1, "Yes");  
	   	lagrgcap.put(2, "No"); 
	   	
	   	Map<Integer, String > sectors = new HashMap<Integer, String>();  
		
		List<BaseEntity> sectorList = genericService
				.findAll(Sector.class);
		
		for( BaseEntity sector : sectorList){
			Sector sec = (Sector)sector; 
			sectors.put(sec.getId(), sec.getName());  
		}
		    
        modelAndView.addObject("lagrgcap" ,lagrgcap);
        modelAndView.addObject("sectorsMap" ,sectors);
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/company/add/process/")
	public ModelAndView addingUser(@ModelAttribute Company company 
			) {
		ModelAndView modelAndView = new ModelAndView("home");

		
		genericService.saveOrUpdate(company);

		String message = "Company was successfully added.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}
	
	
	@RequestMapping(value = "/company/list")
	public ModelAndView listOfCompany() {
		ModelAndView modelAndView = new ModelAndView("/company/list");

		List<BaseEntity> companies = genericService
				.findAll(Company.class);
		modelAndView.addObject("companies", companies);

		return modelAndView;
	}
	
	@RequestMapping(value = "/company/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editTeamPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/company/edit");
		BaseEntity company = genericService.findById(id,
				Company.class);
		modelAndView.addObject("company", company);
		return modelAndView;
	}
	
	@RequestMapping(value = "/company/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingTeam(@ModelAttribute Company company,
			@PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("home");

		genericService.saveOrUpdate(company);

		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}
	
	@RequestMapping(value = "/company/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteTeam(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		genericService.delete(id, Company.class);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
	
}
