import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 * @author Afroja Nasrin Mim
 */
public class LandingGear {
    private double gSize;
    private double xCoordinate;
    private double yCoordinate;
    /**
     *  LandingGear constructor
     *
     * @param gSize the size of the landing gear
     * @param x the x-coordinate of the landing gear
     * @param y the y-coordinate of the landing gear
     */
    public LandingGear(double gSize, double x, double y) {
        this.gSize = gSize;
        this.xCoordinate = x;
        this.yCoordinate = y;
    }
    /**
     * Draws the landing gear
     *
     * @param gc The GraphicsContext used for drawing
     */
    public void draw(GraphicsContext gc) {
        gc.setStroke(Color.BLACK);
        gc.strokeLine(xCoordinate, yCoordinate, xCoordinate - gSize, yCoordinate + gSize/2);  // Left leg
        gc.strokeLine(xCoordinate, yCoordinate, xCoordinate + gSize, yCoordinate + gSize/2);  // Right leg
    }


}
