package aayush.neupane.me.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	@RequestMapping("/offers")
	public String showOffers(Model model) {
		List<Offer> offers = offersService.getCurrent();
		
		model.addAttribute("name", "aayush");
		model.addAttribute("offers", offers);
		return "offers";
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String showTest(Model model, @RequestParam(value = "id", required=false) String id) { 
		System.out.println("Id is :" + id);
		model.addAttribute("id", id);
		return "home";
	}
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model) {

		return "createoffer";
	}

}
