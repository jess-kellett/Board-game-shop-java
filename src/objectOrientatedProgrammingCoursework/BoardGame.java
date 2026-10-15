package objectOrientatedProgrammingCoursework;
// This is an abstract class for all board game products - it contains the getters that is specific to board games and inherits methods from product.
// StrategyGame and PartyGame extend from this class.
public abstract class BoardGame extends Product {
	
	private BoardGameType boardGameType;
	
	private int maxPlayers;
	
	public BoardGame(int productId, ProductCategory productCategory, String productName, double purchaseCost, int quantityInStock, double price, BoardGameType boardGameType, int maxPlayers) {
		super(productId, productCategory, productName, purchaseCost, quantityInStock, price);
		this.boardGameType = boardGameType;
		this.maxPlayers = maxPlayers;
	}
		
	public BoardGameType getBoardGameType() {
		return boardGameType;
	}
	
	public int getMaxPlayers() {
		return maxPlayers;
	}
	
	public abstract String toString();
}
