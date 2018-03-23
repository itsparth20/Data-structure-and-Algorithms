import java.awt.Color;

/**
 * This class represents a hexagonal cell used to make up a <code>Map</code>
 * object.
 * <p>
 * Each cell has a type: No-flying, Initial, Customer, Free, OutOfStack, Tower,
 * Thief, High_altitude, Initial_Processed, Inital_OutOfStack,
 * Customer_Processed, or InStack. Each cell type is drawn in a different
 * colour.
 * <p>
 * Hexagonal cells know about their neighbors (if they are set using setNeighbor
 * method).
 * <p>
 * The neighbors of a cell are accessed by an index 0-5 inclusive.
 * <ul>
 * <li>The hexagons are pointed-top in orientation, the 0 index is the
 * upper-right side</li>
 * <li>Indexes for the sides progress incrementally clockwise from the 0 index,
 * to 5 on the upper-left side</li>
 * </ul>
 * Eg.
 * <p>
 * <code>    5 /  \ 0</code>
 * <p>
 * <code>    4 |  | 1</code>
 * <p>
 * <code>    3 \  / 2</code>
 * <p>
 * 
 * @author CS1027
 *
 */
public class MapCell extends HexComponent {
	private static final long serialVersionUID = 4865976127980106774L;

	// enum to represent available hexagon cell types
	public static enum CellType {
		NO_FLYING, INITIAL, CUSTOMER, FREE, INITIAL_PROCESSED, CUSTOMER_PROCESSED, INITIAL_DEQUEUED, ENQUEUED, DEQUEUED, TOWER, THIEF, HIGH_ALTITUDE, PATH
	};

	private CellType type; // Stores the current type of this cell. This value
							// changes as the cells in the board are marked
	private CellType originalType; // Type initially assigned to this cell
	private boolean isStart; // Is this the initial cell with the UWO store?
	private boolean isEnd; // Is this the customer cell?
	private MapCell[] neighbors; // Stores the cells which surround this one
									// on each of its 6 sides
	private int timeDelay; // Time that the program waits before moving to
							// an adjacent cell
	private int distanceToStart; // Distance from the cell represented by
									// this MapCell object to the initial cell
	private MapCell predecessor; // Predecessor in the shortest path to customer
									// cell

	/**
	 * Create a hexagonal cell of the specified type
	 * 
	 * @param t
	 *            the CellType to create
	 * @param delay
	 *            time that the program wairts before moving to next cell
	 */
	public MapCell(CellType t, int delay) {
		timeDelay = delay;
		this.type = t;
		this.originalType = t;
		this.isStart = (t == CellType.INITIAL);
		this.isEnd = (t == CellType.CUSTOMER);
		predecessor = null;

		// set the initial color based on the initial type
		this.setColor(this.type);
		// allocate space for the neighbor array
		this.neighbors = new MapCell[6];
		if (isStart)
			distanceToStart = 0;
		else
			distanceToStart = Integer.MAX_VALUE; // Distance to initial chamber
													// is not known
	}

	/**
	 * Set the neighbor for this cell using the neighbor index.
	 * 
	 * The index for the neighbor indicates which side of the hexagon this new
	 * neighbor is on: 0-5 inclusive.
	 * 
	 * @param neighbor
	 *            The new cell neighbor
	 * @param i
	 *            The index specifying which side this neighbor is on (0-5
	 *            inclusive)
	 * @throws InvalidNeighbourIndexException
	 *             When an index is specified that is not 0-5.
	 */
	public void setNeighbour(MapCell neighbor, int i) throws InvalidNeighbourIndexException {
		if (0 <= i && i <= 5)
			this.neighbors[i] = neighbor;
		else
			throw new InvalidNeighbourIndexException(i);
	}

	/**
	 * Returns the neighbor for this cell using the neighbor index.
	 * 
	 * The index for the neighbor indicates in which side of the hexagon the
	 * neighbor is: 0-5.
	 * 
	 * @param i
	 *            The index of the neighbor
	 * @return The cell that is on the i-th side of the current cell, or null if
	 *         no neighbor
	 * @throws InvalidNeighbourIndexException
	 *             When an index is specified that is not 0-5.
	 */
	public MapCell getNeighbour(int i) throws InvalidNeighbourIndexException {
		if (0 <= i && i <= 5)
			return this.neighbors[i];
		else
			throw new InvalidNeighbourIndexException(i);
	}

	/**
	 * This method checks if the current cell is a no-flying cell.
	 * 
	 * @return true if this is a no-flying cell, false otherwise.
	 */
	public boolean isNoFlying() {
		return type == CellType.NO_FLYING;
	}

	/**
	 * This method checks if the current cell is a free cell.
	 * 
	 * @return true if this cell is free, false otherwise.
	 */
	public boolean isFree() {
		return type == CellType.FREE;
	}

	/**
	 * This method checks if the current Hexagon has been marked as dequeued
	 * 
	 * @return true if this chamber has been marked as dequeued, false
	 *         otherwise.
	 */

