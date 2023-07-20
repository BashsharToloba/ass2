
import com.sun.tools.javac.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.*;

import java.util.Arrays;
import java.util.Scanner;

//import javax.swing.*;

//import java.awt.*;

import static javafx.application.Application.launch;

/**
 * Use this template to create drawings in FX. Change the name of the class and
 * put your own name as author below. Change the size of the canvas and the
 * window title where marked and add your drawing code where marked.
 *
 * @author YOUR NAME
 */
public class TicketScanningApp extends Application {

    public String[][] getTable (String filename) throws FileNotFoundException {
        //Pass1:  Go through the text file in order to ascertain the
        //        numRows and numCols
        int numRows = 0;
        int numCols = 0;
        String s;
        int r;
        String[] item;

        Scanner theFile = new Scanner(new FileInputStream(new File(filename)));
        while ( theFile.hasNextLine() )
        {
            s = theFile.nextLine();
            item = s.split("\t", 0);


            if (item.length > numCols)
                numCols = item.length;

            numRows++;

        }
        theFile.close();

        String [][] grid = new String[numRows][numCols];

        //Pass2:  populate the grid array
        theFile = new Scanner(new FileInputStream(new File (filename)));
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

        System.out.println(Arrays.deepToString(grid));
        return grid;
    }

    public String[] getCell(String[][] table, String code) {
        String[] cell = new String[4];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++){
                if (code.equals(table[i][0])) {
                    cell[0] = table[i][0];
                    cell[1] = table[i][1];
                    cell[2] = table[i][2];
                    cell[3] = table[i][3];
                }
            }
        }
        return cell;
    }

    public String ticketStatus(String[][] table, String code) {
        String[] cell = getCell(table, code);
        System.out.println(Arrays.deepToString(cell));
        String res = "";
        if (cell[0] == null){
            res = code + " is INVALID";
        } else {
            if ((cell[1].equals("N")) && (cell[2].equals("N"))) {
                res = cell[0] + " not purchased yet";
                return res;
            }
            if ((cell[1].equals("Y")) && (cell[2].equals("N"))) {
                res = cell[0] + " - VALID \n " + cell[3];
                return res;
            }
            if ((cell[1].equals("Y")) && (cell[2].equals("Y"))) {
                res = cell[0] + " is a duplicate";
                return res;
            }
        }
        return res;
    }


    /**
     * Start method (use this instead of main).
     *
     * @param stage The FX stage to draw on
     * @throws Exception
     */

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(400, 300); // Set canvas Size in Pixels
        stage.setTitle("FXGraphicsTemplate"); // Set window title
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // YOUR CODE STARTS HERE
        //read file
        String tablename = "codes.txt";

        TextField field1 = new TextField();
        Button Redeem = new Button("Redeem");
        String[][] t = getTable(tablename);

        root.getChildren().addAll(field1, Redeem);
        Redeem.relocate(300,60);
        field1.relocate(100,60);

        gc.setFont(Font.font("Times New Roman",20));
        gc.fillText("Ticket Scanning App", 100, 20, 800);

        Redeem.setOnAction(
                event -> {
                    String desc = ticketStatus(t, field1.getText());
                    System.out.println(desc);
                }
        );

        // YOUR CODE STOPS HERE
        stage.show();
    }

    /**
     * The actual main method that launches the app.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}