package objectOrientatedProgrammingCoursework;
//Concrete product, that represents miniature.
//Inherits from accessory and implements a toString() to format outputs.
public class Miniature extends Accessory {
	
	public Miniature(int productId, ProductCategory productCategory, String productName, double purchaseCost, int quantityInStock, double price, String compatibility) {
		  super(productId, productCategory, productName, purchaseCost, quantityInStock, price, compatibility, AccessoryType.MINIATURE);  
	}
	
	@Override
	public String toString() {
		return " Miniature accessory | " + getProductName() + " | ProductID: " + getProductId() +  " | Compatibility: " + getCompatibility() + " | Cost: " + getPrice() + " | Quantity in stock: " + getQuantityInStock();
	} 
}
