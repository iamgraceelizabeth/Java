import java.util.Scanner;
public class NestedLoops {
   public static void main (String [] args) {
      Scanner scnr = new Scanner(System.in);
      int numRows;
      int numColumns;
      int currentRow;
      int currentColumn;
      char currentColumnLetter;

      numRows = scnr.nextInt();
      numColumns = scnr.nextInt();
      currentColumnLetter = 'A';
      
      for (currentRow = 1; currentRow <= numRows; ++currentRow) {
         for (currentColumn = 1; currentColumn <= numColumns; ++currentColumn) {
            System.out.print("" + currentRow);
            System.out.print("" + currentColumnLetter + " ");
            ++currentColumnLetter;
         }
         currentColumnLetter = 'A';
      }

      System.out.println("");
   }
}