package org.sixtynine.stock.controller;

import java.util.List;

import javax.validation.Valid;

import org.sixtynine.stock.entity.BaseEntity;
import org.sixtynine.stock.entity.Company;
import org.sixtynine.stock.entity.IntradayShareData;
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
public class IntraDayShareDataController {

	@Autowired
	private GenericService genericService;

	@RequestMapping(value = "/intradaysharedata/add")
	public ModelAndView addUser() {
		ModelAndView modelAndView = new ModelAndView("intradaysharedata/add");
		modelAndView.addObject("intradayShareData", new IntradayShareData());

		List<BaseEntity> companies = genericService.findAll(Company.class);
		modelAndView.addObject("companyMap", companies);

		return modelAndView;
	}

	@RequestMapping(value = "/intradaysharedata/add/process")
	public ModelAndView addingUser(@ModelAttribute @Valid IntradayShareData intradayShareData,
			BindingResult result) {

		if (!result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("home");
			genericService.saveOrUpdate(intradayShareData);
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("intradaysharedata/add");
			return modelAndView;
		}

	}

	@RequestMapping(value = "/intradaysharedata/list")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("/intradaysharedata/list");

		List<BaseEntity> intradayShareDataList = genericService.findAll(IntradayShareData.class);
		modelAndView.addObject("intradayShareDataList", intradayShareDataList);

		return modelAndView;
	}

	@RequestMapping(value = "/intradaysharedata/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editTeamPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/intradaysharedata/edit");
		BaseEntity intradayShareData = genericService.findById(id, IntradayShareData.class);
		modelAndView.addObject("intradayShareData", intradayShareData);
		return modelAndView;
	}

	@RequestMapping(value = "/intradaysharedata/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingTeam(@ModelAttribute IntradayShareData intradayShareData,
			@PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("home");

		genericService.saveOrUpdate(intradayShareData);

		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(value = "/intradaysharedata/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteTeam(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		genericService.delete(id, IntradayShareData.class);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
}
