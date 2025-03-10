import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Random;

/**
 * @author Afroja Nasrin Mim
 */

public class AlienArmada extends Application {
    /**
     * Start method (use this instead of main).
     *
     * @param stage The FX stage to draw on
     * @throws Exception
     */
    @Override
    public void start(Stage stage)throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root,Color.LIGHTCYAN);
        Canvas canvas = new Canvas(1024, 600); // Set canvas Size in Pixels
        stage.setTitle("FXGraphicsTemplate"); // Set window title
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Random rand = new Random();
        //list of names for Alien's Ship
        String[] origins = {
                "Proxima Centauri", "Barnard's Star", "Epsilon Eridani", "Aquarius", "Acrux",
                "Teegarden's Star", " Scorpio", "Gliese", "Venus", " Arietis",
                "Absolutno", "Mars", "Pluto", "Moon"
        };

        // Create three squadrons with random colors and positions
        Squadron squadron1 = new Squadron(rand.nextInt(60, 350) , rand.nextInt(40, 120), origins[rand.nextInt(14)], getRandomColor());
        Squadron squadron2 = new Squadron(rand.nextInt(620, 780), rand.nextInt(40, 90), origins[rand.nextInt(14)], getRandomColor());
        Squadron squadron3 = new Squadron(rand.nextInt(100, 600), rand.nextInt(350, 390), origins[rand.nextInt(14)], getRandomColor());


        // Display total number of arriving aliens
        gc. setFill(Color. DARKRED);
        gc.setFont(new Font( "Ink Free",16));
        gc.fillText("Total # of Aliens arriving: " + (squadron1.getTotalTroops()+squadron2.getTotalTroops()+squadron3.getTotalTroops()),
                5, 14);

        gc.setFont(new Font("Ink Free",13));

        // Draw the squadrons
        squadron1.draw(gc);
        squadron2.draw(gc);
        squadron3.draw(gc);


        // Show the stage
        stage.show();
    }
    /**
     * Generates a random color
     *
     * @return A randomly selected Color object
     */
    private Color getRandomColor() {
        Random rand = new Random();

        Color[] colorList = {

                Color.INDIGO,Color.DARKOLIVEGREEN,Color.CRIMSON,Color.ROYALBLUE,Color.BLUEVIOLET,Color.DARKMAGENTA,Color.BROWN,Color.CORNFLOWERBLUE,
                Color.DARKRED,Color.DARKSLATEBLUE,Color.FIREBRICK,Color.FORESTGREEN,Color.DARKORANGE,Color.MEDIUMVIOLETRED,Color.MAROON,
                Color.SEAGREEN,Color.TOMATO,Color.DARKBLUE,Color.DARKGREEN,Color.PURPLE,Color.DARKORCHID
        };

        return colorList[rand.nextInt(colorList.length)];
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
