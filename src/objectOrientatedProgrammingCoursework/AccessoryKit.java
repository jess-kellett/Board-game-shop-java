package objectOrientatedProgrammingCoursework;
//Concrete product, that represents accessory kit.
//Inherits from accessory and implements a toString() to format outputs.
public class AccessoryKit extends Accessory {
	
	public AccessoryKit(int productId, ProductCategory productCategory, String productName, double purchaseCost, int quantityInStock, double price, String compatibility) {
		  super(productId, productCategory, productName, purchaseCost, quantityInStock, price, compatibility, AccessoryType.ACCESSORY_KIT);  
	}
	
	@Override
	public String toString() {
		return " Accessory kit accessory | " + getProductName() + " | ProductId: " + getProductId() + " | Compatibility: " + getCompatibility() + " | Cost: " + getPrice() + " | Quantity in stock: " + getQuantityInStock();
	}
}
