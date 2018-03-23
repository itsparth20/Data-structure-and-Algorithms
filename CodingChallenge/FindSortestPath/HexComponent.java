
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 * A six sided cell in a hexagonal grid.
 *
 * @author keang, cs1027
 *
 *
 */

public class HexComponent extends JComponent {
	private static final long serialVersionUID = 4865976127980106774L;

	private Polygon hexagon = new Polygon(); // Hexagonal cell

	private final int nPoints = 6;
	private int[] hexX = new int[nPoints]; // x coordinates of the vertices of
											// the hexagon
	private int[] hexY = new int[nPoints]; // y coordinates of the vertices of
											// the hexagon

	private Color defaultColor; // Default color for the hexagonal cells

	/**
	 * This method checks if the hexagon contains the given point.
	 * 
	 * @param p
	 *            point
	 * @return true or false
	 */
	@Override
	public boolean contains(Point p) {
		return hexagon.contains(p);
	}

	/**
	 * This method checks if the hexagon contains the given point.
	 * 
	 * @param x
	 *            x coordinate of the point
	 * @param y
	 *            y coordinate of the point
	 * @return true or false
	 */
	@Override
	public boolean contains(int x, int y) {
		return hexagon.contains(x, y);
	}

	/**
	 * This method sets the size at which the hexagon will be displayed on the
	 * screen
	 * 
	 * @param d
	 *            size of the rectangle
	 */
	@Override
	public void setSize(Dimension d) {
		super.setSize(d);
		calculateCoords();
	}

	/**
	 * This method sets the size at which the hexagon will be displayed on the
	 * screen
	 * 
	 * @param w
	 *            width of the rectangle
	 * @param h
	 *            height of the rectangle
	 */
	@Override
	public void setSize(int w, int h) {
		super.setSize(w, h);
		calculateCoords();
	}

