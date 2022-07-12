import java.util.Scanner;

public class MultiplicationTable {                         
   public static void main (String [ ] args) { 
        Scanner scnr = new Scanner(System.in);
        int i;
        int j;
        int rows;

        rows = 4;

        for (i = 1; i <= rows; ++i) {
            System.out.print("" + i + " ");
            for (j = 1; j <= 10; ++j) {
                System.out.print("" + j + " ");
            }
            System.out.println("");
        }

   }
}