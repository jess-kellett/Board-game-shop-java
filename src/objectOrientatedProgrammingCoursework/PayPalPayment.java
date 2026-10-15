package objectOrientatedProgrammingCoursework;
import java.time.LocalDate;
// Processes payment via pay pal and returns a receipt.
// implements PaymentMethod.
public class PayPalPayment implements PaymentMethod {
	
	private String email;
	
	public PayPalPayment(String email) {
		this.email = email;
	}
	
	@Override
	public Receipt processPayment(double total, Address address) {
		String message = String.format("%.2f", total) + " paid via PayPal using " + email + " on " + LocalDate.now() + ". Billing address: " + address.getFullAddress();
		return new Receipt(message);
	}

}
