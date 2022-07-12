import java.util.Scanner; 

public class DrawHalfArrow {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int arrowBaseHeight;
      int arrowBaseWidth;
      int arrowHeadWidth;
      int k;
      int i;
      int j;
      
      System.out.println("Enter arrow base height:");
      arrowBaseHeight = scnr.nextInt();
      
      System.out.println("Enter arrow base width:");
      arrowBaseWidth = scnr.nextInt();
      
      do {
         System.out.println("Enter arrow head width:");
         arrowHeadWidth = scnr.nextInt();
      } while (arrowHeadWidth <= arrowBaseWidth);
      
      System.out.println("");
      
      // Draw arrow base (height = 3, width = 2)
      for (i = 0; i < arrowBaseHeight; ++i) {
         for (j = 0; j < arrowBaseWidth; ++j) {
            System.out.print("*");
         }
         System.out.println("");
      }
      
      k = arrowHeadWidth;
      // Draw arrow head (width = 4)
      for (j = 0; j < arrowHeadWidth; ++j) {
         for (i = k; i > 0; i--) {
            System.out.print("*");
         }
         k = k - 1;
         System.out.println("");
      }
   }
}