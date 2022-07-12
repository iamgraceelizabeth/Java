import java.util.Scanner; 

public class LabProgram {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int userInput = scnr.nextInt();
      int binaryOutput;
      
      while (userInput > 0) {
         binaryOutput = userInput % 2;
         System.out.print(binaryOutput);
         userInput = userInput / 2;
      }
      System.out.println("");
   }
}
