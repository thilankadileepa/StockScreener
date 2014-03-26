package org.sixtynine.stock.controller;

import java.util.List;

import org.sixtynine.stock.entity.BaseEntity;
import org.sixtynine.stock.entity.Filter;
import org.sixtynine.stock.entity.FilterCategory;
import org.sixtynine.stock.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Thilan
 *
 */
@Controller
public class FilterCategoryController {

	@Autowired
	private GenericService genericService;
	
	@RequestMapping(value = "/filtercategory/add")
	public ModelAndView addFilter() {
		ModelAndView modelAndView = new ModelAndView("filtercategory/add");
		modelAndView.addObject("filterCategory", new FilterCategory());		
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/filtercategory/add/process")
	public ModelAndView addingFilter(@ModelAttribute Filter filter) {
		ModelAndView modelAndView = new ModelAndView("home");
		
		genericService.saveOrUpdate(filter);

		String message = "User was successfully added.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}
	
	
	@RequestMapping(value = "/filtercategory/list")
	public ModelAndView listOfFilters() {
		ModelAndView modelAndView = new ModelAndView("/filtercategory/list");

		List<BaseEntity> filterCategoryList = genericService
				.findAll(FilterCategory.class);
		modelAndView.addObject("filterCategoryList", filterCategoryList);

		return modelAndView;
	}
	
	
	@RequestMapping(value = "/filtercategory/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editFilter(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/filtercategory/edit");
		BaseEntity filterCategory = genericService.findById(id,FilterCategory.class);
	
		modelAndView.addObject("filterCategory", filterCategory);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/filtercategory/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingTeam(@ModelAttribute FilterCategory filterCategory,
			@PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("home");
		genericService.saveOrUpdate(filterCategory);

		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}
	
	@RequestMapping(value = "/filtercategory/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteFilter(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		genericService.delete(id, FilterCategory.class);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
}
