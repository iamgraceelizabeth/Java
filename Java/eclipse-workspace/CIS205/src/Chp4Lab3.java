/** 
 * @author Grace Merry
 * This program will prompt the user for a radius and a choice between area and circumference. 
 * It will display either the area or circumference of a circle depending on the users choice.
 */ 
import java.util.Scanner;

public class Chp4Lab3 {
	
	public static void main(String[] args) {
		//Initialize variables
		Scanner scnr = new Scanner(System.in);
		float userRadius;
		double area;
		double circumference; 
		char userChoice; 
		
		//Prompt user for radius, and either Area or Circumference
		System.out.print("Please enter a radius (feet): ");
		userRadius = scnr.nextFloat();
		System.out.print("Enter A (Area) or C (Circumference): ");
		userChoice = scnr.next().charAt(0);
		
		//Outputs Area or Circumference depending on user's choice
		if ((userChoice == 'A') || (userChoice == 'a')) {
			area = Math.PI * (userRadius * userRadius);
			System.out.printf("Area: %.4f square feet", area);
		}
		else if ((userChoice == 'C') || (userChoice == 'c')) {
			circumference = (float)(2 * Math.PI * userRadius);
			System.out.printf("Circumference: %.4f feet", circumference);
		}
		else {
			System.out.println("I'm sorry, I did not understand your choice.");
		}
		
		//Close the scanner
		scnr.close();
	}

}
