package fr.ynov.page.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.ynov.directorWords.providers.DirWordsProvider;
import fr.ynov.directorWords.ressources.DirWord;

import java.sql.SQLException;
import java.util.Map;

@RestController
/**
 * Class with page Services
 *
 * @author Edward
 * since v0
 */
public class PageService {
    /**
     * method used to render view home from route "/"
     * @param model
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
     * @param model
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
     * @param model
     * @return ModelAndView object that represents view and map associated (mustache)
     * @author edward
     * @since v0
     */
    @GetMapping("/word")
    public ModelAndView displayWord(Map<String, Object> model) {

    	DirWord word = null;
    	
    	DirWordsProvider dirWordsProvider;
		try {
			dirWordsProvider = new DirWordsProvider();
			word = dirWordsProvider.getDirWord();
			model.put("title", "Word");
			model.put("word", word.getSentence());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

        return new ModelAndView("word", model);
    }
    /**
     * method used to logoff from route "/logoff"
     * @param model
     * @return String that redirects to route "/"
     * @author edward
     * @since v0
     */
    @GetMapping("/logoff")
    public String logoff(Map<String, Object> model) {

        return "redirect:/";
    }


}
