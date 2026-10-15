package objectOrientatedProgrammingCoursework;
// This is an interface for payment processing, implemented by PayPalPayment and CreditCardPayment

public interface PaymentMethod {
	Receipt processPayment(double total, Address address);
}
