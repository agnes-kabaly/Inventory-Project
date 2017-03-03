package inventory_p;

public class BookProduct extends Product {

	public int pageSize;

	public BookProduct(String name, Integer priece, int pageSize) {
		super(name, priece);
		this.pageSize = pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
