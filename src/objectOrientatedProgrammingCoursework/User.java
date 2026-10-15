package objectOrientatedProgrammingCoursework;
// This is an abstract class that is the basis for all users in the system. 
// It contains all the getters that retrieve the information relevant to users
// Contains a view all products method that outputs to users the products that are in stock in a list of descending price order
// admin and customer extend this class
import java.util.List;

public abstract class User {
	
	private int userId;
	private String name;
	private Role role;
	private Address address;
	
	public User(int userId, String name, Role role, Address address) {
		this.userId = userId;
		this.name = name;
		this.role = role;
		this.address = address;
		
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getName() {
		return name;
	}
	
	public Role getRole() {
		return role;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void viewAllProducts(Stock stock) {
	    List<Product> sortedProducts = stock.sortByPriceDesc();
	    for (int i = 0; i < sortedProducts.size(); i++) {
	    	System.out.println(sortedProducts.get(i).toString());
	    }
	}
	
	public abstract String toString();
}