	public boolean isMarkedDequeued() {
		return (type == CellType.DEQUEUED);
	}

	/**
	 * This method checks if the current Hexagon has been marked as enqueued
	 * 
	 * @return true if this chamber has been marked as enqueued, false
	 *         otherwise.
	 */

	public boolean isMarkedEnqueued() {
		return (type == CellType.ENQUEUED);
	}

	/**
	 * This method checks if the current MapCell object contains a tower. This
	 * means that no adjacent MapCell object can be in the path to the
	 * destination
	 * 
	 * @return true if cell has a tower, false otherwise.
	 */
	public boolean isTower() {
		return type == CellType.TOWER;
	}

	/**
	 * This method checks if the current cell is a thief cell.
	 * 
	 * @return true if this is a thief cell, false otherwise.
	 */
	public boolean isThief() {
		return type == CellType.THIEF;
	}

	/**
	 * This method checks if the current hexagon is a high altitude cell.
	 * 
	 * @return true if this is a high altitude cell, false otherwise.
	 */
	public boolean isHighAltitude() {
		return type == CellType.HIGH_ALTITUDE;
	}

	/**
	 * This method checks if the current cell is the initial cell.
	 * 
	 * @return true if this is the initial cell, false otherwise.
	 */
	public boolean isInitial() {
		return this.isStart;
	}

	/**
	 * This method checks if the current cell is the destination.
	 * 
	 * @return true if this is the destination cell, false otherwise.
	 */
	public boolean isCustomer() {
		return this.isEnd;
	}

	/**
	 * This method re-draws the current hexagonal cell
	 */
	private void reDraw() {
		try {
			Thread.sleep(timeDelay);
		} catch (Exception e) {
			System.err.println("Error while issuing time delay\n" + e.getMessage());
		}
		super.repaint();
	}

	/**
	 * This method marks the cell as in-stack and updates the cell's colour
	 */
	public void markEnqueued() {
		type = CellType.ENQUEUED;
		setColor(type);
		reDraw();
	}

	/**
	 * This method marks the cell as popped and updates the cell's colour
	 */
	public void markDequeued() {
		type = CellType.DEQUEUED;
		if (this.isCustomer()) {
			MapCell prev = this;
			while (prev != null) {
				prev.setColor(CellType.PATH);
				reDraw();
				prev = prev.getPredecessor();
			}
		} else {
			setColor(this.type);
			reDraw();
		}
	}

	/**
	 * This method marks the destination cell and updates the cell's colour
	 */
	public void markCustomer() {
		this.type = CellType.CUSTOMER_PROCESSED;
		this.setColor(this.type);
		reDraw();
	}

	/**
	 * This method marks the cell as the initial cell and updates the cell's
	 * colour
	 */
	public void markInitial() {
		this.type = CellType.INITIAL_PROCESSED;
		this.setColor(this.type);
		reDraw();
	}

	/**
	 * Helper method to set the current cell color based on the type of cell.
	 * 
	 * @param t
	 *            The type of the cell; used to set the color
	 */
	private void setColor(CellType t) {
		switch (t) {
		case NO_FLYING:
			this.setBackground(CellColors.NO_FLYING);
			break;
		case INITIAL:
			this.setBackground(CellColors.INITIAL);
			break;
		case CUSTOMER:
			this.setBackground(CellColors.CUSTOMER);
			break;
		case FREE:
			this.setBackground(CellColors.UNVISITED);
			break;
		case CUSTOMER_PROCESSED:
			this.setBackground(CellColors.CUSTOMER_PROCESSED);
			break;
		case INITIAL_PROCESSED:
			this.setBackground(CellColors.INITIAL_PROCESSED);
			break;
		case INITIAL_DEQUEUED:
			this.setBackground(CellColors.INITIAL_DEQUEUED);
			break;
		case ENQUEUED:
			if (originalType == CellType.THIEF)
				setBackground(CellColors.THIEF_ENQUEUED);
			else if (originalType == CellType.HIGH_ALTITUDE)
				setBackground(CellColors.HIGH_ALTITUDE_ENQUEUED);
			else if (originalType == CellType.INITIAL)
				this.setBackground(CellColors.INITIAL_PROCESSED);
			else if (originalType == CellType.CUSTOMER)
				this.setBackground(CellColors.CUSTOMER_PROCESSED);
			else
				setBackground(CellColors.IN_QUEUE);
			break;
		case DEQUEUED:
			if (originalType == CellType.THIEF)
				setBackground(CellColors.THIEF_DEQUEUED);
			else if (originalType == CellType.HIGH_ALTITUDE)
				setBackground(CellColors.HIGH_ALTITUDE_DEQUEUED);
			else if (originalType == CellType.INITIAL)
				setBackground(CellColors.INITIAL_DEQUEUED);
			else
				setBackground(CellColors.OUT_QUEUE);
			break;
		case PATH:
			if (originalType == CellType.THIEF)
				setBackground(CellColors.THIEF_PATH);
			else if (originalType == CellType.HIGH_ALTITUDE)
				setBackground(CellColors.HIGH_ALTITUDE_PATH);
			else if (originalType == CellType.INITIAL)
				setBackground(CellColors.INITIAL_PATH);
			else if (originalType == CellType.CUSTOMER)
				setBackground(CellColors.CUSTOMER_PATH);
			else
				setBackground(CellColors.PATH);
			break;
		case TOWER:
			this.setBackground(CellColors.TOWER);
			break;
		case THIEF:
			this.setBackground(CellColors.THIEF);
			break;
		case HIGH_ALTITUDE:
			this.setBackground(CellColors.HIGH_ALTITUDE);
			break;
		default:
			this.setBackground(CellColors.NO_FLYING);
			break;
		}
		this.setForeground(Color.BLACK);
	}

