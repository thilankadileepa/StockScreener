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

	@RequestMapping(value = "/usercategory/add")
	public ModelAndView addUserCategoryPage() {
		ModelAndView modelAndView = new ModelAndView("usercategory/add");
		modelAndView.addObject("userCategory", new UserCategory());
		return modelAndView;
	}

	@RequestMapping(value = "/usercategory/add/process")
	public ModelAndView addUserCategory(@ModelAttribute UserCategory userCategory) {

		ModelAndView modelAndView = new ModelAndView("home");
		genericService.saveOrUpdate(userCategory);

		String message = "Team was successfully added.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(value = "/usercategory/list")
	public ModelAndView listUserCategories() {
		ModelAndView modelAndView = new ModelAndView("/usercategory/list");

		List<BaseEntity> userCategories = genericService
				.findAll(UserCategory.class);
		modelAndView.addObject("userCategories", userCategories);

		return modelAndView;
	}

	@RequestMapping(value = "/usercategory/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editUserCategory(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/usercategory/edit");
		BaseEntity userCategory = genericService.findById(id,
				UserCategory.class);
		modelAndView.addObject("userCategory", userCategory);
		return modelAndView;
	}

	@RequestMapping(value = "/usercategory/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingUserCategory(@ModelAttribute UserCategory userCategory,
			@PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("home");

		genericService.saveOrUpdate(userCategory);

		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(value = "/usercategory/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUserCategory(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		genericService.delete(id, UserCategory.class);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
