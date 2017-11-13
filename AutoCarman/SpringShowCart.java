package AutoCarman;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SpringShowCart {	
	@RequestMapping(method = RequestMethod.GET)
	public String getShowCart(ModelMap model) {
		return "showCart";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String getDeleteCart(ModelMap model,@RequestParam("delete") String delete,HttpSession session) {
				
		return "showCart";
	}
}

