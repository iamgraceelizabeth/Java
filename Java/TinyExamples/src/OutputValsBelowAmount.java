import java.util.Scanner; 

public class OutputValsBelowAmount {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int[] userValues = new int[20];   // List of integers from input
      
      int i;
      int j;

      //populates list
      for (i = 0; i < userValues.length; ++i) {
         userValues[i] = scnr.nextInt();
         System.out.println(userValues[i]);
      }
      
      int lastThreshold = userValues[(0 + i) - 1];//gets lastThreshold
      int firstThreshold = userValues[0];
      
      //determines if nums < or > lastThreshold
      for (j = 1; j < userValues.length ; ++j) {
         if (userValues[j] < lastThreshold) {
           System.out.print("" + userValues[i] + ","); 
         }
      }
      
   }
}
