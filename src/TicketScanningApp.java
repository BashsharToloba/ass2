
import com.sun.tools.javac.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.*;

import java.awt.*;

import static javafx.application.Application.launch;

/**
 * Use this template to create drawings in FX. Change the name of the class and
 * put your own name as author below. Change the size of the canvas and the
 * window title where marked and add your drawing code where marked.
 *
 * @author YOUR NAME
 */
public class TicketScanningApp extends Application {



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
        TextField field1 = new TextField();
        Button Redeem = new Button("Redeem");


        root.getChildren().addAll(field1, Redeem);


        Redeem.relocate(100,60);
        field1.relocate(100,30);

        gc.setFont(Font.font("Times New Roman",20));
        gc.fillText("Ticket Scanning App", 100, 20, 800);

        Redeem.setOnAction(this::Clickevent);




        // YOUR CODE STOPS HERE
        stage.show();
    }

    private void Clickevent(ActionEvent actionEvent) {

            System.out.println("redeem button event working");
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