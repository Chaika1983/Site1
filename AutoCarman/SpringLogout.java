package AutoCarman;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class SpringLogout {
	@RequestMapping(method = RequestMethod.GET)
	public String getMenu(ModelMap model) {
		return "logout";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String getMenuPost(@RequestParam("exit") String exit, SessionStatus sessionStatus, HttpSession session) {
		String toExit = exit;
		if (toExit.equals("yes")) {
			sessionStatus.setComplete();
			session.removeAttribute("user");
				return "redirect:/";
			} if(toExit.equals("no")){
				return "redirect:/";
			}
		return "logout";
	}
}
