
public class Contact implements Comparable<Contact> {

	/* declare three private string instance variables
	 * firstName, lastName, phone
	 */
    private String firstName;
    private String lastName;
    private String phone;

	/**
	 * Create a constructor from three parameters 
	 * @param firstName the contact's first name
	 * @param lastName the contact's last name
	 * @param phone the contact phone number
	 */
	public Contact(String firstName, String lastName, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}
	
	/**
	 * Create a constructor from two parameters.
	 * Make the phone default to an empty string.
	 * @param firstName the contact's first name
	 * @param lastName the contact's last name
	 */
	public Contact(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/* declare getter and setters for all the instance variables
	 * you should end up with six methods 
	 */
	
	/**
	 * sets the firstName
	 */
	public void setFirstName(String name) {
		firstName = name;
	}
	
	/**
	 * sets the lastName
	 */
	public void setLastName(String name) {
		lastName = name;
	}
	
	/**
	 * sets the phone number
	 */
	public void setPhone(String number) {
		phone = number;
	}
	
	/**
	 * gets the first name
	 * @return the first name value
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * gets the last name
	 * @return the last name value
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * gets the phone number name
	 * @return the phone number value
	 */
	public String getPhone() {
		return phone;
	}
	
	@Override
	public String toString() {
		return "[" + getFirstName() + ", " + getLastName() + ", " + getPhone() + "]";
	}


	@Override
	public boolean equals(Object obj) {
		
		Contact aContact = (Contact) obj;

		return ((getFirstName().compareTo(aContact.getFirstName()) == 0) && 
				(getLastName().compareTo(aContact.getLastName()) == 0));
	}

	@Override
	public int compareTo(Contact aContact) {
		// TODO Auto-generated method stub
		
		int compareLastValue = getLastName().compareTo(aContact.getLastName());
		if ( compareLastValue == 0)
			return (getFirstName().compareTo(aContact.getFirstName()));
		else
			return compareLastValue;

	}
	

	
	
}
