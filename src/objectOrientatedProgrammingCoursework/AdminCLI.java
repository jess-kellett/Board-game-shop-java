package objectOrientatedProgrammingCoursework;
//This class is a CLI for admin users.
//It allows admin users to either view all products or enter a new product to the stock
//When entering a new product to system, the program outputs a series of statements indicating what the admin user 
//should input and reads the consoleInput storing the values in variables and checking the correct data types have been entered.
//It can print a series of error messages depending on where the error occurs for example if the product already exists.
//It then creates an object containing the inputed information and saves stock.

import java.io.IOException;
import java.util.Scanner;
public class AdminCLI {
	public final static String NOT_IMPLEMENTED = "Not implemented";
	public final static String INVALID = "Invalid input";

    public static void run(Scanner consoleInput, Admin admin, Stock stock) {
    	System.out.println("ADMIN VIEW");
        

        
        while (true) {
        	printAdminMenu();
            try { 
            int adminSelection = Integer.parseInt(consoleInput.nextLine().trim());
            
        	switch (adminSelection) {
        		case 1:
        			admin.viewAllProducts(stock);
        			System.out.println();
        			break;
        		case 2:
        		    System.out.println("Enter product ID:");
        		    int productId = Integer.parseInt(consoleInput.nextLine().trim());
        		    System.out.println("Enter category (board game / accessory):");
        		    String category = consoleInput.nextLine().trim().toLowerCase();
        		    if (category.equals("board game")) {
            		    System.out.println("Enter type (strategy / party):");
        		    } else {
        		    	System.out.println("Enter type (dice / miniature / accessory kit):");
        		    }
        		    String type = consoleInput.nextLine().trim().toLowerCase();
        		    System.out.println("Enter product name:");
        		    String name = consoleInput.nextLine().trim();
        		    System.out.println("Enter price - please enter both pounds and pence seperated by . :"); 
        		    double price = Double.parseDouble(consoleInput.nextLine().trim());
        		    System.out.println("Enter quantity in stock:"); 
        		    int quantity = Integer.parseInt(consoleInput.nextLine().trim());
        		    System.out.println("Enter purchase cost - please enter both pounds and pence seperated by . :");
        		    double purchaseCost = Double.parseDouble(consoleInput.nextLine().trim());
        			Product newProduct = null;
        			if (category.equals("board game")) {
        				System.out.println("Enter max players:");
        		        int maxPlayers = Integer.parseInt(consoleInput.nextLine().trim());
        		        if (type.equals("strategy")) {
        		            newProduct = new StrategyGame(productId, ProductCategory.BOARDGAME, name, purchaseCost, quantity, price, BoardGameType.STRATEGY, maxPlayers);
        		        } else if (type.equals("party")) {
        		            newProduct = new PartyGame(productId, ProductCategory.BOARDGAME, name, purchaseCost, quantity, price, BoardGameType.PARTY, maxPlayers);
        		        }
        			} else if (category.equals("accessory")) {
        		        System.out.println("Enter compatibility:");
        		        String compatibility = consoleInput.nextLine().trim();
        		        if (type.equals("dice")) {
        		            newProduct = new Dice(productId, ProductCategory.ACCESSORY, name, purchaseCost, quantity, price, compatibility);
        		        } else if (type.equals("miniature")) {
        		            newProduct = new Miniature(productId, ProductCategory.ACCESSORY, name, purchaseCost, quantity, price, compatibility);
        		        } else if (type.equals("accessory kit")) {
        		            newProduct = new AccessoryKit(productId, ProductCategory.ACCESSORY, name, purchaseCost, quantity, price, compatibility);
        		        }
        		    }
        			if (stock.findById(productId) != null) {
        			    System.out.println("Error: a product with that ID already exists!");
        			} else if (newProduct != null) {
        		        admin.addProduct(stock, newProduct);
                		FileManager fileManager = new FileManager();
                		try {
                			fileManager.saveStock(stock.getProducts());
                			System.out.println("Product added successfully!");
                		} catch (IOException e) {
                			System.out.println("Error saving the stock.");
                		}
        		    } else {
        		        System.out.println("Invalid category or type entered.");
        		    }
        		    System.out.println();
        		    break;
        		case 0:
        			return;
        		default:
        			System.out.println("Please enter a number between 0-2. ");
            }
        	} catch (NumberFormatException e) {
            	System.out.println("Invalid input");
            	System.out.println();
            	continue;
            }
            }
    }
    
    
    private static void printAdminMenu() {
    	
        System.out.println("PLEASE SELECT ACTION BY INPUTTING THE CORRESPONDING NUMBER (or 0 for logout)");
        System.out.println("1) View all products");
        System.out.println("2) Add new product");
        System.out.println("0) Log out");
    }
}