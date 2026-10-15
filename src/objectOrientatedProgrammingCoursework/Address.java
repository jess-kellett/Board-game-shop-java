package objectOrientatedProgrammingCoursework;
//This class contains information about user addresses for receipts and user accounts and formats it into the correct address format.
public class Address {
	
	private int houseNumber;
	private String postcode;
	private String city;
	
	public Address(int houseNumber, String postcode, String city) {
		this.houseNumber = houseNumber;
		this.postcode = postcode;
		this.city = city;
	}
	
	public String getFullAddress() {
		return houseNumber + " " + postcode + " " + city;
	}
	
	@Override
	public String toString() {
		return getFullAddress();
	}

}
