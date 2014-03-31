package org.sixtynine.stock.controller;

import java.util.List;

import javax.validation.Valid;

import org.sixtynine.stock.entity.BaseEntity;
import org.sixtynine.stock.entity.Company;
import org.sixtynine.stock.entity.DailyShareData;
import org.sixtynine.stock.entity.FilterCategory;
import org.sixtynine.stock.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes
public class DailyShareController {

	@Autowired
	private GenericService genericService;
	
	@RequestMapping(value = "/dailysharedata/add")
	public ModelAndView addDailyShareData() {
		ModelAndView modelAndView = new ModelAndView("dailysharedata/add");
		modelAndView.addObject("dailysharedata", new DailyShareData());	
		
		List<BaseEntity> compaies = genericService.findAll(Company.class); 
		modelAndView.addObject("companyMap", compaies);
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/dailysharedata/add/process")
	public ModelAndView addingDailyShareData(@ModelAttribute @Valid DailyShareData dailyShareData) {
		
		genericService.saveOrUpdate(dailyShareData);
		
		ModelAndView modelAndView = new ModelAndView("/dailysharedata/list");

		List<BaseEntity> dailyShareDataList = genericService.findAll(FilterCategory.class);
		modelAndView.addObject("DailyShareDataList", dailyShareDataList);

		String message = "User was successfully added.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}
	
	
	@RequestMapping(value = "/dailysharedata/list")
	public ModelAndView listOfDailyShareData() {
		ModelAndView modelAndView = new ModelAndView("/dailysharedata/list");

		List<BaseEntity> dailyShareDataList = genericService.findAll(DailyShareData.class);
		modelAndView.addObject("dailyShareDataList", dailyShareDataList);
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/dailysharedata/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editDailyShareData(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/dailysharedata/edit");
		BaseEntity dailyShareData = genericService.findById(id,DailyShareData.class);	
		modelAndView.addObject("dailyShareData", dailyShareData);
		
		List<BaseEntity> compaies = genericService.findAll(Company.class); 
		modelAndView.addObject("companyMap", compaies);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/dailysharedata/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingDailyShareData(@ModelAttribute DailyShareData dailyShareData,
			@PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("home");
		genericService.saveOrUpdate(dailyShareData);

		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}
	
	@RequestMapping(value = "/dailysharedata/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteDailyShareData(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		genericService.delete(id, DailyShareData.class);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
}
