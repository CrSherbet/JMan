package JMan;

import java.awt.Color;
import java.awt.Graphics;

/** An instance of this class is a Pillar. */
public class Pillar extends Piece {

	/**
	 * Constructor: a new Pillar at position (x, y) on Map m with color c.
	 * Precondition: c is one of Color.RED, Color.GREEN, and Color.YELLOW.
	 */
	public Pillar(int x, int y, Color c, Map m) {
		super(Piece.PILLAR, m);
		setX(x);
		setY(y);
		setColor(c);
	}

	/**
	 * Pillar should move based on what button is pushed. Random number and if
	 * number is more than 1, the pillar will change color
	 */
	public void act() {
		if (Math.random() * 2 > 1)
			changeColor((int) Math.round(Math.random() * 2));
	}

	/**
	 * Change the color of pillar based on the value of i: 0 = color red , 1 =
	 * color green, else: color yellow
	 */
	public void changeColor(int i) {
		if (i == 0)
			setColor(Color.RED);
		else if (i == 1)
			setColor(Color.GREEN);
		else
			setColor(Color.YELLOW);
	}

	/** = representation of this piece */
	public String toString() {
		return getColorWord() + " Pillar at (" + getX() + ", " + getY() + ")";
	}

	/**
	 * Tile is a pillar, fill it with an appropriate colored triangle.
	 */
	@Override
	public void draw(Graphics g, int x, int y, int width, int height) {
		g.setColor(getColor());
		g.fillPolygon(new int[] { x + 1, x + width - 1, x + width / 2 },
				new int[] { y + height - 2, y + height - 2, y }, 3);
	}
}