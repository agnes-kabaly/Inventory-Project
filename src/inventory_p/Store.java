package inventory_p;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class Store implements StoreCapable {

	static String FILENAME = "product.xml";
	ArrayList<Product> productList = new ArrayList<>();

	public void storeCDProduct(String name, int price, int size) {
		Product cdProduct = new CDProduct(name, price, size);
		store(cdProduct);
	}

	public void storeBookProduct(String name, int price, int size) {
		Product bookProduct = new BookProduct(name, price, size);
		store(bookProduct);
	}

	private void saveToXml(Product product) {

		File xmlFile = new File(FILENAME);

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc;
			Element element;

			if (xmlFile.exists()) {
				doc = dBuilder.parse(xmlFile);
				element = doc.getDocumentElement();
			} else {
				doc = dBuilder.newDocument();
				element = doc.createElement("Products");
				doc.appendChild(element);
			}

			Element name = doc.createElement("Product");
			element.appendChild(name);

			Attr attr = doc.createAttribute("name");
			attr.setValue(product.getName());
			name.setAttributeNode(attr);
			Attr attr2 = doc.createAttribute("price");
			attr2.setValue(product.getPriece().toString());
			name.setAttributeNode(attr2);

			TransformerFactory transFactory = TransformerFactory.newInstance();
			Transformer transformer = transFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(FILENAME));
			transformer.transform(source, result);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	protected abstract void storeProduct(Product product);

	protected Product createProduct(String type, String name, int price, int size) {

		if (type.equals("CD")) {
			return new CDProduct(name, price, size);

		} else if (type.equals("book")) {
			return new BookProduct(name, price, size);
		}
		throw new RuntimeException("Choose CD or book product please!");
	}

	public ArrayList<Product> loadProducts() {

		ArrayList<Product> products = new ArrayList<>();

		try {

			File file = new File(FILENAME);

			DocumentBuilderFactory dbF = DocumentBuilderFactory.newInstance();
			DocumentBuilder dB = dbF.newDocumentBuilder();
			Document document = dB.parse(file);
			document.getDocumentElement().normalize();

			NodeList nodes = document.getElementsByTagName("Product");

			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					String instanceName = eElement.getAttribute("name");
					int instPrice = Integer.parseInt(eElement.getAttribute("price"));
					productList.add(createProduct("CD", instanceName, instPrice, 0));
				}

			}
			return products;
		}

		catch (Exception e) {

			e.printStackTrace();
		}

		return this.productList;
	}

	public void store(Product product) {

		saveToXml(product);

		storeProduct(product);
	}

}
