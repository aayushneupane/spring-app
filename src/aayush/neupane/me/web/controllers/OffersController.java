package aayush.neupane.me.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import aayush.neupane.me.web.dao.Offer;
import aayush.neupane.me.web.service.OffersService;

@Controller
public class OffersController {
	
	//adding service layer object to the main controller
	private OffersService offersService;
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}
	
	/*
	 * Using spring's model instead of creating own ModelAndView
	 */
	@RequestMapping("/")
	public String showHome(Model model) {
		List<Offer> offers = offersService.getCurrent();
		
		model.addAttribute("name", "aayush");
		model.addAttribute("offers", offers);
		return "home";
	}

}
