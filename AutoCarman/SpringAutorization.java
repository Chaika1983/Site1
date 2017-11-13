package AutoCarman;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class SpringAutorization {
	@RequestMapping(method = RequestMethod.GET)
	public String getHello(ModelMap model) {
		return "autorization";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String testAuz(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap model) { 
		if (email != null) {
			Validator valid = new Validator(email, password);
			if (valid.getAutorization()) {
				User user = new Connector().getUser(valid.getId());
				model.addAttribute("user",user);
				return "redirect:/";
			} else {
				model.addAttribute("valid", valid);
			}
		}
		return "autorization";
	}
}
