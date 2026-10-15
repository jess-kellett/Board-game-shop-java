package objectOrientatedProgrammingCoursework;
//This class handles all input and outputs to text files.
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class FileManager {
	
	//The function below reads the stock.txt file and converts the information from the text file into the corresponding product object
	//returns a list of objects.
	//contains an exception incase the file isn't located.
	public List<Product> loadStock() throws FileNotFoundException{
		List<Product> products = new ArrayList<>();
		File stockFile = new File("Stock.txt");
		Scanner stockFileScanner = new Scanner(stockFile);
		while (stockFileScanner.hasNextLine()) {
			String[] productDetails = stockFileScanner.nextLine().split("; ");
			if (productDetails[1].equals("board game")) {
				if (productDetails[2].equals("strategy")){
					StrategyGame product = new StrategyGame(
							Integer.parseInt(productDetails[0].trim()),
							ProductCategory.BOARDGAME,
							productDetails[3].trim(),
							Double.parseDouble(productDetails[6].trim()),
							Integer.parseInt(productDetails[5].trim()),
							Double.parseDouble(productDetails[4].trim()),
							BoardGameType.STRATEGY,
							Integer.parseInt(productDetails[7].trim()));
					products.add(product);
				}
				else if (productDetails[2].equals("party")) {
					PartyGame product = new PartyGame(
							Integer.parseInt(productDetails[0].trim()),
							ProductCategory.BOARDGAME,
							productDetails[3].trim(),
							Double.parseDouble(productDetails[6].trim()),
							Integer.parseInt(productDetails[5].trim()),
							Double.parseDouble(productDetails[4].trim()),
							BoardGameType.PARTY,
							Integer.parseInt(productDetails[7].trim()));
					products.add(product);
				}
			}
			else if (productDetails[1].equals("accessory")) {
				if (productDetails[2].equals("dice")) {
					Dice product = new Dice(
						    Integer.parseInt(productDetails[0].trim()),  
						    ProductCategory.ACCESSORY, 
						    productDetails[3].trim(),  
						    Double.parseDouble(productDetails[6].trim()),
						    Integer.parseInt(productDetails[5].trim()),
						    Double.parseDouble(productDetails[4].trim()), 
						    productDetails[7].trim());
					products.add(product);
				}
				else if (productDetails[2].equals("miniature")) {
					Miniature product = new Miniature(
						    Integer.parseInt(productDetails[0].trim()),  
						    ProductCategory.ACCESSORY, 
						    productDetails[3].trim(),  
						    Double.parseDouble(productDetails[6].trim()),
						    Integer.parseInt(productDetails[5].trim()),
						    Double.parseDouble(productDetails[4].trim()), 
						    productDetails[7].trim());
					products.add(product);
				}
				else if (productDetails[2].equals("accessory kit")) {
					AccessoryKit product = new AccessoryKit(
						    Integer.parseInt(productDetails[0].trim()),  
						    ProductCategory.ACCESSORY, 
						    productDetails[3].trim(),  
						    Double.parseDouble(productDetails[6].trim()),
						    Integer.parseInt(productDetails[5].trim()),
						    Double.parseDouble(productDetails[4].trim()), 
						    productDetails[7].trim());
					products.add(product);
				}
			}
		}
		stockFileScanner.close();
		return products;
	}
	
	// The function below reads the userAccounts.txt and creates corresponding user objects
	// Returns a list of objects
	// Contains an exception incase the file cannot be found.
	public List<User> loadUsers() throws FileNotFoundException{
			List<User> users = new ArrayList<>();
			File userFile = new File("UserAccounts.txt");
			Scanner userFileScanner = new Scanner(userFile);
			while (userFileScanner.hasNextLine()) {
				String[] userDetails = userFileScanner.nextLine().split("; ");
				Address address = new Address(    
					Integer.parseInt(userDetails[2].trim()),
					userDetails[3].trim(),
					userDetails[4].trim()
					);
				if (userDetails[5]. equals("admin")) {
					Admin user = new Admin(
							Integer.parseInt(userDetails[0].trim()),
							userDetails[1].trim(),
							Role.ADMIN,
							address);
					users.add(user);
				}
				else if (userDetails[5].equals("customer")) {
					Customer user = new Customer(
							Integer.parseInt(userDetails[0].trim()),
							userDetails[1].trim(),
							Role.CUSTOMER,
							address);
					users.add(user);
				}

			}				
			userFileScanner.close();
			return users;
	}
	
	// The function below allows for the stock.txt file to be updated, it writes to the file
	// usually called when a new product is added by admin.
	public void saveStock(List<Product> products) throws IOException {
		PrintWriter updateStock = new PrintWriter(new FileWriter("Stock.txt"));
		for (int i = 0; i < products.size(); i++) {
			Product currentProduct = products.get(i);
			if (currentProduct instanceof StrategyGame) {
				BoardGame boardGames = (BoardGame) currentProduct;
				updateStock.println(
						currentProduct.getProductId() + "; " +
						"board game" + "; " +
						"strategy" + "; " +
						currentProduct.getProductName() + "; " +
						currentProduct.getPrice() + "; " +
						currentProduct.getQuantityInStock() + "; " +
						currentProduct.getPurchaseCost() + "; " +
				        boardGames.getMaxPlayers()
				);
		}
			else if (currentProduct instanceof PartyGame) {
				BoardGame boardGames = (BoardGame) currentProduct;
				updateStock.println(
						currentProduct.getProductId() + "; " +
						"board game" + "; " +
						"party" + "; " +
						currentProduct.getProductName() + "; " +
						currentProduct.getPrice() + "; " +
						currentProduct.getQuantityInStock() + "; " +
						currentProduct.getPurchaseCost() + "; " +
				        boardGames.getMaxPlayers()
				);
		}
			else if (currentProduct instanceof Dice) {
				Accessory accessories = (Accessory) currentProduct;
				updateStock.println(
						currentProduct.getProductId() + "; " +
						"accessory" + "; " +
						"dice" + "; " +
						currentProduct.getProductName() + "; " +
						currentProduct.getPrice() + "; " +
						currentProduct.getQuantityInStock() + "; " +
						currentProduct.getPurchaseCost() + "; " +
				        accessories.getCompatibility()
				);
		}
			else if (currentProduct instanceof Miniature) {
				Accessory accessories = (Accessory) currentProduct;
				updateStock.println(
						currentProduct.getProductId() + "; " +
						"accessory" + "; " +
						"miniature" + "; " +
						currentProduct.getProductName() + "; " +
						currentProduct.getPrice() + "; " +
						currentProduct.getQuantityInStock() + "; " +
						currentProduct.getPurchaseCost() + "; " +
				        accessories.getCompatibility()
				);
		}
			else if (currentProduct instanceof AccessoryKit) {
				Accessory accessories = (Accessory) currentProduct;
				updateStock.println(
						currentProduct.getProductId() + "; " +
						"accessory" + "; " +
						"accessory kit" + "; " +
						currentProduct.getProductName() + "; " +
						currentProduct.getPrice() + "; " +
						currentProduct.getQuantityInStock() + "; " +
						currentProduct.getPurchaseCost() + "; " +
				        accessories.getCompatibility()
				);
			}
		}
		updateStock.close();
	}
}
