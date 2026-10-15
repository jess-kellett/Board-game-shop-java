package objectOrientatedProgrammingCoursework;
// This class loads stock and users from files and routes logged in users to the correct CLI.
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// It contains two functions main and printWelcomeMenu
// PrintWelcomeMenu prints to the user the options of which user accounts can be selected and is the first page shown to those running the program
// main loads calls FileManager and loads both the stock and users.
// main processes the customer input, if it is a valid input it calls either adminCLI or customerCLI or prints the exit message
// If it isn't a valid input it prints an error message.
public class Main {

	
    public static void main(String[] args) {
        Scanner consoleInput = new Scanner(System.in);

        System.out.println("WELCOME");
        
        FileManager fileManager = new FileManager();
        Stock stock = new Stock();
        List<User> users = new ArrayList<>();
        
        try {
            List<Product> products = fileManager.loadStock();
            for (int i = 0; i < products.size(); i++) {
                stock.addProduct(products.get(i));
            }
            users = fileManager.loadUsers();
        } catch (FileNotFoundException e) {
            System.out.println("Error: could not find stock or user files.");
            return;
        }

      
        
        while (true) {
            printWelcomeMenu(users);

            String line = consoleInput.nextLine().trim();
            
            if (line.isEmpty()) {
            	System.out.println("Invalid input - please enter a number");
            	continue;
            }
            try {
            	int selection = Integer.parseInt(line.trim());
            	if (selection == 0) {
            		System.out.println("Goodbye");
            		return;
            	} 
	            if (selection >= 1 && selection <= users.size()) {
	                User selectedUser = users.get(selection - 1);
	               if (selectedUser instanceof Admin) {
	                    AdminCLI.run(consoleInput, (Admin) selectedUser, stock);
	                } else if (selectedUser instanceof Customer) {
	                    CustomerCLI.run(consoleInput, (Customer) selectedUser, stock);
	                }
	            } else {
	                System.out.println("Invalid input");
	            }
	        } catch (NumberFormatException e){
	        	System.out.println("Invalid input - please enter a number.");
	        	}
            }
    }

    private static void printWelcomeMenu(List<User> users) {

        System.out.println("PLEASE SELECT USER BY INPUTTING THE CORRESPONDING NUMBER (or 0 for exit)");
        for (int i = 0; i < users.size(); i++) {
        	User currentUser = users.get(i);
        	System.out.println((i + 1) + ") " + currentUser.getUserId() + " | " + currentUser.getName() + " | " + currentUser.getRole());
        }
        System.out.println("0) Exit");
    }
}