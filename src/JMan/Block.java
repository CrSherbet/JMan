package JMan;
import java.awt.Color;

/** An instance of this class is a Block. */
public class Block extends Piece {
    
    /** Constructor: a new Block at position (x, y) on Map m
     with color white */
    public Block(int x, int y, Map m){
        super(Piece.BLOCK, m);
        setX( x );
        setY( y );
        setColor( Color.WHITE );
    }
    
    /** = representation of this piece */
    public String toString() {
        return getColorWord() + " Block at (" + getX() + ", " + getY() + ")";
    }

    /**
     * White Block was not used this method
     */
	@Override
	public void act() {
	}
}