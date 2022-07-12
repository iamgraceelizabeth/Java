import java.util.Scanner; 

public class HelloWorld {

	public static void main(String[] args) {
	      Scanner scnr = new Scanner(System.in);
	      String tracker = "Yes";

	      char userString = scnr.next().charAt(0);
	      
	      boolean digitCheck = Character.isDigit(userString);
	      
	      if (digitCheck) {
	         tracker = "Yes";
	         
	         while (tracker == "Yes") {
	            char nextChar = scnr.next().charAt(0);
	            boolean digitCheck2 = Character.isDigit(nextChar);
	            
	            if (digitCheck2) {
	               tracker = "Yes";
	            }
	            else {
	               tracker = "No";
	               System.out.println(tracker);
	            }
	         }
	         
	         System.out.println(tracker);
	      } 
	      else {
	         tracker = "No";
	         System.out.println(tracker);
	      }
	      
    scnr.close();
	}

}
