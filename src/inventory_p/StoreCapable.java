package inventory_p;

import java.util.ArrayList;

public interface StoreCapable {

	abstract ArrayList<Product> getAllProduct();

	abstract void storeCDProduct(String name, int price, int size);

	abstract void storeBookProduct(String name, int price, int size);
}
