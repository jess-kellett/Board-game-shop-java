package objectOrientatedProgrammingCoursework;
//Represents a customer who can interact with the system by browsing products and managing shopping basket.
// extends users.
import java.util.List;
public class Customer extends User {
	
	private ShoppingBasket basket;
	
	public Customer(int userId, String name, Role role, Address address) {
		super(userId, name, role, address);
		this.basket = new ShoppingBasket();
	} 
	
	@Override
	public String toString() {
		return "Customer | Name: " + getName() + " | UserID: " + getUserId() + " | Role: " + getRole();
	}
	
	//This function takes a product and the quantity as input from the user, checks against stock to see if the product is available.
	//If it is available it calls a method that adds the item to the basket (a list of products) and prints a message to the user.
	//If the items aren't available then an error message is displayed.
	public void addToBasket(Product product, int quantity) {
		if (product.getQuantityInStock() >= quantity) { 
		    for (int i = 0; i < quantity; i++) {
		    	basket.addItem(product);
		    }
		    System.out.println(product.getProductName() +" added to basket.");
		} else {
			System.out.println("Error - not enough items in stock for that quantity");
			System.out.println();
		}
	}
	
	//This function checks to see if the basket (list) contains any products, if not it prints to the user that the basket is empty
	//If there is items in the basket it prints the products and the total price to the user.
	public void viewBasket() {
		if (basket.isEmpty()) {
			System.out.println("Basket is empty");
			System.out.println();
		} else {
			List<Product> basketItems = basket.getItems();
			for (int i = 0; i < basketItems.size(); i++) {
				System.out.println(basketItems.get(i).toString());
			}
			System.out.println("Total price: " + basket.getTotal());
		}
	}
	
	//This function takes the payment method as an input, it then checks to ensure the basket isn't empty (printing an error message if it is)
	//It then updates the quantity in stock to remove the items that have been purchased.
	//Finally it calls the receipt method to print the receipt to the user and clears the basket.
	public void pay(PaymentMethod paymentMethod) {
		if (basket.isEmpty()) {
			System.out.println("Basket is empty - no payment required.");
			System.out.println();
			return; 
		}
		List<Product> items = basket.getItems();
		for (int i = 0; i < items.size(); i++) {
		    Product item = items.get(i);
		    item.setQuantityInStock(item.getQuantityInStock() - 1);
		}
		Receipt receipt = paymentMethod.processPayment(basket.getTotal(), getAddress());
		receipt.displayReceipt();
		basket.clear();
	}
	
	//This function clears the basket list, and prints that the basket is clear to the user.
	public void cancelBasket() {
		basket.clear();
		System.out.println("Basket is cleared");
		System.out.println();
	}
	
	//This function takes the productId being searched for and the list of stock and returns all the productIds that match the search
	public Product searchById(int productId, Stock stock) {
		return stock.findById(productId);
		}
	
	//This function takes the compatibility being searched for and the list of stock and returns all the products that are compatible to the search
	public List<Product> searchByCompatibility(String compatibility, Stock stock) {
		return stock.findByCompatibility(compatibility);
	}
}
