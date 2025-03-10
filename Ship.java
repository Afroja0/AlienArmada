import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;
/**
 * @author Afroja Nasrin Mim
 */
public class Ship {
    private int numberTroops;
    private double xCoordinate;
    private double yCoordinate;
    private Color shipColor;
    private boolean isCommander;
    private Window[] windows;
    private LandingGear landingGear;

    /**
     * Ship constructor - with specified position and color.
     *
     * @param x         The x-coordinate of the ship
     * @param y         The y-coordinate of the ship
     * @param shipColor The color of the ship
     */
    public Ship(double x, double y, Color shipColor) {
        this(x,y, shipColor, false);
        double windowSize = 4; // Ship window size
        // Create 2 windows for ship
        windows = new Window[2];
        windows[0] = new Window(x + 5, y + 6, windowSize); // Window 1
        windows[1] = new Window(x + 24, y + 6, windowSize); // Window 2

        // Create landing gear for ship
        landingGear = new LandingGear(10, x + 130/8.0, y + 60/4);

    }

    /**
     * Ship constructor - a commander ship with commander status, position, and color.
     *
     * @param x   the x-coordinate of the ship
     * @param y   the y-coordinate of the ship
     * @param shipColor  the color of the ship
     * @param isCommander whether the ship is a commander ship
     */
    public Ship(double x, double y, Color shipColor, boolean isCommander) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.shipColor = shipColor;
        this.isCommander = isCommander;
        //Generate random number of troops in the ship
        this.numberTroops = new Random().nextInt(3, 50);


        // Determine ship height and window size based on commander status
        double windowSize = isCommander ? 20 : 4;

        // Create 2 windows for commander ship
        windows = new Window[2];
        windows[0] = new Window(x + 10, y + 20, windowSize); // Window 1
        windows[1] = new Window(x + 100, y + 20, windowSize); // Window 2


        // Create landing gear for commander ship
        landingGear = new LandingGear(30, x + 130/2.0, y + 60);
    }

    /**
     * Retrieves the number of troops assigned to this ship.
     *
     * @return The number of troops
     */

    public int getNumberTroops() {
        return this.numberTroops;
    }
    /**
     * Draws the ship
     *
     * @param gc The GraphicsContext used for drawing
     */
    public void draw(GraphicsContext gc) {
        // Draw the ship body
        gc.setFill(shipColor);
        double shipHeight = isCommander ? 60 : 60/4.0; // Commander ship is 4 times larger,ship height
        double shipWidth = isCommander ? 130 : 130/4.0; // Commander ship is 4 times larger,ship width
        double plasmaGunRadius = isCommander ? 40 : 10;//circular shapes on the ship
        double arcSize = 100;//Determines the roundness of the ship's edge
        // Draw the ship body with rounded corners
        if (this.isCommander){
            gc.fillRoundRect(xCoordinate, yCoordinate, shipWidth, shipHeight, arcSize, arcSize);
        }
        else{
            gc.fillRoundRect(xCoordinate, yCoordinate, shipWidth, shipHeight, arcSize/4.0, arcSize/4.0);
        }
        // Draw the plasma guns (circular shapes) of the commander ship
        if (this.isCommander){
            gc.fillOval(xCoordinate-20, yCoordinate+10, plasmaGunRadius, plasmaGunRadius);
            gc.fillOval(xCoordinate+90+20, yCoordinate+10, plasmaGunRadius, plasmaGunRadius);
        }

        // Draw the plasma guns (circular shapes) of the  ship
        else{
            gc.fillOval(xCoordinate-4, yCoordinate+2, plasmaGunRadius, plasmaGunRadius);
            gc.fillOval(xCoordinate+22.5+4, yCoordinate+2, plasmaGunRadius, plasmaGunRadius);
        }

        // Draw the windows
        for (Window window : windows) {
            window.draw(gc);
        }

        // Draw the landing gear
        landingGear.draw(gc);
    }
}

