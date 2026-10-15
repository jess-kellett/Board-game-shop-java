package objectOrientatedProgrammingCoursework;
// Concrete product, that represents strategy games.
// Inherits from boardGame and implements a toString() to format outputs.
public class StrategyGame extends BoardGame {
	
	public StrategyGame(int productId, ProductCategory productCategory, String productName, double purchaseCost, int quantityInStock, double price, BoardGameType boardGameType, int maxPlayers) {
	super(productId, productCategory, productName, purchaseCost, quantityInStock, price, boardGameType, maxPlayers);
	}
	
	@Override
	public String toString() {
		return " Strategy game | " + getProductName() + " | ProductId: " + getProductId() + " | Players: " + getMaxPlayers() + " | Cost: " + getPrice() + " | Quantity in stock: " + getQuantityInStock();
	}
	
}
