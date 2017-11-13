package AutoCarman;

import java.util.ArrayList;
import java.util.List;

public class Cart{
	private List<Products> products = new ArrayList<>();

    public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public int getTotalItems() {
        return products.size();
    }
    
    public int getTotalAmount() {

        int totalAmount = 0;
        for (Products product : products) {
            totalAmount += product.getTotalAmount();
        }
        return totalAmount;
    }
}
