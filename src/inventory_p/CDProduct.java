package inventory_p;

public class CDProduct extends Product {

	public int numOfTracks;

	public CDProduct(String name, Integer priece, int numOfTracks) {
		super(name, priece);
		this.numOfTracks = numOfTracks;
	}

	public int getNumOfTracks() {
		return numOfTracks;
	}

	public void setNumOfTracks(int numOfTracks) {
		this.numOfTracks = numOfTracks;
	}

}
