package objectOrientatedProgrammingCoursework;
// Represents the receipt generated after a successful payment.
public class Receipt {
	
	private String message;
	
	public Receipt(String message) {
		this.message = message; 
	}
	
	public void displayReceipt() {
		System.out.println(message);
	}
	
	@Override
	public String toString() {
		return message;
	}
}
