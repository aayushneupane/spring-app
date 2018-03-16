package aayush.neupane.me.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OffersController {
	
	/*the home page. located at web-inf/jsps/. doesnt need full url 
	 * because prefix and suffix are defined at spring-app-servlet.xml 
	 */
	
	@RequestMapping("/")
	public String showHome() {
		return "home";
	}

}
