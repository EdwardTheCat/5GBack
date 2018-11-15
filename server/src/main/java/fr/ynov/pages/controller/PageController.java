package fr.ynov.pages.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller used to show views home, about, word...
 * 
 * @author edward
 * @since v0
 */
@Controller
public class PageController {
	/**
	 * method used to render view home from route "/"
	 * @param Map<String, Object>
	 * @return ModelAndView object that represents view and map associated (mustache)
	 * @author edward
	 * @since v0
	 *
	 */
	@GetMapping("/")
	public ModelAndView displayHome(Map<String, Object> model) {
	 
		String title = "Home"; 
	 
	    model.put("title", title);
	 
	    return new ModelAndView("home", model);
	}
	/**
	 * method used to render view home from route "/about"
	 * @param Map<String, Object>
	 * @return ModelAndView object that represents view and map associated (mustache)
	 * @author edward
	 * @since v0
	 */
	@GetMapping("/about")
	public ModelAndView displayAbout(Map<String, Object> model) {
		
		String title = "About page";
	 
	    model.put("title", title);
	 
	    return new ModelAndView("about", model);
	}
	/**
	 * method used to render view home from route "/word"
	 * @param Map<String, Object>
	 * @return ModelAndView object that represents view and map associated (mustache)
	 * @author edward
	 * @since v0
	 */
	@GetMapping("/word")
	public ModelAndView displayWord(Map<String, Object> model) {
		
		String title = "Word";
	 
	    model.put("title", title);
	 
	    return new ModelAndView("word", model);
	}
	/**
	 * method used to render view home from route "/login"
	 * @param Map<String, Object>
	 * @return ModelAndView object that represents view and map associated (mustache)
	 * @author edward
	 * @since v0
	 */
	@GetMapping("/login")
	public ModelAndView displayLogin(Map<String, Object> model) {
			
		String title = "Login";
	 
	    model.put("title", title);
	 
	    return new ModelAndView("login", model);
	}
	/**
	 * method used to logoff from route "/logoff"
	 * @param Map<String, Object>
	 * @return String that redirects to route "/"
	 * @author edward
	 * @since v0
	 */
	@GetMapping("/logoff")
	public String logoff(Map<String, Object> model) {
		
		return "redirect:/";
	}
	

}
