package fr.ynov.pages.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@GetMapping("/")
	public ModelAndView displayHome(Map<String, Object> model) {
	 
		String title = "Home"; 
	 
	    model.put("title", title);
	 
	    return new ModelAndView("home", model);
	}
	
	@GetMapping("/about")
	public ModelAndView displayAbout(Map<String, Object> model) {
		
		String title = "About page";
	 
	    model.put("title", title);
	 
	    return new ModelAndView("about", model);
	}
	
	@GetMapping("/word")
	public ModelAndView displayWord(Map<String, Object> model) {
		
		String title = "Word";
	 
	    model.put("title", title);
	 
	    return new ModelAndView("word", model);
	}
	
	@GetMapping("/login")
	public ModelAndView displayLogin(Map<String, Object> model) {
			
		String title = "Login";
	 
	    model.put("title", title);
	 
	    return new ModelAndView("login", model);
	}
	
	@GetMapping("/logoff")
	public String logoff(Map<String, Object> model) {
		
		return "redirect:/";
	}
	

}
