package AutoCarman;

import org.springframework.stereotype.Component;

@Component
public class Products {
	private int id;
	private String name;
	private int price;

	public Products(int id, String name, int price) {
		this.name = name;
		this.price = price;
		this.id = id;
	}

	public Products() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [name=" + name + ", price=" + price + "]";
	}

    public Integer getTotalAmount() {

        Integer totalAmount = 0;
        if (price != 0) {
            totalAmount = price;
        }
        return totalAmount;
    }	

}
