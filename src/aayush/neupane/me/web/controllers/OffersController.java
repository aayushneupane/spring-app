package aayush.neupane.me.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.Map;
//
//import javax.servlet.http.HttpSession;

@Controller
public class OffersController {
	
	/*the home page. located at web-inf/jsps/. doesnt need full url 
	 * because prefix and suffix are defined at spring-app-servlet.xml.
	 * 
	 *  Using request to pass 'name' parameter instead of session. 
	 */
	
//	@RequestMapping("/")
//	public ModelAndView showHome(HttpSession session) {
//		
//		ModelAndView mv = new ModelAndView("home");
//		Map<String, Object> model = mv.getModel();
//		model.put("name", "Neupane");
//		session.setAttribute("name", "Aayush");
//		return mv;
//	}
	
	/*
	 * Using spring's model instead of creating own ModelAndView
	 */
	@RequestMapping("/")
	public String showHome(Model model) {
		
		model.addAttribute("name", "<b>Aayush</b>");
		return "home";
	}

}
