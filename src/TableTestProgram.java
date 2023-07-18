import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Scanner;


/**
 * Write a description of class Preferences here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TableTestProgram {

        public static void main () throws Exception
        {

            Scanner in = new Scanner(System.in);
            String tablename = "";
            String choice = "";
            int row = -1;
            int colNum = 1;
            String key = "";
            String s_colNum = "";
            String newValue = "";

            System.out.print("Enter the name of the tab delimited text file you wish to manage (e.g. codes.txt) > ");
            tablename = in.nextLine();
            Table t = new Table(tablename);
            System.out.println("Successfully loaded: " + t);


            while (1 == 1) {
                System.out.println("\n\nTable Testing Menu\n");

                System.out.println("1. Display all data");
                System.out.println("2. Lookup");
                System.out.println("3. Search");
                System.out.println("4. Change");
                System.out.println("5. Save data to " + tablename);
                System.out.println("6. Get Single Cell Value");
                System.out.println("7. Save Single Cell Value");
                System.out.println("9. Quit");
                System.out.print("Select > ");
                choice = in.nextLine();

                if (choice.equals("9")) break;


            }
            System.out.println("Thank-you, good bye!");

        }
    }


       