	/**
	 * Gets a String representation of a cell.
	 * 
	 * @return String representation of the cell.
	 */
	public String toString() {
		if (type == CellType.NO_FLYING)
			return "No flying cell, ";
		else if (type == CellType.INITIAL || type == CellType.INITIAL_PROCESSED || type == CellType.INITIAL_DEQUEUED
				|| originalType == CellType.INITIAL)
			return "Initial cell, ";
		else if (type == CellType.CUSTOMER || type == CellType.CUSTOMER_PROCESSED || originalType == CellType.CUSTOMER)
			return "Destination, ";
		else if (type == CellType.FREE || originalType == CellType.FREE)
			return "Free cell, ";
		else if (type == CellType.THIEF || originalType == CellType.THIEF)
			return "Thief\'s cell, ";
		else if (type == CellType.HIGH_ALTITUDE || originalType == CellType.HIGH_ALTITUDE)
			return "High altitude cell, ";
		else if (type == CellType.TOWER)
			return "Tower cell, ";
		else
			return "";
	}

	/**
	 * Returns the predicted distance from this chamber to the exit of the
	 * dungeon. The predicted distance is simply the Euclidean distance. If
	 * there is no exit to the dungeon then a distance of 0 is returned
	 * 
	 * 
	 * @param The
	 *            dungeon to which the chamber belongs
	 * @return The predicted distance to the exit
	 */

	public double euclideanDistToDest(Map d) {
		int cell = d.getCellSize();

		double dist = 0;
		if (isCustomer())
			return 0;
		try {
			double x1, y1, x2, y2;
			x1 = (this.getX() * 49) / (37 * cell);
			x2 = (d.getDestination().getX() * 49) / (37 * cell);
			y1 = this.getY() / cell;
			y2 = d.getDestination().getY() / cell;

			dist = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
		} catch (NullPointerException e) {
			return 0;
		}

		if (dist == 0)
			return 1; // Distance to destination is at least 1
		else
			return dist;
	}

	public double euclideanDistToDest2(Map d) {
		double cell = (double) d.getCellSize();

		double dist = 0;
		if (isCustomer())
			return 0;

		try {
			double x1, y1, x2, y2;
			x1 = (double) this.getX();
			x2 = (double) d.getDestination().getX();
			y1 = (double) this.getY();
			y2 = (double) d.getDestination().getY();

			// 49:37 ratio of height to width of displayed hexagons
			dist = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow(y1 - y2, 2)) / cell;
		} catch (NullPointerException e) {
			return 0;
		}

		if (dist == 0)
			return 1; // Distance to destination is at least 1
		else
			return dist;
	}

	/**
	 * Returns the current estimation of the distance from the inital chamber to
	 * this chamber
	 * 
	 * @return The estimated distance to the initial chamber
	 */
	public int getDistanceToStart() {
		return distanceToStart;
	}

	/**
	 * Changes the current estimation of the distance from the inital chamber to
	 * this chamber
	 * 
	 * @param The
	 *            estimation of the distance to the initial chamber
	 */
	public void setDistanceToStart(int dist) {
		distanceToStart = dist;
	}

	/**
	 * Returns true if this Hexagon object is being referenced by otherChamber
	 * 
	 * @param otherChamber
	 *            Hexagon reference
	 * @return true if the parameter points to this Hexagon
	 */
	public boolean equals(MapCell otherCell) {
		return this == otherCell;
	}

	/**
	 * Get the preceding Hexagon object to this one in a shortest path from
	 * initial chamber to exit
	 * 
	 * @return preceding Hexagon object in the shortest path from initial
	 *         chamber to destination
	 */
	public MapCell getPredecessor() {
		return predecessor;
	}

	/**
	 * Set the preceding Hexagon object to this one in a shortest path from the
	 * initial chamber to the exit
	 * 
	 * @param pred:
	 *            preceding Hexagon object to this one in a shortest path from
	 *            the initial chamer to the exit
	 */
	public void setPredecessor(MapCell pred) {
		predecessor = pred;
	}
}