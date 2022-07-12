import java.util.Scanner;
import java.util.Arrays;

public class DescendingOrder {
   // TODO: Write a void method selectionSortDescendTrace() that takes 
   //       an integer array and the number of elements in the array as arguments, 
   //       and sorts the array into descending order.
   public static void selectionSortDescendTrace(int[] numbers, int numElements) {
      int i;
      int j;
      int smallestIndex = 0;
      int temp;
      
      for (i = 0; i < numElements; ++i) {
         smallestIndex = i;
         for (j = i + 1; j < numElements; ++i) {
            if (numbers[j] > numbers[smallestIndex]) {
               smallestIndex = j;
            }
         }
      }
      
      temp = numbers[i];
      numbers[i] = numbers[smallestIndex];
      numbers[smallestIndex] = temp;
      
      System.out.println(Arrays.toString(numbers));
   }
   
   
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      int i = 0;
      int numElements = 0;
      int[] numbers = new int[10];

      // TODO: Read in a list of up to 10 positive integers; stop when
      //       -1 is read. Then call selectionSortDescendTrace() method.
      for (i = 0; i < numbers.length - 1; ++i) {
         int input = scnr.nextInt();
         if (input != -1) {
            numbers[i] = input;
            ++numElements;
         }
         else if (input == -1) {
            break;
         }
      }
      
      selectionSortDescendTrace(numbers, numElements);
   }
}