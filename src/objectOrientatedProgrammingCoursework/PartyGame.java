package objectOrientatedProgrammingCoursework;
//Concrete product, that represents party games.
//Inherits from boardGame and implements a toString() to format outputs.
public class PartyGame extends BoardGame {
	
	public PartyGame(int productId, ProductCategory productCategory, String productName, double purchaseCost, int quantityInStock, double price, BoardGameType boardGameType, int maxPlayers) {
	super(productId, productCategory, productName, purchaseCost, quantityInStock, price, boardGameType, maxPlayers);
	}
	
	@Override
	public String toString() {
		return " Party game | " + getProductName() + " | ProductID: " + getProductId() + " | Players: " + getMaxPlayers() + " | Cost: " + getPrice() + " | Quantity in stock: " + getQuantityInStock();
	}
	
}

