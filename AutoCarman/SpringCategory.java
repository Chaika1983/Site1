package AutoCarman;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringCategory {
	@RequestMapping(method = RequestMethod.GET)
	public String getCategory(ModelMap model) {
		Connector conn = new Connector();
		ArrayList <Category> category = (ArrayList<Category>) conn.getCategory();
		model.addAttribute("category", category);
		conn.closeConnector();
		return "categories";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String getProducts(ModelMap model) {
		return "categories";
	}
	
}
