package inventory_p;

public class Main {

	public static void main(String[] args) {

		StoreManager storeManager = new StoreManager();
		StoreCapable storeCapable = new PersistentStore();
		storeManager.addStorage(storeCapable);

		storeManager.addCDProduct("Valamicd", 1200, 12);
		storeManager.addBookProduct("könyv", 3250, 220);

		System.out.println(storeManager.listProducts());
		System.out.println(storeManager.getTotalProductPriece());
	}

}
