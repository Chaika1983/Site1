package AutoCarman;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpringProducts {
	@RequestMapping(method = RequestMethod.GET)
	public String getProducts(ModelMap model, HttpSession session, @RequestParam("id") String id) {
		Connector conn = new Connector();
		model.addAttribute("products", conn.getProducts(id));
		conn.closeConnector();
		return "products";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String setProducts(ModelMap model) {
		return "products";
	}
}
