import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 * @author Afroja Nasrin Mim
 */

public class Window {
    private double wSize;
    private double xCoordinate;
    private double yCoordinate;

    /**
     * Window constructor
     * @param x The x-coordinate of the window
     * @param y The y-coordinate of the window
     * @param wSize The size of the window
     */
    public Window(double x, double y, double wSize) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.wSize = wSize;
    }
    /**
     * Draws the window
     *
     * @param gc The GraphicsContext used for drawing
     */
    public void draw(GraphicsContext gc) {
        gc.setStroke(Color.BLACK); // Outline color
        gc.setLineWidth(2); // Outline thickness
        gc.strokeOval(xCoordinate,yCoordinate , wSize, wSize); // Draw the outline

    }
}
