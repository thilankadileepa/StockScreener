package org.sixtynine.stock.controller;

import java.util.List;

import org.sixtynine.stock.entity.BaseEntity;
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
public class SectorController {

	@Autowired
	private GenericService genericService;

	@RequestMapping(value = "/sector/add")
	public ModelAndView addSector() {
		ModelAndView modelAndView = new ModelAndView("sector/add");
		modelAndView.addObject("sector", new Sector());
		return modelAndView;
	}

	@RequestMapping(value = "/sector/add/process")
	public ModelAndView addingSector(@ModelAttribute Sector sector) {

		ModelAndView modelAndView = new ModelAndView("home");
		genericService.saveOrUpdate(sector);

		String message = "Team was successfully added.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}
	
	@RequestMapping(value = "/sector/list")
	public ModelAndView listOfSectors() {
		ModelAndView modelAndView = new ModelAndView("/sector/list");

		List<BaseEntity> sectors = genericService
				.findAll(Sector.class);
		modelAndView.addObject("sectors", sectors);

		return modelAndView;
	}
	
	
	@RequestMapping(value = "/sector/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editSector(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/sector/edit");
		BaseEntity sector = genericService.findById(id,
				Sector.class);
		modelAndView.addObject("sector", sector);
		return modelAndView;
	}

	@RequestMapping(value = "/sector/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingSector(@ModelAttribute Sector sector,
			@PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("home");

		genericService.saveOrUpdate(sector);

		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(value = "/sector/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteSector(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		genericService.delete(id, Sector.class);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
}
