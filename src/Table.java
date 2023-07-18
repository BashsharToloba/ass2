import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This class manages anu tab delimited text file, e.g.  codes.txt
 *
 * @author Dave Slemon
 * @version v100
 */
public class Table
{ //class
    
    //instance variables
    private String tablename;
    private int numRows;
    private int numCols;
    private String[][] grid;

    
    
/** 
 *
 * Initialize the class with the name of the tab delimited text file you wish to manage.
 *
 * @param filename  the name of tab delimited text file.
 */
    public Table( String filename ) 
    { //table
        tablename = filename;
        numRows=0;
        numCols=0;
        String s;
        int r;
        String[] item;
        
        
        
        //Pass1:  Go through the text file in order to ascertain the
        //        numRows and numCols
        try {

            Scanner theFile = new Scanner(new FileInputStream(new File (tablename)));
            while ( theFile.hasNextLine() )
            {
                s = theFile.nextLine();
                item = s.split("\t", 0);
                
                
                if (item.length > numCols)
                   numCols = item.length;     

                numRows++;
      
            }
            theFile.close();
        }
        catch (FileNotFoundException  e)
        {
            System.out.println("Table class Error 1: file not found.");
        }
            
        
        
        grid = new String[numRows][numCols];
        
                
        //Pass2:  populate the grid array
        try {
            
            Scanner theFile = new Scanner(new FileInputStream(new File (tablename)));
            r=0;
            while ( theFile.hasNextLine() )
            {
                s = theFile.nextLine();
                item = s.split("\t", 0);
                
                for(int c=0; c < numCols; c++) {
                    
                   
                    
                    if ( item[c].length() == 0)
                        grid[r][c] = "";
                    else
                        grid[r][c] = item[c];
             
                       
                }
                r++;
                
  
            }
            theFile.close();
        }
        catch (Exception e)
        {
            System.out.println("Table class error 2: file not found.");
        }
               
        
   
 
   
    } //table
    

    
        
  
    
     public String toString() {
        
            return ("Table: " + tablename + "  rows = " + numRows + "  cols = " + numCols);
     }
        
  } //class
    
    
    