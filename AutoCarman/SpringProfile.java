package AutoCarman;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class SpringProfile {
	@RequestMapping(method = RequestMethod.GET)
	public String getProfile(ModelMap model) {
		return "profile";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String setProfile(@RequestParam("rename") String rename, @RequestParam("resurname") String resurname,
			@RequestParam("resecondname") String resecondname, ModelMap model, HttpSession session) { 
			User user = (User) session.getAttribute("user");
			Connector conn = new Connector();
			conn.getProfile(rename, resurname, resecondname,user.getId());
			conn.closeConnector();		
		return "profile";
	}
}
