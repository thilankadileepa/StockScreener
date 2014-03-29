package org.sixtynine.stock.controller;

import java.util.List;

import javax.validation.Valid;

import org.sixtynine.stock.entity.BaseEntity;
import org.sixtynine.stock.entity.DailySectorData;
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
public class DailySectorController {

	@Autowired
	private GenericService genericService;

	@RequestMapping(value = "/dailysectordata/add")
	public ModelAndView addDailySectorData() {
		ModelAndView modelAndView = new ModelAndView("dailysectordata/add");
		modelAndView.addObject("dailysectordata", new DailySectorData());

		List<BaseEntity> sectors = genericService.findAll(Sector.class);
		modelAndView.addObject("sectorsMap", sectors);

		return modelAndView;
	}

	@RequestMapping(value = "/dailysectordata/add/process")
	public ModelAndView addingDailySectorData(@ModelAttribute @Valid DailySectorData dailysectordata,
			BindingResult result) {

		//if (!result.hasErrors()) {
			genericService.saveOrUpdate(dailysectordata);
			ModelAndView modelAndView = new ModelAndView("home");
			return modelAndView;
		//} else {
			/*ModelAndView modelAndView = new ModelAndView("dailysectordata/add");
			return modelAndView;*/
		//}

	}

	@RequestMapping(value = "/dailysectordata/list")
	public ModelAndView listOfDailySectorData() {
		ModelAndView modelAndView = new ModelAndView("/dailysectordata/list");

		List<BaseEntity> dailysectordata = genericService.findAll(DailySectorData.class);
		modelAndView.addObject("dailysectordata", dailysectordata);

		return modelAndView;
	}

	@RequestMapping(value = "/dailysectordata/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editDailySectorData(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/dailysectordata/edit");
		
		List<BaseEntity> sectors = genericService.findAll(Sector.class);		
		BaseEntity dailySectorData = genericService.findById(id, DailySectorData.class);
		
		modelAndView.addObject("sectorsMap", sectors);
		modelAndView.addObject("dailySectorData", dailySectorData);
		return modelAndView;
	}

	@RequestMapping(value = "/dailysectordata/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingDailySectorData(@ModelAttribute DailySectorData dailySectorData,
			@PathVariable Integer id) {

		genericService.saveOrUpdate(dailySectorData);
		
		ModelAndView modelAndView = new ModelAndView("/dailysectordata/list");
		
		List<BaseEntity> dailysectordata = genericService.findAll(DailySectorData.class);
		modelAndView.addObject("dailysectordata", dailysectordata);
		
		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(value = "/dailysectordata/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteDailySectorData(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		genericService.delete(id, DailySectorData.class);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
}
