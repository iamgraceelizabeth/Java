import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * FIXME LIST:
 *  + fix my add so that it actually adds and is not just displayable.
 */

/**
 * This program will read a file of contact names and numbers and store it
 * in a multi-dimensional array.  It will also allow to count, display, add, 
 * remove, modify, sort, and write to a file the contact list. 
 * @author Grace Merry
 */
public class PhoneContactsApp {
    // declare class variables
    public static int MAX_SIZE = 100;
    public static final int MAX_FIELDS = 3;

	public static void main(String[] args) throws IOException {
		// declare variables
		String[][] contactList = new String[MAX_SIZE][MAX_FIELDS];
		Scanner scnr = new Scanner(System.in);
		int choice = 0;
		int numContacts = 0;
		String update;
		
		do {
			// display menu
			System.out.println();
			System.out.println("1) read contacts from file");
			System.out.println("2) display contacts");
			System.out.println("3) show number of contacts");
			System.out.println("4) add a contact");
			System.out.println("5) remove a contact");
			System.out.println("6) update phone for a contact");
			System.out.println("7) sort contacts by last name");
			System.out.println("8) write contact list to file");
			System.out.println("");
			System.out.println("9) exit");
			System.out.println("");
			
			// get input from user
            System.out.print("Enter your choice: ");
            choice = scnr.nextInt();
            if (choice > 9) {
            	System.out.println("Please input a number between 0 and 9.");
            }
            
			// use switch to call desired methods based on choice
			// pay attention to updating variables based on the method
			// for example, when adding a contact, 
			// we will assign the result of the method to the contacts array
			// add one case statement at a time as you write each method
			// test it and make sure it works before moving on to the next one
			
			switch(choice) {
				case 1: 
					contactList = readContactsFromFile(scnr);
					break;
				case 2:
					displayContacts(contactList, scnr);
					break;
				case 3:
					numContacts = countContacts(contactList);
					System.out.println("There are " + numContacts + " contacts in your list");
				    break;
				case 4:
					addContact(contactList, numContacts, scnr);
					break;
				case 5:
					deleteContact(contactList, numContacts, scnr);
					break;
				case 6:
					updateContact(contactList, numContacts, scnr);
					break;
				case 7:
					sortContacts(contactList, numContacts);
					break;
				case 8:
					writeContactsToFile(contactList,numContacts, scnr);
					break;
				
			}
		} while(choice != 9);  // finish the while here

	    System.out.println("Program ended");
	}

	// start writing methods here
	/**
	 * addContact adds a contact entry to the end of contactList
	 * @param contactList list to be added to
	 * @param numOfContacts number of contacts
	 * @param input contact input from user
	 * @return new number of contacts in the list
	 */
	public static int addContact(String[][] listToAddTo, int numOfContacts, Scanner input) {
		//declare variables
		String newFirstName;
	    String newLastName;
	    String newPhoneNumber;
	    String[] newContact;
	    String stringContact;
	    int row;
		
		//determines if there is room in the array for more contacts
		if (numOfContacts < MAX_SIZE) {
			//gets input from the user
			System.out.print("Enter the first name: ");
			newFirstName = input.next();
			System.out.print("Enter the last name: ");
			newLastName = input.next();
			System.out.print("Enter the phone number (999-999-9999): ");
			newPhoneNumber = input.next();
			
			stringContact = newFirstName + " " + newLastName + " " + newPhoneNumber;
			newContact = stringContact.split(" ");
			
			//append the entry
			for (row = 0; row < listToAddTo.length; ++row) {
				if (row == numOfContacts + 1) {
					listToAddTo[row][0] = newContact[0];
					listToAddTo[row][1] = newContact[1];
					listToAddTo[row][2] = newContact[2];
				}
			}
			
			++numOfContacts;
			
		}
		else {
			System.out.print("There is no more room in your list to add another contact.");
		}
		
		return numOfContacts;
	}
	
	/**
	 * countContacts counts the number of contacts in contactList
	 * @param contactList list that is counted
	 * @return integer value of the number of contacts in the list
	 */
	public static int countContacts(String[][] contactList) {
		//declare variables
		int totalContacts = 0;
		int row;
		int col;
		boolean countable = true;
		
		//iterate through the array to count the entries
		for (row = 0; row < contactList.length; ++row) {
			for (col = 0; col < MAX_FIELDS; ++col) {
				if (contactList[row][col] != null) {
					countable = true;
				}
				else {
					countable = false;
				}
			}
			//counts entry if it doesn't have a null value
			if (countable == true) {
				++totalContacts;
			}
		}
		
		return totalContacts;
	}
	
	/**
	 * deleteContacts deletes a contact specified by the user from the contactList
	 * @param contactList list that is getting a contact deleted from
	 * @param numOfContacts the number of contacts
	 * @param input contact input from user
	 * @return new number of contacts
	 */
	public static int deleteContact(String[][] contactList, int numOfContacts, Scanner input) {
		//declare the variables
		int i;
		int row;
		int col;
		int index = -1;
		String first;
		String last;
		
		//get what contact the user wants to delete
		System.out.println("Deleting contact.");
		System.out.print("Enter first name: ");
		first = input.next();
		System.out.print("Enter the last name: ");
		last = input.next();
		
		//find and save the index location of the value to delete
		for (row = 0; row < contactList.length; ++row) {
			if (first.equals(contactList[row][0]) && last.equals(contactList[row][1])) {
				index = row;
				for (row = index; row < numOfContacts; row++) {
					contactList[index][0] = contactList[index + 1][0];
					contactList[index][1] = contactList[index + 1][1];
					contactList[index][2] = contactList[index + 1][2];
					if (row == numOfContacts - 1) {
						contactList[row][0] = null;
						contactList[row][1] = null;
						contactList[row][2] = null;
					}
				}
			}
		}
		
        //decrease the number of contacts
		numOfContacts -= 1;
		
		return numOfContacts;
	}
	
