import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ArrayListPhoneContactsApp {

	public static ArrayList<Contact> readContactsFromFile(Scanner scnr) throws IOException {
		ArrayList<Contact> contactList = new ArrayList<Contact>();
		String fileName;
		String line;
		FileInputStream file;
		String[] lineArray;
		Contact aContact;

		System.out.print("Give file name: ");
		fileName = scnr.next();
		fileName += ".txt";
		file = new FileInputStream(fileName);
		Scanner filesc = new Scanner(file);

		while (filesc.hasNext()) {
			line = filesc.nextLine();
			line = line.trim();

			lineArray = line.split(",");
			aContact = new Contact(lineArray[0], lineArray[1], lineArray[2]);
			contactList.add(aContact);
		}

		return contactList;
	}

	public static void displayContacts(ArrayList<Contact> contactList, Scanner scnr) {

		int i = 0;
		for (Contact contact : contactList) {
			i++;
			System.out.println(contact.getFirstName() + ", " + 
					contact.getLastName() + ", " + contact.getPhone());

			if (i % 10 == 0) {
				scnr.nextLine();
				System.out.println("Press any key to continue...");
				String input = scnr.nextLine();
			}
		}
	}

	public static int countContacts(ArrayList<Contact> contactList) {

		// use a method from the ArrayList to display the number of elements in the list
		// ** your code here (1 or 2 lines)
		return contactList.size();
	}

	public static void addContact(ArrayList<Contact> contactList, Scanner scnr) {

		// ask the user for the contact information: first, last and phone
		// ** your code here (multiple lines)
		System.out.print("Enter first name: ");
		String first = scnr.next();
		System.out.print("Enter last name: ");
		String last = scnr.next();
		System.out.print("Enter phone number: ");
		String phoneNum = scnr.next();
		
		// instantiate a new Contact object with the given data
		// add the new contact to the list
		// ** your code here (1 or 2 lines)
		Contact newContact = new Contact(first, last, phoneNum);
		contactList.add(newContact);

	}


	public static void deleteContact(ArrayList<Contact> contactList, Scanner scnr) { 
		// declare variables here
		Contact contactToDelete = null;
		boolean success = false;
		String first;
		String last;

		// get information from the user for first and last name
		// ** your code here (multiple lines)
		System.out.print("Enter first name: ");
		first = scnr.next();
		System.out.print("Enter last name: ");
		last = scnr.next();
		
		// instantiate a new contact "contactToDelete" with only first and last names
		// this will use the second constructor
		// use an ArrayList method to "delete" the contact object you created
		// the method you use returns a boolean value - true when the object is found
		// assign the result of the method to the success variable 
		// ** your code here (1-2 lines)
		contactToDelete = new Contact(first, last);
		success = contactList.remove(contactToDelete);
		
		// check the value of success to see if the contact was removed
		if (success) 
			System.out.println("Contact removed");
		else
			System.out.println("Contact not found");

	}

	public static void updateContact(ArrayList<Contact> contactList, Scanner scnr) { 
		// declare variables
		Contact contactToFind, contactToUpdate;
		int indexToUpdate;
		boolean success;
		String first;
		String last;

		// get information from the user for first and last name
		// ** your code here (multiple lines)
		System.out.print("Enter first name: ");
		first = scnr.next();
		System.out.print("Enter last name: ");
		last = scnr.next();
		
		// instantiate a new Contact object "contactToFind" using the first and last name
		// you will use the second constructor from Contact here
		// ** your code here (one line)
		contactToFind = new Contact(first, last);

		// use an ArrayList method to 
		// find the location (index) of the contact in the list
		// ** your code here (one line)
		int index = contactList.indexOf(contactToFind);
		
		//
		if (index == -1) {
			System.out.println("Contact not found");
		}
		else { // the contact was found
			
			// use an ArrayList method to
			// find the actual Contact object using the index
			// hold on to the return object in the variable "contactToUpdate"
			// get the new phone number from the user
			// update the phone number using the setPhone method
			// ** your code here (multiple lines)
			contactToUpdate = contactList.get(index);
			System.out.print("Enter phone number to update: ");
			contactToUpdate.setPhone(scnr.next());

			// if all works out this line should display the contact with a new phone number
			System.out.println("Updated Contact Info: " +  contactToUpdate);

		}

	}
	
	
	public static void sortContacts(ArrayList<Contact> contactList) {
		
		// Use a method from the ArrayList to order the data
		// This works automatically because of the compareTo method in the Contact class
		// ** your code here (one line)
		contactList.sort(null);
		
	}


	public static void writeContactsToFile(ArrayList<Contact> contactList, Scanner scnr) throws IOException {
		//search how to write to a file using file input stream
		String fileName;
		FileOutputStream fileStream = null;
		PrintWriter outFS = null;
		
		// get filename, add .txt extension, and open file stream
		// instantiate the PrintWriter on the file stream
		// ** your code here (multiple lines)
		System.out.print("Enter the filename to write: ");
		fileName = scnr.next();
		fileStream = new FileOutputStream(fileName + ".txt");
		outFS = new PrintWriter(fileStream);
		
		// use a for each loop to iterate through the contact list and 
		// print each contact info
		// ** your code here (4 lines will work if you put the commas with the info) 
		for (Contact contact : contactList) {
			outFS.println(contact);
		}

		// flush and close the output streams
		outFS.flush();
		fileStream.close();
		
	}

	public static void main(String[] args) throws IOException {
		Scanner scnr = new Scanner(System.in);
		ArrayList<Contact> contactList = null;
		int choice = -1;
		do {
			System.out.println();
			System.out.println("1) read contacts from file");
			System.out.println("2) display contacts");
			System.out.println("3) show number of contacts");
			System.out.println("4) add a contact");
			System.out.println("5) remove a contact");
			System.out.println("6) update phone number for contact");
			System.out.println("7) sort contacts by last name");
			System.out.println("8) write contact list to file");
			System.out.println();
			System.out.println("9) exit");
			System.out.println();
			System.out.println("Enter your choice");

			choice = scnr.nextInt();

			switch(choice) {
			case 1:
				contactList = readContactsFromFile(scnr);
				break;

			case 2:
				displayContacts(contactList, scnr);
				break;

			case 3:
				System.out.println("Number of contacts: " + countContacts(contactList));
				break;

			case 4:
				addContact(contactList, scnr);
				break;

			case 5:
				deleteContact(contactList, scnr);
				break;

			case 6:
				updateContact(contactList, scnr);
				break;

			case 7:
				sortContacts(contactList);
				break;

			case 8:
				writeContactsToFile(contactList,scnr);
				break;

			}
			
			scnr.nextLine();
			System.out.println("Press any key to continue...");
			scnr.nextLine();

		} while (choice != 9);

		if (choice == 9) {
			System.out.println("Program ended");
		}


	}

}
