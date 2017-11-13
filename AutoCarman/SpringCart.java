package AutoCarman;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class SpringCart {
	protected Log log = LogFactory.getLog(getClass());
	@RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String productToCart(ModelMap model, @RequestParam("product") String json) {

        log.info("jsonRequest : " + json);

        Cart cart = (Cart) model.get("cart");
        if (cart == null) {
            cart = new Cart();
        }

        Products product = new Products();
        JSONObject jsonObj = null;
        try {
        jsonObj = new JSONObject(json);
        product.setId(jsonObj.getInt("id"));
        product.setName(jsonObj.getString("name"));
        product.setPrice(jsonObj.getInt("price"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (cart.getProducts().contains(product)) {
            product = cart.getProducts().get(cart.getProducts().indexOf(product));
        } else {
            cart.getProducts().add(product);
        }
		
        model.addAttribute("cart", cart);

        log.info("cart : " + cart.getProducts().get(0));

        JSONObject response = new JSONObject();
        try {
			response.put("totalItems", cart.getTotalItems());
			response.put("totalAmount", cart.getTotalAmount());
		} catch (JSONException e) {
			e.printStackTrace();
		}
        
        
        log.info("jsonResponse : " + response);
        return response.toString();

    }

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap model) {
        return "cart";
	
	}

}
