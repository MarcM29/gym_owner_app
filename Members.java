public class Members implements Comparable <Members> {
	
	private String name;
	private String surname;
	private String phoneNumber;
	private String email;
	private String address;
	private String postalCode; 
	
	
	
	private int numberOfMissedPayments;
	
	public Members(String name, String surname, String phoneNumber, String email, String address, String postalCode ) {
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.postalCode = postalCode;
		
		this.numberOfMissedPayments = 0; 
	}
	
	public String toString() {
		return name + " " + surname;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public int getNumberOfMissedPayments() {
		return numberOfMissedPayments;
	}
	
	public void memberMissedPayment() {
		numberOfMissedPayments++;
	}
	
	
	@Override
	public int compareTo(Members arg0) {
		// TODO Auto-generated method stub
		return surname.compareTo(arg0.surname);
	}
}