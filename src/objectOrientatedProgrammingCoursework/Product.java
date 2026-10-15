package objectOrientatedProgrammingCoursework;
//This is an abstract class that represents a product sold in the shop -  it contains all the getters for key information about any product.
//All product types (board games or accessories) extend from this class.

public abstract class Product {
	
	private int productId;
	private ProductCategory productCategory;
	private String productName;
	private double purchaseCost;
	private int quantityInStock;
	private double price;
	


	public Product(int productId, ProductCategory productCategory, String productName, double purchaseCost, int qualityInStock, double price) {
		this.productId = productId;
		this.productCategory = productCategory;
		this.productName = productName;
		this.purchaseCost = purchaseCost;
		this.quantityInStock = qualityInStock;
		this.price = price;
	
	}
	
	public int getProductId() {
		return productId;
	}
	
	public ProductCategory getPruoductCategory() {
		return productCategory;
	}

	public String getProductName() {
		return productName;
	}
	
	public int getQuantityInStock() {
		return quantityInStock;
	}
	
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getPurchaseCost() {
		return purchaseCost;
	}
	
	public abstract String toString();
}