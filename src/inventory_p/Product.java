package inventory_p;

public abstract class Product {

	public String name;
	public Integer priece;

	public Product(String name, Integer priece) {
		this.name = name;
		this.priece = priece;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPriece() {
		return priece;
	}

	public void setPriece(Integer priece) {
		this.priece = priece;
	}

}
