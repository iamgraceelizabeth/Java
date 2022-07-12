import java.util.Scanner; 

public class YesInt {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String userString;
      String tracker = "Yes";

      userString = scnr.next();
      
      for (int i = 0; i < userString.length(); i++) {
         char character = userString.charAt(i);
         if ((character != ',') && (character != '.') && (Character.isDigit(character) == true)) {
            tracker = "Yes";
         }
         else {
            tracker = "No";
            break;
         }
      }
      System.out.println(tracker);
      
      scnr.close();
   }
}


