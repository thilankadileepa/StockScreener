package org.sixtynine.stock.controller;

import java.util.List;

import org.sixtynine.stock.entity.BaseEntity;
import org.sixtynine.stock.entity.UserCategory;
import org.sixtynine.stock.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Thilanka
 *
 */
@Controller
public class UserCategoryController {

	@Autowired
	private GenericService genericService;

	
	/*
	 * This method use to set user category adding view
	 * 
	 */
	@RequestMapping(value = "/usercategory/add")
	public ModelAndView addUserCategoryPage() {
		//create user category adding view
		ModelAndView modelAndView = new ModelAndView("usercategory/add");
		//assign user category object to view
		modelAndView.addObject("userCategory", new UserCategory());
		return modelAndView;
	}

	 /*
	 * This method use to save user category
	 * 
	 */
	
	@RequestMapping(value = "/usercategory/add/process")
	public ModelAndView addUserCategory(@ModelAttribute UserCategory userCategory) {

		genericService.saveOrUpdate(userCategory);
		
		//in this method use to create list view..
		ModelAndView modelAndView = new ModelAndView("/usercategory/list");	
		
		List<BaseEntity> userCategories = genericService.findAll(UserCategory.class);		
		String message = "User Category was successfully added.";
		
		//assign data to list view
		modelAndView.addObject("userCategories", userCategories);
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	
	/*
	 * This method use to view list of user categories
	 * 
	 */
	@RequestMapping(value = "/usercategory/list")
	public ModelAndView listUserCategories() {
		ModelAndView modelAndView = new ModelAndView("/usercategory/list");

		//get all user categories 
		List<BaseEntity> userCategories = genericService.findAll(UserCategory.class);
		modelAndView.addObject("userCategories", userCategories);

		return modelAndView;
	}

	/*
	 * This method use to set user category data into edit view
	 * 
	 */
	@RequestMapping(value = "/usercategory/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editUserCategory(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/usercategory/edit");
		
		//get user category using given id..
		BaseEntity userCategory = genericService.findById(id,UserCategory.class);
		modelAndView.addObject("userCategory", userCategory);
		return modelAndView;
	}

	/*
	 * This method use to update user category
	 * 
	 */
	@RequestMapping(value = "/usercategory/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingUserCategory(@ModelAttribute UserCategory userCategory,
			@PathVariable Integer id) {

		genericService.saveOrUpdate(userCategory);
		
		ModelAndView modelAndView = new ModelAndView("/usercategory/list");

		//get all user categories 
		List<BaseEntity> userCategories = genericService.findAll(UserCategory.class);
		modelAndView.addObject("userCategories", userCategories);
		
		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	/*
	 * This method use to delete user category
	 * 
	 */
	@RequestMapping(value = "/usercategory/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUserCategory(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		genericService.delete(id, UserCategory.class);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
