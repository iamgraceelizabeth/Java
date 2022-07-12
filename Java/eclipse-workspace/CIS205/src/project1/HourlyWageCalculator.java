package project1;

import java.util.Scanner;

/**
 * This Program will calculate two weeks of hourly pay for an individual. 
 * Payment will depend on the actual hours worked, overload, and the week of 
 * the year the hours were worked.  The results will be displayed to the user. 
 * @author Grace Merry
 *
 */
public class HourlyWageCalculator {

	// Declare the global constant variables here
	// Use the names given in the instructions
	final static double HOUR_RATE = 15.00;
	final static double BONUS_RATE = 2.00;
	final static double OVERLOAD_PERCENT = 1.5;
	final static double REGULAR_HOURS = 40.0;
	
	public static void main(String[] args) {
		// I am starting out this method for you
		Scanner scnr = new Scanner(System.in);
		Scanner hourInput = new Scanner(System.in);
		int weekNumber = 0;
		String answer = "y";
		double[] weekHours;
		
		// use a while loop to run program
		// this loop should give user the option to calculate wages more than once
		while (answer.equals("y")) {
			// inside this loop
			// ask user to enter values
			// call methods getInputFromUser and calculatePayForWeek
			// at the end of the loop ask user if they want to do another calculation
			do {
				//gets a valid week worked
				System.out.print("Enter week worked: ");
				weekNumber = scnr.nextInt();
				if ((weekNumber >= 1 && weekNumber <= 52) == false) {
					System.out.println("Week must be between 1 and 52, please try again");
				}
			} while ((weekNumber >= 1 && weekNumber <= 52) == false);

			//calls the getInputFromUser and calculatePayForWeek methods to get 
			//the number of hours the user worked and calculate the users pay off that
			weekHours = getInputFromUser(hourInput, weekNumber);
			calculatePayForWeek(weekNumber, weekHours);
			System.out.print("Would you like to calculate pay for another week? y/n: ");
			answer = scnr.next();
			
			//prints a thank you message if the user dosn't want to keep calculating wages
			if (answer.equals("n")) {
				System.out.println("");
				System.out.println("Thanks for using the wage calculator tool.");
			}
		}
	}
	
	// *** declare methods beginning here
	
	// * write getInputFromUser method here
	/**
	 * getInputFromUser gets the user input for the hours worked.
	 * 
	 * @param input Scanner used for getting the input
	 * @param weekNum the week number that it's getting the input for
	 * @return a double array of the hours worked
	 */
	public static double[] getInputFromUser(Scanner input, int weekNum) {
		double[] hoursAsDouble;
		String getHours;
		String[] hoursAsString;
		
		//get valid input
		do {
			System.out.printf("Enter hours for week %d: ", weekNum);
			getHours = input.nextLine();
			hoursAsString = getHours.split(" ");//fix me
		} while (validateInput(hoursAsString) == false);
		
		//convert from string to double and return new array
		hoursAsDouble = convertStringArrayToDouble(hoursAsString);
		return hoursAsDouble;
	}
	
	// * write validateInput method here
	/**
	 * validateInput checks and makes sure that the input has seven values, are all
	 * numeric, and that the values are positive and not above 15.
	 * 
	 * @param input
	 * @return
	 */
	public static boolean validateInput(String[] input) {
		// complete all validation cases for the method
		//declare the variables
		int i;
		int elementCounter = 0;
		
		// enter code to check for seven values
		// loops through all the elements
		for (i = 0; i < input.length; i++) {
			++elementCounter;
		}
		
		//checks if there's seven elements
		if (elementCounter != 7) {
			System.out.println("Input must have seven numbers.");
			return false;
		}
		
		// here is the code to check values are all numeric
		// we will see exceptions soon...
		for (i = 0; i < input.length; i++)
			try {
				Double.valueOf(input[i]);  // this method returns a double value which I am ignoring as I just want to see if it fails
			}
		catch (NumberFormatException e) {  // this is how java tells us a value was not numeric
			System.out.println("Input included invalid numbers. Try again please.");
			return false;
		}

		// enter code to check all positive values
        for (i = 0; i < input.length; i++) {
        	
        	//convert string array to double one
        	double[] convertedInput = convertStringArrayToDouble(input);
        	
        	//check if the values positive and under or equal to 15
        	if (convertedInput[i] < 0) {
        		System.out.println("Worked hours must have values between 0 and 15.");
        		return false;
        	}
        	if (convertedInput[i] > 15) {
        		System.out.println("Worked hours must have values between 0 and 15.");
        		return false;
        	}
        }

		// if we make to the end, then all checks are good, return true
		return true;
	}
	
