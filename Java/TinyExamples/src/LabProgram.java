import java.util.Scanner;

public class LabProgram {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int i;
      int j;
      String userInput;
      String reverse = "";
      String userNoSpace = "";
      int length;
      
      userInput = scnr.nextLine();
      
      length = userInput.length();
      
      for (i = length - 1; i >= 0; i--) {
         if (userInput.charAt(i) != ' ') {
            reverse = reverse + userInput.charAt(i);
         }
      }
      
      for (j = 0; j < length; ++j) {
         if (userInput.charAt(j) != ' ') {
            userNoSpace = userNoSpace + userInput.charAt(j);
         }
      }
      
      if (userNoSpace.equals(reverse)) {
         System.out.println("palindrome: " + userInput);
      }
      else {
         System.out.println("not a palindrome: " + userInput);
      }
   }
}
