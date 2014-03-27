package org.sixtynine.stock.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.sixtynine.stock.entity.BaseEntity;
import org.sixtynine.stock.entity.User;
import org.sixtynine.stock.entity.UserCategory;
import org.sixtynine.stock.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Thilan
 * 
 * this class use to add ,  edit and delete user data
 *
 */

@Controller
public class UserRegistrtionController {

	@Autowired
	private GenericService genericService;
	
	@Autowired
	ReCaptchaImpl reCaptcha;
	
	/*
	 * This method use to set user adding view
	 * 
	 */
	@RequestMapping(value = "/user/add")
	public ModelAndView addUser() {
		ModelAndView modelAndView = new ModelAndView("user/add");
		modelAndView.addObject("user", new User());

		List<BaseEntity> userCategories = genericService.findAll(UserCategory.class);
		modelAndView.addObject("userCategoryMap", userCategories);

		return modelAndView;
	}

	/*
	 * This method use to save user category
	 * 
	 */
	@RequestMapping(value = "/user/add/process")
	public ModelAndView addingUser(@ModelAttribute @Valid User user,
			BindingResult result , @RequestParam("recaptcha_challenge_field") String challangeField, 
			@RequestParam("recaptcha_response_field") String responseField, 
			ServletRequest servletRequest,
			SessionStatus sessionStatus ,Model model) {
		
		String remoteAddress = servletRequest.getRemoteAddr();
		ReCaptchaResponse reCaptchaResponse = this.reCaptcha.checkAnswer(remoteAddress, challangeField, responseField);
		System.out.println(reCaptchaResponse.getErrorMessage());

		if (!result.hasErrors() && reCaptchaResponse.isValid()) {
			ModelAndView modelAndView = new ModelAndView("/user/list");

			List<BaseEntity> users = genericService.findAll(User.class);
			modelAndView.addObject("users", users);
			
			genericService.saveOrUpdate(user);
			return modelAndView;
		} else {	
			ModelAndView modelAndView = new ModelAndView("user/add");
			
			List<BaseEntity> userCategories = genericService.findAll(UserCategory.class);
			modelAndView.addObject("userCategoryMap", userCategories);
			
    		if(!reCaptchaResponse.isValid()) {
    			String messageRecaptcha = "reCAPTCHA is invalid.";
    			modelAndView.addObject("messageRecaptcha", messageRecaptcha);
    		}  
			
			return modelAndView;
		}

	}

	/*
	 * This method use to view list of users
	 * 
	 */
	@RequestMapping(value = "/user/list")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("/user/list");

		List<BaseEntity> users = genericService.findAll(User.class);
		modelAndView.addObject("users", users);

		return modelAndView;
	}

	/*
	 * This method use to set user data into edit view
	 * 
	 */
	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editUser(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/user/edit");
		BaseEntity user = genericService.findById(id, User.class);
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	/*
	 * This method use to update user
	 * 
	 */
	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingUser(@ModelAttribute User user,
			@PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("home");

		genericService.saveOrUpdate(user);

		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	/*
	 * This method use to delete user.
	 * 
	 */
	@RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		genericService.delete(id, User.class);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

}
