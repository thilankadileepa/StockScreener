package org.sixtynine.stock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class FilterController {

	@Autowired
	private GenericService genericService;
	
	@RequestMapping(value = "/filter/add")
	public ModelAndView addFilter() {
		ModelAndView modelAndView = new ModelAndView("filter/add");
		modelAndView.addObject("filter", new Filter());
		
		Map<Integer, String > userCategories = new HashMap<Integer, String>();  
		
		List<BaseEntity> filterCategory = genericService
				.findAll(FilterCategory.class);
		
		//int i = 0 ; i < userCategory.size() ;i++
		for( BaseEntity filterCat : filterCategory){
			FilterCategory filCat = (FilterCategory)filterCat; 
			userCategories.put(filCat.getId(), filCat.getFilterType());  
		}
		      
        modelAndView.addObject("userCategoryMap" ,userCategories);
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/filter/add/process/{catId}")
	public ModelAndView addingFilter(@ModelAttribute Filter filter ,
			@PathVariable Integer catId) {
		ModelAndView modelAndView = new ModelAndView("home");
		System.out.println(catId);
		
		genericService.saveOrUpdate(filter);

		String message = "User was successfully added.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}
	
	
	@RequestMapping(value = "/filter/list")
	public ModelAndView listOfFilters() {
		ModelAndView modelAndView = new ModelAndView("/filter/list");

		List<BaseEntity> filterList = genericService
				.findAll(Filter.class);
		modelAndView.addObject("filterList", filterList);

		return modelAndView;
	}
	
	
	@RequestMapping(value = "/filter/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editFilter(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/filter/edit");
		BaseEntity filter = genericService.findById(id,
				Filter.class);
		modelAndView.addObject("filter", filter);
		return modelAndView;
	}
	
	@RequestMapping(value = "/filter/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingTeam(@ModelAttribute Filter filter,
			@PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("home");

		genericService.saveOrUpdate(filter);

		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}
	
	@RequestMapping(value = "/filter/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteFilter(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		genericService.delete(id, Filter.class);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
	
}
