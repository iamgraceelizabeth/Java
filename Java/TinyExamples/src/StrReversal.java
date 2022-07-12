import java.util.Scanner;

public class StrReversal {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String userInput;
      char newString = 'a';
      int i;
      
      
      do {
         userInput = scnr.nextLine();
         i = 0;
         
         if ((userInput.toLowerCase().contains("done")) || (userInput.contains("d"))) {
            break;
         }
         while (i < userInput.length()) {
           System.out.print(userInput.charAt(userInput.length() - i - 1));
           i++; 
         }
         System.out.println("");
      } while ((!userInput.toLowerCase().contains("done")) || (!userInput.contains("d")));
   }
}
