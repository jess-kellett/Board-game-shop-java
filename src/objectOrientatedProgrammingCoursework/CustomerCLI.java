package objectOrientatedProgrammingCoursework;
//This class is a CLI for customer users.
//Allows for customers to enter 0-7 which corresponds to a different task the customer may wish to complete.
//Allows customer to view all products in stock, add products to basket, view the basket, pay for the basket
//using paypal or credit card, cancel basket (which clears the basket list), search the stock by id or 
//compatibility or exit their account.
//Originally displays all options to the user in printCustomerMenu.
import java.util.List;
import java.util.Scanner;

public class CustomerCLI {

    public static void run(Scanner consoleInput, Customer selectedUser, Stock stock) {

        System.out.println("CUSTOMER VIEW");
        while (true) {
            printCustomerMenu();
            try { 
            int customerSelection = Integer.parseInt(consoleInput.nextLine().trim());
            
            switch (customerSelection) {
            case 1:
            	selectedUser.viewAllProducts(stock);
            	System.out.println();
            	break;
            
            case 2:
            	System.out.println("Enter product ID: ");
            	int productId = Integer.parseInt(consoleInput.nextLine().trim());
            	Product productIdFound = selectedUser.searchById(productId, stock);
            	if (productIdFound == null) {
            		System.out.println("Product not found.");
            	} else {
            		System.out.println(productIdFound.toString());
            		System.out.println("Enter wanted quantity; ");
            		int quantity = Integer.parseInt(consoleInput.nextLine().trim());
            		selectedUser.addToBasket(productIdFound,  quantity);
            	}
            	System.out.println();
            	break;
            case 3:
                selectedUser.viewBasket();
                System.out.println(); 
                break;
            case 4:
            	System.out.println("Enter number corresponding to wanted payment method - 1) PayPal 2) Credit Card ");
            	int paymentMethodChosen = Integer.parseInt(consoleInput.nextLine().trim());
            	PaymentMethod paymentMethod = null;
            	if (paymentMethodChosen == 1) {
                    System.out.println("Enter PayPal email: ");
                    String email = consoleInput.nextLine().trim();
                    paymentMethod = new PayPalPayment(email);
            	} else if (paymentMethodChosen == 2) {
            		System.out.println("Enter card number: ");
            		String cardNumber = consoleInput.nextLine().trim();
            		System.out.println("Enter security code: ");
            		String securityCode = consoleInput.nextLine().trim();
            		paymentMethod = new CreditCardPayment(cardNumber, securityCode);
            	} else {
            		System.out.println("Invalid payment method.");
            	}
            	if (paymentMethod != null) {
            		selectedUser.pay(paymentMethod);
            	}
            	System.out.println();
            	break;
            case 5:
            	selectedUser.cancelBasket();
            	System.out.println();
            	break;
            case 6:
            	System.out.println("Enter product ID: ");
            	int searchId = Integer.parseInt(consoleInput.nextLine().trim());
            	Product resultsSearchId = selectedUser.searchById(searchId, stock);
            	if (resultsSearchId == null) {
            		System.out.println("No product found with given product Id.");
            	} else {
            		System.out.println(resultsSearchId.toString());
            	}
            	System.out.println();
            	break;
            case 7:
            	System.out.println("Enter compatibility being searched for (Please ensure it is spelt correctly and begins with a capital letter): ");
            	String compatibilty = consoleInput.nextLine().trim();
            	List<Product> compatibilityMatches = selectedUser.searchByCompatibility(compatibilty, stock);
            	if (compatibilityMatches.isEmpty()) {
            		System.out.println("No compatible products found.");
            	} else {
                    for (int i = 0; i < compatibilityMatches.size(); i++) {
                        System.out.println(compatibilityMatches.get(i).toString());
                    }
            	}
            	System.out.println();
            	break;
            case 0:
            	return;
            default:
    			System.out.println("Please enter a number between 0-7. ");
            }
            } catch (NumberFormatException e) {
            	System.out.println("Invalid input");
            	System.out.println();
            	continue;
            }
        }
    }
    
    private static void printCustomerMenu() {
        System.out.println("PLEASE SELECT ACTION BY INPUTTING THE CORRESPONDING NUMBER (or 0 for logout)");
        System.out.println("1) View all products");
        System.out.println("2) Add product to shopping basket");
        System.out.println("3) View contents of shopping basket");
        System.out.println("4) Purchase items in the basket");
        System.out.println("5) Cancel shopping basket");
        System.out.println("6) Lookup with product ID");
        System.out.println("7) Search/filter based on compatilbility");
        System.out.println("0) Log out");
    }
    
}
