import java.awt.Color;
/**
* This class contains all the colors used by the map and map cells.
* <p>
* @author CS1027
*/
public class CellColors {
	// Color definitions
	public static final Color NO_FLYING = Color.BLACK;
	public static final Color INITIAL = new Color(250, 250, 0);
	public static final Color CUSTOMER = Color.BLUE;
	public static final Color UNVISITED = new Color(100, 255, 100);
	public static final Color IN_STACK = Color.CYAN;
	public static final Color CUSTOMER_PROCESSED = new Color(0, 190, 190);
	public static final Color INITIAL_PROCESSED = new Color(200, 255, 255);
	public static final Color INITIAL_POPPED = new Color(50, 255, 255);
	public static final Color OUT_STACK = Color.LIGHT_GRAY;
	public static final Color TOWER = Color.YELLOW;
	public static final Color THIEF = Color.RED;
	public static final Color HIGH_ALTITUDE = Color.PINK;
	public static final Color THIEF_PUSHED = Color.RED.darker();
	public static final Color HIGH_ALTITUDE_PUSHED = Color.PINK.darker();
	public static final Color THIEF_POPPED = Color.RED.brighter();
	public static final Color HIGH_ALTITUDE_POPPED = Color.PINK.brighter();

	/**
	* Selects the final color in a gradient texture.
	*
	* @param c The cell name of the color
	* @return The color for the gradient
	*/
	public Color gradientColor(Color c) {
		if (c == NO_FLYING)
			return Color.DARK_GRAY.brighter();
		else if (c == IN_STACK)
			return c.darker().darker();
		else if (c == CUSTOMER_PROCESSED)
			return new Color(0, 0, 180);
		else if (c == INITIAL_PROCESSED)
			return Color.CYAN.darker();
		else if (c == INITIAL_POPPED)
			return Color.GRAY;
		return c.darker();
	}

		/**
	* Selects the initial color in a gradient texture.
	*
	* @param c The cell name of the color
	* @return The color for the gradient
	*/
	public Color initialGradient(Color c) {
		if (c == CUSTOMER_PROCESSED)
			return new Color(150, 250, 250);
		else if (c == INITIAL_PROCESSED)
			return new Color(250, 250, 80);
		else if (c == INITIAL_POPPED)
			return new Color(250, 250, 80);
		else if (c == CUSTOMER)
			return new Color(110, 110, 250);
		else
			return c;
	}
}
