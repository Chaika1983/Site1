package AutoCarman;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class SpringRegistration {
	@RequestMapping(method = RequestMethod.GET)
	public String getReg(ModelMap model) {
		return "reg";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String getRegistration(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("re-pass") String rePassword, @RequestParam("name") String name,
			@RequestParam("surname") String surname, @RequestParam("secondname") String secondname,
			ModelMap model) {

		if (email != null) {
			Validator valid = new Validator(email, password, rePassword, name, surname, secondname);
			if (valid.getRegistration()) {
				User user = new User(valid.getId(), valid.getEmail(), valid.getPassword(), valid.getName(),
						valid.getSurname(), valid.getSecondname());
				model.addAttribute("user", user);
				return "redirect:/";
			} else {
				model.addAttribute("valid", valid);
			}
		}
		return "reg";
	}
}
