package objectOrientatedProgrammingCoursework;
// This is an abstract class for all accessories (dice, accessory kit, miniature) and contains the getters specific to accessories
// Dice, accessory kit and miniature extend from this class.
public abstract class Accessory extends Product {
	
	private AccessoryType accessoryType;
	
	private String compatibility;
	
	public Accessory(int productId, ProductCategory productCategory, String productName, double purchaseCost, int quantityInStock, double price, String compatibility, AccessoryType accessoryType) {
		super(productId, productCategory, productName, purchaseCost, quantityInStock, price);
		this.compatibility  = compatibility;
		this.accessoryType = accessoryType;
	}
	
	public String getCompatibility() {
		return compatibility;
	}
	
	public AccessoryType getAccessoryType() {
		return accessoryType;
	}
	
	public abstract String toString();
}
