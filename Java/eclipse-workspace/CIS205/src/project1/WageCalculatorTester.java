package project1;

import java.util.Arrays;
import java.util.Scanner;

public class WageCalculatorTester {

	public static void main(String[] args) {

		int input;
		Scanner scnr = new Scanner(System.in);
		System.out.println("Select a number from the menu");

		do {
			System.out.println("1. Test validate method");
			System.out.println("2. Test convert method");
			System.out.println("3. Test calculate total hours method");
			System.out.println("4. Test calculate pay method");
			System.out.println("5. Test user input method");
			System.out.print("Enter your choice: ");
			input = scnr.nextInt();
			scnr.nextLine();

			switch (input) {
			case 1:
				testValidate();
				break;
			case 2:
				testConvert();
				break;
			case 3:
				testTotalHours();
				break;
			case 4:
				testCalculatePay();
				break;
			case 5:
				testInputFromUser(scnr);
				break;

			}
			System.out.println("=========");
		} while (input != -1);
	}

	private static void testInputFromUser(Scanner scnr) {

		double[] doubleArray;

		doubleArray = HourlyWageCalculator.getInputFromUser(scnr, 15);
		System.out.println(Arrays.toString(doubleArray));
	}

	private static void testValidate() {
		// test inputArray errors
		System.out.println("\n***Test Validate Input Method***");
		String[] badArray1 = { "10", "10", "8", "a", "0", "9", "10" };
		System.out.print("Validate with non-numbers\n\t");
		HourlyWageCalculator.validateInput(badArray1);
		String[] badArray2 = { "10", "10", "8", "0", "9", "10" };
		System.out.print("Validate with less than 7 numbers\n\t");
		HourlyWageCalculator.validateInput(badArray2);
		String[] badArray3 = { "10", "10", "8", "0", "9", "10", "10", "8" };
		System.out.print("Validate with more than 7 numbers\n\t");
		HourlyWageCalculator.validateInput(badArray3);
		String[] badArray4 = { "10", "10", "-8", "0", "9", "10", "10" };
		System.out.print("Validate with negative hours\n\t");
		HourlyWageCalculator.validateInput(badArray4);
		String[] badArray5 = { "16", "10", "-8", "0", "9", "10", "10" };
		System.out.print("Validate with hours over 15\n\t");
		HourlyWageCalculator.validateInput(badArray5);
	}

	private static void testConvert() {
		double[] doubleArray;
		String[] stringArray = { "10.5", "10", "8", "12.5", "0", "9.75", "10.75" };
		System.out.println("\n***Test Convert Method***");
		System.out.print("Convert the string array to double array\n\t");
		doubleArray = HourlyWageCalculator.convertStringArrayToDouble(stringArray);
		System.out.println("Multiplying *2 to verify values are numeric");

		try {
			for (double num : doubleArray)
				System.out.printf("\t\t%.2f * 2 = %.2f\n", num, num * 2);
		} catch (NumberFormatException e) {
			System.out.println("Non numeric value found");
		}

	}

	private static void testTotalHours() {
		double[] doubleArray = { 10.5, 10, 8, 12.5, 0, 9.75, 10.75 };
		double sum;

		System.out.println("\n***Test Sum Method***");

		System.out.println("Sum should total 61.50");
		sum = HourlyWageCalculator.getTotalHours(doubleArray);
		System.out.printf("\tMethod returned %.2f\n", sum);

	}

	private static void testCalculatePay() {
		double[] doubleArray = { 10,1,2,3,4,5,6 };
		double sum;
		
		System.out.println("\n***Test Calculate Pay Method***");

		System.out.print("*Pay of $1083.75 does not include bonus*");
		HourlyWageCalculator.calculatePayForWeek(23, doubleArray);
		System.out.print("\n*Pay of $1228.25 includes bonus*\n");
		HourlyWageCalculator.calculatePayForWeek(52, doubleArray);

	}

}
