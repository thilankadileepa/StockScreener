package org.sixtynine.stock.controller;

import java.util.List;

import javax.validation.Valid;

import org.sixtynine.stock.entity.BaseEntity;
import org.sixtynine.stock.entity.IntradaySectorData;
import org.sixtynine.stock.entity.Sector;
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
public class IntraDaySectorController {

	@Autowired
	private GenericService genericService;

	@RequestMapping(value = "/intradaysectordata/add")
	public ModelAndView addUser() {
		ModelAndView modelAndView = new ModelAndView("intradaysectordata/add");
		modelAndView.addObject("intradaysectordata", new IntradaySectorData());

		List<BaseEntity> sector = genericService.findAll(Sector.class);
		modelAndView.addObject("sectorMap", sector);

		return modelAndView;
	}

	@RequestMapping(value = "/intradaysectordata/add/process")
	public ModelAndView addingUser(@ModelAttribute @Valid IntradaySectorData intradaySectorData,
			BindingResult result) {

		if (!result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("home");
			genericService.saveOrUpdate(intradaySectorData);
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("intradaysectordata/add");
			return modelAndView;
		}

	}

	@RequestMapping(value = "/intradaysectordata/list")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("/intradaysectordata/list");

		List<BaseEntity> intradaySectorDataList = genericService.findAll(IntradaySectorData.class);
		modelAndView.addObject("intradaySectorDataList", intradaySectorDataList);

		return modelAndView;
	}

	@RequestMapping(value = "/intradaysectordata/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editTeamPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/intradaysectordata/edit");
		BaseEntity intradaySectorData = genericService.findById(id, IntradaySectorData.class);
		modelAndView.addObject("intradaySectorData", intradaySectorData);
		return modelAndView;
	}

	@RequestMapping(value = "/intradaysectordata/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingTeam(@ModelAttribute IntradaySectorData intradaySectorData,
			@PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("home");

		genericService.saveOrUpdate(intradaySectorData);

		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(value = "/intradaysectordata/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteTeam(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		genericService.delete(id, IntradaySectorData.class);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
}
