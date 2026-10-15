package objectOrientatedProgrammingCoursework;
//Processes payment via credit card and returns a receipt.
//implements PaymentMethod.
import java.time.LocalDate;
public class CreditCardPayment implements PaymentMethod {

	private String cardNumber;
	private String securityCode;
	
	public CreditCardPayment(String cardNumber, String securityCode) {
		this.cardNumber = cardNumber;
		this.securityCode = securityCode;
	}
	
	@Override
	public Receipt processPayment(double total, Address address) {
		String message = String.format("%.2f", total) + " paid by Credit Card " + cardNumber + " on " + LocalDate.now() + ". Billing address: " + address.getFullAddress();
		return new Receipt(message);
	}

}
