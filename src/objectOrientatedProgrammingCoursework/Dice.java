package objectOrientatedProgrammingCoursework;
//Concrete product, that represents dice.
//Inherits from accessory and implements a toString() to format outputs.
public class Dice extends Accessory {

	public Dice(int productId, ProductCategory productCategory, String productName, double purchaseCost, int quantityInStock, double price, String compatibility) {
		  super(productId, productCategory, productName, purchaseCost, quantityInStock, price, compatibility, AccessoryType.DICE);
	}
	
	@Override
	public String toString() {
		return " Dice accessory | " + getProductName() + " | ProductID: " + getProductId() + " | Compatibility: " + getCompatibility() + " | Cost: " + getPrice() + " | Quantity in stock: " + getQuantityInStock();
	}
}