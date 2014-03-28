package org.sixtynine.stock.controller;

import java.util.List;

import javax.validation.Valid;

import org.sixtynine.stock.entity.BaseEntity;
import org.sixtynine.stock.entity.Company;
import org.sixtynine.stock.entity.QuarterlyShareData;
import org.sixtynine.stock.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class QuarterlyShareController {

	@Autowired
	private GenericService genericService;

	@RequestMapping(value = "/quarterlysharedata/add")
	public ModelAndView addUser() {
		ModelAndView modelAndView = new ModelAndView("quarterlysharedata/add");
		modelAndView.addObject("quarterlyShareData", new QuarterlyShareData());

		List<BaseEntity> companies = genericService.findAll(Company.class);
		modelAndView.addObject("companyMap", companies);

		return modelAndView;
	}

	@RequestMapping(value = "/quarterlysharedata/add/process")
	public ModelAndView addingUser(@ModelAttribute @Valid QuarterlyShareData quarterlyShareData,
			BindingResult result) {

		if (!result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("home");
			genericService.saveOrUpdate(quarterlyShareData);
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("quarterlysharedata/add");
			return modelAndView;
		}

	}

	@RequestMapping(value = "/quarterlysharedata/list")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("/quarterlysharedata/list");

		List<BaseEntity> quarterlyShareDataList = genericService.findAll(QuarterlyShareData.class);
		modelAndView.addObject("quarterlyShareDataList", quarterlyShareDataList);

		return modelAndView;
	}

	@RequestMapping(value = "/quarterlysharedata/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editTeamPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/quarterlysharedata/edit");
		BaseEntity quarterlyShareData = genericService.findById(id, QuarterlyShareData.class);
		modelAndView.addObject("quarterlyShareData", quarterlyShareData);
		return modelAndView;
	}

	@RequestMapping(value = "/quarterlysharedata/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingTeam(@ModelAttribute QuarterlyShareData quarterlyShareData,
			@PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("home");

		genericService.saveOrUpdate(quarterlyShareData);

		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(value = "/quarterlysharedata/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteTeam(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		genericService.delete(id, QuarterlyShareData.class);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
}