	// * write convertStringArrayToDouble method here
	/**
	 * convertStringArrayToDouble takes a string array and converts 
	 * it into an array of type double.
	 * 
	 * @param strInput string to convert into doubles
	 * @return new array of doubles
	 */
	public static double[] convertStringArrayToDouble(String[] strInput) {
		int arraySize = 7;
		double[] newDoubleInput = new double[arraySize];
		
		for (int i = 0; i < strInput.length; ++i) {
			newDoubleInput[i] = Double.parseDouble(strInput[i]);//converts from string to double
		}
		//returns the new double array
		return newDoubleInput;
	}
	
	
	// * write calculatePayForWeek method here
	/**
	 * calculatePayForWeek calculates the pay per week depending 
	 * on the hours worked and what weeks the person worked on.
	 * 
	 * @param weekNum the week worked on
	 * @param hrsWorked array of the hours worked for the week
	 */
	public static void calculatePayForWeek(int weekNum, double[] hrsWorked) {
		//get the total hours worked
		double totalHrsWorked = getTotalHours(hrsWorked);
		
		//do the base calculations
		double regularPay;
		double regularBonusPay;
		double overtimeHrs;
		double regularOvertimePay;
		double bonusOvertimePay;
		double bonusRate = HOUR_RATE + BONUS_RATE;
		double regularOvertimeRate = HOUR_RATE * OVERLOAD_PERCENT;
		double bonusOvertimeRate = bonusRate * OVERLOAD_PERCENT;
		double regularTotalPay;
		double bonusTotalPay;
		
		//checks and calculates if you worked less than or equal to REGULAR_HOURS
		if (totalHrsWorked <= REGULAR_HOURS) {
			
			//regular hour pay
			regularPay = totalHrsWorked * HOUR_RATE;
			regularBonusPay = totalHrsWorked * (HOUR_RATE + BONUS_RATE);
			
			//overtime
			overtimeHrs = 0.0;
			regularOvertimePay = 0.0;
			bonusOvertimePay = 0.0;
			
			//totals
			regularTotalPay = regularPay;
			bonusTotalPay = regularBonusPay;
			
			//determines if the week is a bonus week or not
			if ((weekNum <= 2) || ((weekNum >= 44) && (weekNum <= 52))) {
				System.out.printf("Week %d receives a bonus of $2.00 per hour\n", weekNum);
			    System.out.printf("Your total pay for week %d is: $%.2f\n", weekNum, bonusTotalPay);
				System.out.printf("You worked a total of %.2f hours\n", totalHrsWorked);
				System.out.println("Here is your summary:");
				System.out.printf("        Base hours worked: %.2f at $%.2f\n", totalHrsWorked, bonusRate);
				System.out.printf("        Base pay: $%.2f\n", regularBonusPay);
				System.out.printf("        Overtime hours worked: %.2f at $%.2f\n", overtimeHrs, bonusOvertimeRate);
				System.out.printf("        Overtime pay: $%.2f\n", bonusOvertimePay);
				System.out.println("");
			}
			else {
				System.out.printf("Your total pay for week %d is: $%.2f\n", weekNum, regularTotalPay);
				System.out.printf("You worked a total of %.2f hours\n", totalHrsWorked);
				System.out.println("Here is your summary:");
				System.out.printf("        Base hours worked: %.2f at $%.2f\n", totalHrsWorked, HOUR_RATE);
				System.out.printf("        Base pay: $%.2f\n", regularPay);
				System.out.printf("        Overtime hours worked: %.2f at $%.2f\n", overtimeHrs, regularOvertimeRate);
				System.out.printf("        Overtime pay: $%.2f\n", regularOvertimePay);
				System.out.println("");
			}
		}
		//checks and calculates if you worked overtime
		else if (totalHrsWorked > REGULAR_HOURS) {
			
			//overtime
			overtimeHrs = totalHrsWorked - REGULAR_HOURS;
			regularOvertimePay = overtimeHrs * regularOvertimeRate;
			bonusOvertimePay = overtimeHrs * bonusOvertimeRate;
			
			//regular hour pay
			regularPay = REGULAR_HOURS * HOUR_RATE;
			regularBonusPay = REGULAR_HOURS * (HOUR_RATE + BONUS_RATE);
			
			//totals
			regularTotalPay = regularPay + regularOvertimePay;
			bonusTotalPay = regularBonusPay + bonusOvertimePay;
			
			//determine if the week is a bonus week or not
			if ((weekNum <= 2) || ((weekNum >= 44) && (weekNum <= 52))) {
				System.out.printf("Week %d receives a bonus of $2.00 per hour\n", weekNum);
			    System.out.printf("Your total pay for week %d is: $%.2f\n", weekNum, bonusTotalPay);
				System.out.printf("You worked a total of %.2f hours\n", totalHrsWorked);
				System.out.println("Here is your summary:");
				System.out.printf("        Base hours worked: 40 at $%.2f\n", bonusRate);
				System.out.printf("        Base pay: $%.2f\n", regularBonusPay);
				System.out.printf("        Overtime hours worked: %.2f at $%.2f\n", overtimeHrs, bonusOvertimeRate);
				System.out.printf("        Overtime pay: $%.2f\n", bonusOvertimePay);
				System.out.println("");
			}
			else {
				System.out.printf("Your total pay for week %d is: $%.2f\n", weekNum, regularTotalPay);
				System.out.printf("You worked a total of %.2f hours\n", totalHrsWorked);
				System.out.println("Here is your summary:");
				System.out.printf("        Base hours worked: 40 at $%.2f\n", HOUR_RATE);
				System.out.printf("        Base pay: $%.2f\n", regularPay);
				System.out.printf("        Overtime hours worked: %.2f at $%.2f\n", overtimeHrs, regularOvertimeRate);
				System.out.printf("        Overtime pay: $%.2f\n", regularOvertimePay);
				System.out.println("");
			}
		}
	}
	
	// * write getTotalHours method here
	/**
	 * getTotalHours takes the values from the double array and adds them up.
	 * 
	 * @param listOfHrs double array of the hours spent working
	 * @return integer value of the total hours spent working
	 */
    public static double getTotalHours(double[] listOfHrs) {
    	double totalHrs = 0;
    	int i;
    	
    	for (i = 0; i < listOfHrs.length; ++i) {
    		totalHrs = totalHrs + listOfHrs[i];
    	}
    	//returns the total
    	return totalHrs;
    }
}