	/**
	 * Bounds the hexagon within a rectangle
	 * 
	 * @param x
	 *            x coordinate of the upper left corner of the enclosing
	 *            rectangle
	 * @param y
	 *            y coordinate of the upper left cornet of the enclosing
	 *            rectangle
	 * @param width
	 *            width of the enclosing rectangle
	 * @param height
	 *            height of the enclosing rectange
	 */
	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		calculateCoords();
	}

	/**
	 * Bounds the hexagon within a rectangle
	 * 
	 * @param r
	 *            enclosing rectangle
	 */
	@Override
	public void setBounds(Rectangle r) {
		super.setBounds(r);
		calculateCoords();
	}

	/**
	 * Processes a mouse click
	 * 
	 * @param e
	 *            MouseEvent object representing mouse's click
	 */
	@Override
	protected void processMouseEvent(MouseEvent e) {
		if (contains(e.getPoint()))
			super.processMouseEvent(e);
	}

	/**
	 * Calculates the coordinates of the hexagon on the screen
	 */
	private void calculateCoords() {
		int w = getWidth() - 1;
		int h = getHeight() - 1;

		int ratio = (int) (h * .25);

		agressiveCoords(w, h, ratio);

		hexagon = new Polygon(hexX, hexY, nPoints);
	}

	private void agressiveCoords(int w, int h, int ratio) {
		hexX[0] = w / 2;
		hexY[0] = 0;

		hexX[1] = w;
		hexY[1] = ratio;

		hexX[2] = w;
		hexY[2] = h - ratio;

		hexX[3] = w / 2;
		hexY[3] = h;

		hexX[4] = 0;
		hexY[4] = h - ratio;

		hexX[5] = 0;
		hexY[5] = ratio;
	}

	/**
	 * Draws the different types of map cells on the screen
	 * 
	 * @param g
	 *            Graphics object used to draw the cells on the screen
	 */
	@Override
	protected void paintComponent(Graphics g) {
		CellColors palette = new CellColors();
		Color c = getBackground();
		Graphics2D g2d = (Graphics2D) g;
		defaultColor = (Color) g2d.getPaint();
		boolean displayed = false;
		GradientPaint gp;
		int width = getWidth();
		int height = getHeight();

		/*
		 * Each map cell has a background color and some of them have an icon in
		 * them. Background color and icon are selected below
		 */
		if (c == CellColors.NO_FLYING) {
			try {
				// No fly cell
				g2d.setColor(new Color(102, 107, 114));
				g2d.fillPolygon(hexagon);
				Image img = new ImageIcon("nofly.jpg").getImage();
				g2d.drawImage(img, 0, 0, width, width, null);
				displayed = true;
			} catch (Exception e) {
				System.out.println("Error opening file nofly.jpg");
			}
		} else if (c == CellColors.TOWER) {
			// Cell containing a cellular tower
			g2d.setColor(new Color(255, 255, 255));
			g2d.fillPolygon(hexagon);
			Image img = new ImageIcon("tower.jpg").getImage();
			g2d.drawImage(img, 0, 0, width, width, null);
			displayed = true;
		} else if (c == CellColors.CUSTOMER_PROCESSED || c == CellColors.INITIAL_PROCESSED
				|| c == CellColors.INITIAL_DEQUEUED || c == CellColors.CUSTOMER_DEQUEUED || c == CellColors.INITIAL_PATH
				|| c == CellColors.CUSTOMER_PATH) {
			// Initial and destination cells when they have been reached
			displayed = true;
			Image img;

			if (c == CellColors.CUSTOMER_PROCESSED || c == CellColors.INITIAL_PROCESSED)
				gp = new GradientPaint(hexX[5], hexY[5], palette.initialGradient(CellColors.IN_QUEUE), hexX[1], hexY[1],
						palette.gradientColor(CellColors.IN_QUEUE), true);
			else
				gp = new GradientPaint(hexX[5], hexY[5], palette.initialGradient(c), hexX[1], hexY[1],
						palette.gradientColor(c), true);
			g2d.setPaint(gp);
			g2d.fillPolygon(hexagon);

			if (c == CellColors.CUSTOMER_PROCESSED) {
				img = new ImageIcon("customerPushed.jpg").getImage();
				g2d.drawImage(img, width / 5, height / 5, 3 * width / 5, 3 * height / 5, null);
			} else if (c == CellColors.CUSTOMER_PATH || c == CellColors.CUSTOMER_DEQUEUED) {
				img = new ImageIcon("customerPath.jpg").getImage();
				g2d.drawImage(img, width / 5, height / 5, 3 * width / 5, 3 * height / 5, null);
			} else if (c == CellColors.INITIAL_PROCESSED || c == CellColors.INITIAL_DEQUEUED) {
				img = new ImageIcon("uwo.jpg").getImage();
				g2d.drawImage(img, width / 5, height / 5, 3 * width / 5, 3 * height / 5, null);
			} else {
				img = new ImageIcon("uwoPath.jpg").getImage();
				g2d.drawImage(img, width / 5, height / 5, 3 * width / 5, 3 * height / 5, null);
				drawDrone(g2d, width / 3, width / 3);
			}
			displayed = true;
		} else if (c == CellColors.CUSTOMER) {
			// Destination cell. The drone has not yet arrived here.
			Image img;
			gp = new GradientPaint(hexX[5], hexY[5], palette.initialGradient(c), hexX[1], hexY[1],
					palette.gradientColor(c), true);
			g2d.setPaint(gp);
			g2d.fillPolygon(hexagon);
			img = new ImageIcon("customer.jpg").getImage();
			g2d.drawImage(img, width / 5, height / 5, 3 * width / 5, 3 * height / 5, null);

			displayed = true;
		} else if (c == CellColors.THIEF || c == CellColors.THIEF_ENQUEUED || c == CellColors.THIEF_DEQUEUED
				|| c == CellColors.THIEF_PATH) {
			// Thief cells: inital state, when they are visited for the first
			// time,
			// and when the program decides not to include them in the path
			Image img;
			if (c == CellColors.THIEF) {
				g2d.setColor(new Color(197, 197, 197));
				g2d.fillPolygon(hexagon);
				img = new ImageIcon("thief.jpg").getImage();
			} else if (c == CellColors.THIEF_ENQUEUED) {
				g2d.setColor(new Color(162, 211, 218));
				g2d.fillPolygon(hexagon);
				img = new ImageIcon("thiefPushed.jpg").getImage();
			} else if (c == CellColors.THIEF_DEQUEUED) {
				g2d.setColor(new Color(179, 181, 195));
				g2d.fillPolygon(hexagon);
				img = new ImageIcon("thiefPopped.jpg").getImage();
			} else {
				g2d.setColor(new Color(206, 153, 169));
				g2d.fillPolygon(hexagon);
				img = new ImageIcon("thiefPath.jpg").getImage();
			}
			g2d.drawImage(img, 0, 0, width, width, null);
			if (c == CellColors.THIEF_PATH)
				drawDrone(g2d, width / 3, width / 3);
			displayed = true;
		} else if (c == CellColors.HIGH_ALTITUDE || c == CellColors.HIGH_ALTITUDE_ENQUEUED
				|| c == CellColors.HIGH_ALTITUDE_DEQUEUED || c == CellColors.HIGH_ALTITUDE_PATH) {
			// High altitude cells: initial state, when they are visited for the
			// first time,
			// and when the program decides not to include them in the path
			Image img;
			if (c == CellColors.HIGH_ALTITUDE) {
				g2d.setColor(new Color(83, 81, 82));
				g2d.fillPolygon(hexagon);
				img = new ImageIcon("building.jpg").getImage();
			} else if (c == CellColors.HIGH_ALTITUDE_ENQUEUED) {
				g2d.setColor(new Color(106, 131, 136));
				g2d.fillPolygon(hexagon);
				img = new ImageIcon("buildingPushed.jpg").getImage();
			} else if (c == CellColors.HIGH_ALTITUDE_DEQUEUED) {
				g2d.setColor(new Color(111, 111, 121));
				g2d.fillPolygon(hexagon);
				img = new ImageIcon("buildingPopped.jpg").getImage();
			} else {
				g2d.setColor(new Color(111, 111, 121));
				g2d.fillPolygon(hexagon);
				img = new ImageIcon("buildingPath.jpg").getImage();
			}
			g2d.drawImage(img, 0, 0, width, width, null);
			displayed = true;

		}
		if (!displayed) {
			gp = new GradientPaint(hexX[5], hexY[5], palette.initialGradient(c), hexX[1], hexY[1],
					palette.gradientColor(c), true);
			g2d.setPaint(gp);
			g2d.fillPolygon(hexagon);
			if (c == CellColors.PATH)
				drawDrone(g2d, width / 3, width / 3);
		}
		g2d.setPaint(defaultColor);

	}

	private void drawDrone(Graphics2D g2d, int pos, int size) {
		Image img = new ImageIcon("drone.jpg").getImage();
		g2d.drawImage(img, pos, pos, size, size, null);
	}

	@Override
	protected void paintBorder(Graphics g) {
		// do not paint a border
	}

}
