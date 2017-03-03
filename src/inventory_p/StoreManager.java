package inventory_p;

public class StoreManager {

	private StoreCapable storage;

	public void addStorage(StoreCapable storage) {
		this.storage = storage;
	}

	public void addCDProduct(String name, int price, int tracks) {
		storage.storeCDProduct(name, price, tracks);
	}

	public void addBookProduct(String name, int price, int size) {
		storage.storeBookProduct(name, price, size);
	}

	public String listProducts() {
		String products = "";
		for (Product product : storage.getAllProduct()) {
			products += product.getName() + ", ";
		}
		return products;
	}

	public int getTotalProductPriece() {
		int totalPrice = 0;
		for (Product product : storage.getAllProduct()) {
			totalPrice += product.getPriece();
		}
		return totalPrice;
	}

}
