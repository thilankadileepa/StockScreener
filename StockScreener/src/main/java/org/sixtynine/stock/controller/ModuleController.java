package org.sixtynine.stock.controller;

import java.util.List;

import org.sixtynine.stock.entity.BaseEntity;
import org.sixtynine.stock.entity.Module;
import org.sixtynine.stock.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModuleController {

	@Autowired
	private GenericService genericService;
	
	@RequestMapping(value = "/module/add")
	public ModelAndView addUser() {
		ModelAndView modelAndView = new ModelAndView("module/add");
		modelAndView.addObject("module", new Module());
		
		/*Map<Integer, String > userCategories = new HashMap<Integer, String>();  
		
		List<BaseEntity> userCategory = genericService
				.findAll(UserCategory.class);
		
		//int i = 0 ; i < userCategory.size() ;i++
		for( BaseEntity userCat : userCategory){
			UserCategory uCat = (UserCategory)userCat; 
			userCategories.put(uCat.getId(), uCat.getName());  
		}
		      
        modelAndView.addObject("userCategoryMap" ,userCategories);*/
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/module/add/process/{catId}")
	public ModelAndView addingUser(@ModelAttribute Module module ,
			@PathVariable Integer catId) {
		ModelAndView modelAndView = new ModelAndView("home");
		
		genericService.saveOrUpdate(module);

		String message = "User was successfully added.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}
	
	
	@RequestMapping(value = "/module/list")
	public ModelAndView listOfTeams() {
		ModelAndView modelAndView = new ModelAndView("/module/list");

		List<BaseEntity> modules = genericService
				.findAll(Module.class);
		modelAndView.addObject("modules", modules);

		return modelAndView;
	}
	
	@RequestMapping(value = "/module/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editTeamPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("/module/edit");
		BaseEntity module = genericService.findById(id,
				Module.class);
		modelAndView.addObject("module", module);
		return modelAndView;
	}
	
	@RequestMapping(value = "/module/edit/{id}", method = RequestMethod.POST)
	public ModelAndView edditingTeam(@ModelAttribute Module module,
			@PathVariable Integer id) {

		ModelAndView modelAndView = new ModelAndView("home");

		genericService.saveOrUpdate(module);

		String message = "Team was successfully edited.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}
	
	@RequestMapping(value = "/module/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteTeam(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		genericService.delete(id, Module.class);
		String message = "Team was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
}
