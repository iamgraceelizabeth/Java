import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/** 
 * This program takes data about the population of some 
 * Kansas towns from a file and adds them up.
 * @author Grace Merry
*/
public class KansasTowns {

    /**
     * Reads the file passed to it, adds up the total population 
     * of all the towns in the file, and then displays it.
     * 
     * @param fileName Takes the name of a file as a string
     */
    public static void readTownsFile(String fileName) {
        try {
        	//opens file
            FileInputStream inputFile = new FileInputStream(fileName);
            Scanner inFS = new Scanner(inputFile);
            
            //initialize the variables for keeping track of the population & town names
            int totalPopulation = 0;
            String townNames = "";
            
            //read the file
            while (inFS.hasNext()) {
            	townNames = townNames + inFS.next() + " ";
                totalPopulation += inFS.nextInt();
            }
            
            //print the total population of the towns
            System.out.printf("The total population of %sis %d.", townNames, totalPopulation);
            
            //close scanner
            inFS.close();
        }
        //catches and displays error message if the file isn't found
        catch (FileNotFoundException e) {
           System.out.printf("%s does not exist.", fileName);
        }
    }

    public static void main(String[] args) { 
        // Call method to read towns and display output 
        readTownsFile("KansasTownsPop1.txt"); 
           
    } 
}