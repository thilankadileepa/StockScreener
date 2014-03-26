package org.sixtynine.stock.controller;

import java.util.List;

import javax.validation.Valid;

import org.sixtynine.stock.entity.BaseEntity;
import org.sixtynine.stock.entity.User;
import org.sixtynine.stock.entity.UserCategory;
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
public class UserRegistrtionController {

	@Autowired
	private GenericService genericService;

	@RequestMapping(value = "/user/add")
	public ModelAndView addUser() {
		ModelAndView modelAndView = new ModelAndView("user/add");
		modelAndView.addObject("user", new User());

		List<BaseEntity> userCategories = genericService
				.findAll(UserCategory.class);
		modelAndView.addObject("userCategoryMap", userCategories);

		return modelAndView;
	}

	@RequestMapping(value = "/user/add/process")
	public ModelAndView addingUser(@ModelAttribute @Valid User user,
			BindingResult result) {

		if (!result.hasErrors()) {
			ModelAndView modelAndView = new ModelAndView("home");
			genericService.saveOrUpdate(user);
			return modelAndView;
		} else {
			ModelAndView modelAndView = new ModelAndView("user/add");
			return modelAndView;
		}

	}

	@RequestMapping(value = "/user/list")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("/user/list");

		List<BaseEntity> users = genericService.findAll(User.class);
		modelAndView.addObject("users", users);

		return modelAndView;
	}

	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editTeamPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/user/edit");
		BaseEntity user = genericService.findById(id, User.class);
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingTeam(@ModelAttribute User user,
			@PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("home");

		genericService.saveOrUpdate(user);

		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteTeam(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		genericService.delete(id, User.class);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