	/**
	 * displayContacts displays only the data entries in contactList that 
	 * contain contact data five entries at a time
	 * @param contactList list to display
	 * @param input control input
	 */
	public static void displayContacts(String[][] contactList, Scanner input) {
		//declare variables
		int row;
		int col;
		int listLength= contactList.length;
		boolean printable = false;
		String continueInput;
		
		//iterate through the list to determine what to print
		for (row = 0; row < listLength; ++row) {
			for (col = 0; col < MAX_FIELDS; ++col) {
				if (contactList[row][col] == null) {
					printable = false;
				}
				else {
					printable = true;
				}
			}
			//print contact entry
			if (printable == true) {
				if (row != 0 && row % 5 == 0) {
					System.out.print("Enter any key to continue...");
					continueInput = input.next();
				}
				System.out.println(Arrays.toString(contactList[row]));
			}
		}
	}
	
	/**
	 * readContactsFromFile reads a file of contacts specified by the user
	 * @param input scanner for input
	 * @return a 2D String array that contains MAX_SIZE rows and MAX_FIELDS columns
	 */
	public static String[][] readContactsFromFile(Scanner input) throws IOException {
		//define variables
		String[][] newContactList = new String[MAX_SIZE][MAX_FIELDS];
		FileInputStream inputFile = null;
		String file;
		int numRows = 0;
		
		//open the file specified by the user
		System.out.print("Enter the filename to read: ");
		file = input.next();
		file = file + ".txt";
		try {
			inputFile = new FileInputStream(file);
			input = new Scanner(inputFile);
            
			//read the file & populate the double array
			while (input.hasNext()) {
				String contactInfo = input.nextLine();
				String[] contactInfoArray = contactInfo.trim().split(",");
				newContactList[numRows][0] = contactInfoArray[0];
				newContactList[numRows][1] = contactInfoArray[1];
				newContactList[numRows][2] = contactInfoArray[2];
				numRows += 1;
			}

			input.close();//close Scanner
			inputFile.close();//close the file
			
		}
		//catch error if the file input not found
		catch(FileNotFoundException e) {
			System.out.println("The file you have input could not be found.");
		}

		return newContactList;
	}
	
	/**
	 * sortContacts sorts the contents of contactList alphabetically by last name
	 * @param listToSort list to be sorted
	 * @param numOfContacts number of contacts
	 */
	public static void sortContacts(String[][] listToSort, int numOfContacts) {
		//declare the variables
		int i;
		int j;
		int row;
		int smallestIndex;
		String[] temp = new String[MAX_FIELDS];
		
		//use selection sort to sort the values by their last names
		for (i = 0; i < numOfContacts; ++i) {
			smallestIndex = i;
			for (j = i + 1; j < numOfContacts; ++j) {
				if (listToSort[j][1].compareTo(listToSort[smallestIndex][1]) < 0) {
					smallestIndex = j;
				}
				else if (listToSort[j][1].compareTo(listToSort[smallestIndex][1]) == 0) {
					if (listToSort[j][0].compareTo(listToSort[smallestIndex][0]) < 1) {
						smallestIndex = j;
					}
				}
			}
			
			//swap listToSort[i] and listToSort[indexSmallest]
			temp = listToSort[i];
			listToSort[i] = listToSort[smallestIndex];
			listToSort[smallestIndex] = temp;
		}
		
	}
	
	/**
	 * updateContact updates a contact in contactList specified by the user
	 * @param contactList list of contacts that the contact to update is in
	 * @param numOfContacts number of contacts
	 * @param input contact input
	 */
	public static void updateContact(String[][] contactList, int numOfContacts, Scanner input) {
		//declare variables
		String firstName;
		String lastName;
		String newPhoneNum;
		boolean update = true;
		int row; 
		int col;
		
		//get input from user to update contact
		System.out.println("Updating contact.");
		System.out.print("Enter first and last name: ");
		firstName = input.next();
		lastName = input.next();
		System.out.print("Enter new number: ");
		newPhoneNum = input.next();
		
		//iterate through the loop to find the contact
		for (row = 0; row < contactList.length; ++row) {
			for (col = 0; col < MAX_FIELDS; ++col) {
				if (firstName.equals(contactList[row][0]) && lastName.equals(contactList[row][1])) {
					update = true;
				}
				else {
					update = false;
				}
			}
			//update the contact
			if (update == true) {
				contactList[row][2] = newPhoneNum;
			}
		}
		
	}
	
	/**
	 * writeContactsToFile creates and writes only existing contacts in contactList
	 * to the output file specified by the user
	 * @param contactList list output to a file
	 * @param numOfContacts number of contacts in list
	 * @param outputFile gets the file to output to
	 */
	public static void writeContactsToFile(String[][] contactList, int numOfContacts, Scanner outputFile) throws IOException {
		//declare and initialize variables
		FileOutputStream outStream;
		PrintWriter outputWriter;
		String fileName;
		int tracker = 0;
		
		//get the file to write to and create that file
		System.out.print("Enter the filename to write: ");
		fileName = outputFile.next();
		outStream = new FileOutputStream(fileName + ".txt");
		outputWriter = new PrintWriter(outStream);
        
		//read the file & populate the double array
		while (tracker < numOfContacts) {
			outputWriter.printf("[%s,%s,%s]\n", contactList[tracker][0], contactList[tracker][1], contactList[tracker][2]);
			tracker += 1;
		}

		outputWriter.close();//close the output file
		
	}
}