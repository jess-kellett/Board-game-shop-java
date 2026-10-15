package objectOrientatedProgrammingCoursework;
// This class extends users, and overwrites the viewAllProducts method to include purchase cost which only admin users are allowed to view
// It represents an admin user who can view purchase costs, products and add new product.
import java.util.List;

public class Admin extends User {

	public Admin(int userId, String name, Role role, Address address) {
	super(userId, name, role, address);
	}
	
	@Override
	public String toString() {
		return "Admin | Name: " + getName() + " | UserID: " + getUserId() + " | Role: " + getRole();
	}
	    	
	public void addProduct(Stock stock, Product product) {
		stock.addProduct(product);
	}
	
	@Override
	  public void viewAllProducts(Stock stock) {
	      List<Product> sortedProducts = stock.sortByPriceDesc();
	      for (int i = 0; i < sortedProducts.size(); i++) {                                                
	          Product product = sortedProducts.get(i);                                                           
	          System.out.println(product.toString() + " | Purchase Cost: " + product.getPurchaseCost());               
	      }                                                                                                
	  }  
}
