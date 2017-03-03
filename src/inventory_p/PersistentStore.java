package inventory_p;

import java.util.ArrayList;

public class PersistentStore extends Store {

	ArrayList<Product> products = new ArrayList<>();
	Product product;

	public void storeProduct(Product product) {
		products.add(product);
	}

	@Override
	public ArrayList<Product> getAllProduct() {
		return products;
	}

}
