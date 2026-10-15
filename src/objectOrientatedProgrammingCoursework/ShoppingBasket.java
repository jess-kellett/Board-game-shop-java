package objectOrientatedProgrammingCoursework;
import java.util.List;
import java.util.ArrayList;
// This function represents the customers shopping basket and all interactions with the shopping basket.
// It creates a new shopping basket, allows for items to be added to the shopping basket,
// can return a list of the products in the shopping basket, return the total price of the items in the basket
// clear the shopping basket and check to see if the shopping basket is empty.
public class ShoppingBasket {
	
	private List<Product> items;
	
	public ShoppingBasket() {
		items = new ArrayList<>();
	}

	public void addItem(Product product) {
		items.add(product);
	}
	
	public List<Product> getItems() {
		return items;
	}
	
	public double getTotal() {
		double total = 0;
		for (int i = 0; i < items.size(); i++) {
			Product currentItem = items.get(i);
			double currentItemPrice = currentItem.getPrice();
			total += currentItemPrice;
		}
		return total;
	}
	
	public void clear() {
		items.clear();
	}
	
	public boolean isEmpty() {
		boolean isShoppingListEmpty = false;
		int numberItemsInShoppingList = items.size();
		if (numberItemsInShoppingList == 0) {
			isShoppingListEmpty = true;
		}
		return isShoppingListEmpty;
	}
}



