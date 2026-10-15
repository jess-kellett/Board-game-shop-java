package objectOrientatedProgrammingCoursework;
import java.util.List;
import java.util.ArrayList;
// This class manages the full inventory of products.
// It contains the full stock list, allows for products to be added to the stock, returns the full list of products in stock and performs searches on the stock.
public class Stock {
	
	private List<Product> products;
	
	public Stock() {
		products = new ArrayList<>();
	}

	public void addProduct(Product product) {
		products.add(product);
	}
	

	public List<Product> getProducts() {
		return products;
	}
 
	// This function takes a product ID and completes a search through the entire stock list.
	// If the item is found it is returned to the user, if not then null is returned.
	public Product findById(int productId) { 
		for (int i = 0; i < products.size(); i++) {
			Product currentProductBeingSearched = products.get(i);
			if (currentProductBeingSearched.getProductId() == productId) {
				return currentProductBeingSearched;
			}
		}
		return null;
	}
		
	// This function takes the compatibility and completes a search through all the accessories in stock.
	// Any compatible accessories found are returned to the user.
	public List<Product> findByCompatibility(String compatibility) {
		List<Product> compatibleProducts = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			Product currentProduct = products.get(i);
			if (currentProduct instanceof Accessory) {
				Accessory currentAccessory = (Accessory) currentProduct;
				if (currentAccessory.getCompatibility().contains(compatibility)) {
					compatibleProducts.add(currentAccessory);
				}
			}
		}
		return compatibleProducts;
	}
	
	//This function goes through all the products and sorts them by descending price order.
	//It returns a list of products in the correct order.
	public List<Product> sortByPriceDesc(){
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i = 0; i < products.size() -1; i++) {
				Product currentProduct = products.get(i);
				Product nextProduct = products.get(i+1);
				if (currentProduct.getPrice() < nextProduct.getPrice()) {
					products.set(i, nextProduct);
					products.set(i + 1, currentProduct);
					swapped = true;
				} 
			}
		}
	return products;
	}
}


