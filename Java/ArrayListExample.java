// imports 
import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListExample {

	public static void main(String[] args) {
		// Variables - these should be enough, but you may add additional variables if you need to
		Scanner scnr = new Scanner(System.in);
		int number, index;
		ArrayList<Integer> rateList = new ArrayList<Integer>();

		// get values from user and put them in the rateList
		System.out.print("Enter four integer values: ");
		for (int i = 0; i < 4; ++i) {
		   number = scnr.nextInt();
		   rateList.add(number);
		}
		System.out.println("List values: " + rateList);
		
		// get number from user
		System.out.print("Enter a number to add: ");
		number = scnr.nextInt();
		
		//add number to the arrayList
        rateList.add(number);

		System.out.println("List values: " + rateList);
		
		// check if value added is in the list
		System.out.print("Enter a number to check: ");
		number = scnr.nextInt();
		containsValue(rateList, number);
		
		// get value and index from user
		System.out.print("Enter a number to add: ");
		number = scnr.nextInt();
	    System.out.print("At index value: ");
	    index = scnr.nextInt();
		
		// add number at index value
		rateList. add(index, number);

		System.out.println("List values: " + rateList);

		// get value and index from user to check
		System.out.print("Enter a number to check: ");
		number = scnr.nextInt();
	    System.out.print("At index value: ");
	    index = scnr.nextInt();
		
		// check if value exists at specific index location
		containsValue(rateList, number, index);
      
        System.out.println("List values: " + rateList);
	}


	/**
	 * Checks if the value is contained in the rateList
	 * Displays an appropriate message to indicate if the value is in, or is not in the list
	 *
	 * @param rateList
	 * @param value
	 */
	
	public static void containsValue(ArrayList<Integer> rateList, int value) {
	   //initialize variables
	   boolean status = false;
	   
	   //iterate throught rateList
		for (Integer element : rateList) {
		   if (value == element) {
		      status = true;
		   }
		}
		
		//prints message depending on if status is true or not
		if (status == true) {
		   System.out.println("The number " + value + " is in the list");
		}
		else {
		   System.out.println("The number " + value + " is not in the list");
		}
	}


	/**
	 * Checks if the value is contained in the rateList at the index location
	 * Displays an appropriate message to indicate if the value is in the location,
	 * if it is in the list but in another location, or is not in the list 
	 *
	 * @param rateList
	 * @param value
	 * @param index
	 */
	public static void containsValue(ArrayList<Integer> rateList, int value, int index) {
	    //check if the value is at the specified index
        if (rateList.get(index) == value) {
           System.out.printf("The value %d is at index %d\n", value, index);
        }
        else {
           System.out.printf("The value %d is not at index %d\n", value, index);
           int realIndex = rateList.indexOf(value);
           if (realIndex == -1) {
			   System.out.println("The value " + value + " is not in the list");
           }
           else {
               System.out.printf("The value %d is at index %d\n", value, realIndex);
           }
         
        }
      
	}

}
