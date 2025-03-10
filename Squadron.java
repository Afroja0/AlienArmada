import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.Random;
/**
 * @author Afroja Nasrin Mim
 */
public class Squadron {
    private double xCoordinate;
    private double yCoordinate;
    private String homePlanetName;
    private Ship[] troops;
    private Ship commander;

    /**
     *  Squadron Constructor with a commander and 3 troop ships.
     *
     * @param x the x-coordinate of the squadron
     * @param y the y-coordinate of the squadron
     * @param homeName the home planet name of the squadron
     * @param color  the color of the ships in the squadron
     */

    public Squadron(double x, double y, String homeName, Color color) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.homePlanetName = homeName;
        this.commander = new Ship(x, y, color, true);

        // Create 4 troops: 1 commander and 3 troop troops
        troops = new Ship[3];
        //Saving  position along  X axis for drawing next troop
        double lastX = x;
        Random rand = new Random();
        lastX -= rand.nextInt(10, 50);
        //  Troop ships at varying positions
        for (int i = 0; i < troops.length; i++) {
            troops[i] = new Ship(lastX, y+ rand.nextInt(100,150), color);// Position troops randomly
            lastX += rand.nextInt(50, 80);
        }
    }


    /**
     * Retrieves the total number of troops
     *
     * @return The total number of troops
     */

    int getTotalTroops() {
        return this.commander.getNumberTroops();
    }
    /**
     * Draws the squadron
     * @param gc The GraphicsContext used for drawing
     */
    public void draw(GraphicsContext gc) {
        // Draw all troops in the squadron
        for (Ship ship : troops) {
            ship.draw(gc);
        }
        commander.draw(gc);

        // Draw the home planet name and total troops above the commander ship
        gc.fillText(this.getTotalTroops()+ " Alien ships from " + this.homePlanetName , xCoordinate, yCoordinate- 10);


    }
}
