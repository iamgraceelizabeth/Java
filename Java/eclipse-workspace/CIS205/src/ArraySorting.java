import java.util.Arrays;
import java.util.Scanner;

/**
 * Program uses an array and provides multiple ways to sort the contents.
 * @author Grace Merry
 */
public class ArraySorting {

	/**
	 * swaps two elements in a list
	 * @param array array that the elements inside are swapped in
	 * @param index1 1st index to swap
	 * @param index2 2nd index to swap
	 */
	public static void swapTwo(int[] array, int index1, int index2) { 
		int temp; 
		 
		System.out.printf(" ---Swap elements at index %d and %d%n",index1,index2); 
		temp = array[index1]; 
		array[index1] = array[index2]; 
		array[index2] = temp; 
		 
	}
	
	/**
	 * sorts an array using a selection sort
	 * @param numbers array that is sorted
	 */
	public static void selectionSort(int[] numbers) {
		int i;
		int j;
		int indexSmallest;
  
		for (i = 0; i < numbers.length - 1; ++i) {
  
		   // Find index of smallest remaining element
		   indexSmallest = i;
		   for (j = i + 1; j < numbers.length; ++j) {
  
			  if (numbers[j] < numbers[indexSmallest]) {
				 indexSmallest = j;
			  }
		   }
		   //displays where the next smallest value is found
		   System.out.printf("--Found next smallest value: %s at index %d.\n", numbers[indexSmallest], indexSmallest);

		   // Swap numbers[i] and numbers[indexSmallest]
		   swapTwo(numbers, i, indexSmallest);

		   //display current state of array during sort
		   System.out.printf("- Array after loop where i= %s: %s\n", i, Arrays.toString(numbers));
		}
	}

	/**
	 * sorts an array using a insertion sort
	 * @param numbers array that is sorted
	 */
	public static void insertionSort(int [] numbers) {
		int i;
		int j;
  
		for (i = 1; i < numbers.length; ++i) {
		   j = i;
		   
		   // display what number is being inserted
		   System.out.printf("--Insert %s into sorted numbers before %s\n", numbers[i], numbers[i]);

		   // Insert numbers[i] into sorted part 
		   // stopping once numbers[i] in correct position
		   while (j > 0 && numbers[j] < numbers[j - 1]) {
			  // Swap numbers[j] and numbers[j - 1] 
			  swapTwo(numbers, j, j - 1);
			  --j;
		   }
		   // display current state of array during sort
		   System.out.printf("- Array after loop where i= %s: %s\n", i, Arrays.toString(numbers));
		}
	}
     
	/**
	 * sorts an array using a bubble sort
	 * @param numbers array that is sorted
	*/
	public static void bubbleSort(int [] numbers) {

		//keeps track of the passes
		for (int i = 0; i < numbers.length - 1; i++) {
			//Display the staring index and where it bubbles up to
			System.out.printf("- Starting at index %d, bubbling up highest numbers until index %s\n", i + 1, numbers.length - 1);
			
			//loops through the indexes swapping elements 
			for (int j = 0; j < numbers.length - i - 1; j++) {

				//determines if the next index is less than the current index. 
				if (numbers[j] > numbers[j+1]) {
					//swap numbers[j] and numbers[j + 1]
					swapTwo(numbers, j, j + 1);
				}
			}
			//display current state of the array during sort
			System.out.printf("--Array after loop where i= %s: %s\n", i + 1, Arrays.toString(numbers));
		}
	}
    
	/**
	 * sorts an array with a bubble sort, but improves it by reducing unnecessary loops
	 * @param numbers array that is sorted
	 */
    public static void improvedBubbleSort(int[] numbers) {
		boolean sorted = false;
        int k;
		int j;

		for (k = 0; k < numbers.length-1 && !sorted; ++k) {  
			sorted = true;  // Assume sorted
            
			//Display the staring index and where it bubbles up to
			System.out.printf("- Starting at index %d, bubbling up highest numbers until index %s\n", k + 1, numbers.length - 1);

			for (j = 0; j < numbers.length - k -1; j++) {  
				if (numbers[j] > numbers[j + 1]) {
					// Swap data
					swapTwo(numbers, j, j + 1);
					sorted = false;  // Swap occurred; still not sorted
				}  
			} 
			//display current state of the array during sort
			System.out.printf("--Array after loop where k= %s: %s\n", k + 1, Arrays.toString(numbers));
		}
		//display how many less loops the improved bubble sort did
		System.out.printf("Improved bubble sort executed %s less loops", numbers.length - k - 1);
		System.out.println("");
	} 
  
	public static void main(String[] args) {
		// Test the sorting algorithms on an array of 10 integers
		// The Arrays class provides a toString method that displays the elements of an array
		//     inside brackets, separated by a comma
		// The Arrays.toString() method displays a simple string of the array in one line
		// This works well with our array of ten integers
        
		Scanner input = new Scanner(System.in);
		
		int[] numbers1 = {11,2,34,14,95,26,7,18,9,16};
		System.out.printf("\n*  Array* before selection sort: %s\n", Arrays.toString(numbers1));
		selectionSort(numbers1);
		System.out.printf("\n*  Array* after selection sort: %s\n", Arrays.toString(numbers1));
		System.out.println("Press <enter> key to continue");
		input.nextLine();
	    
		int[] numbers2 = {11,2,34,14,95,26,7,18,9,16};
		System.out.printf("\n*  Array* before insertion sort: %s\n", Arrays.toString(numbers2));
		insertionSort(numbers2);
		System.out.printf("\n*  Array* after insertion sort: %s\n", Arrays.toString(numbers2));
		System.out.println("Press <enter> key to continue");
		input.nextLine();
		
		int[] numbers3 = {11,2,34,14,95,26,7,18,9,16};
		System.out.printf("\n*  Array* before bubble sort: %s\n", Arrays.toString(numbers3));
		bubbleSort(numbers3);
		System.out.printf("\n*  Array* after bubble sort: %s\n", Arrays.toString(numbers3));
		System.out.println("Press <enter> key to continue");
		input.nextLine();
		
		int[] numbers4 = {11,2,34,14,95,26,7,18,9,16};
		System.out.printf("\n*  Array* before improved bubble sort: %s\n", Arrays.toString(numbers4));
		improvedBubbleSort(numbers4);
		System.out.printf("\n*  Array* after improved bubble sort: %s\n", Arrays.toString(numbers4));
		System.out.println("Press <enter> key to continue");
		input.nextLine();
	}
}