package JMan;
import java.awt.*;

/** An instance of this class is a J*Man.
 There should at most one J*Man in a game board at a time*/
public class JMan extends Piece {
    
    /** Constructor: a new J*Man at position (x, y) on Map m
     with color c. Precondition: c is one of
     Color.RED, Color.GREEN, and Color.YELLOW.*/
    public JMan(int x, int y, Color c, Map m){
        super(Piece.JMAN, m);
        setX( x );
        setY( y );
        setColor( c );
    }
    
    /** J*Man should move based on what button is pushed.
     This method is not used. */
    public void act(){
        return;
    }
    
    /** Move J*Man one step based on the value of i:
        0 = up, 1 = down, 2 = left, 3 = right. */
    public void step(int i){
        setActed(true);
        if ( i == 0 && canMove( posX, posY - 1 ))
        	map.move( posX, posY, posX, posY - 1);
        else if ( i == 1 && canMove( posX, posY + 1 ))
        	map.move( posX, posY, posX, posY + 1);
        else if ( i == 2 && canMove( posX - 1, posY ))
        	map.move( posX, posY, posX - 1, posY );
        else if ( i == 3 && canMove( posX + 1 , posY ))
        	map.move( posX, posY, posX + 1 , posY );
    }
   
    /**
     * Checking that JMan can go on or not
     * @param posX is x position that JMan want to walk
     * @param posY is y position that JMan want to walk
     * @return boolean that JMan can go on or not
     */
    public boolean canMove(int posX, int posY ){
    	if( ! map.isInGrid( posX, posY ) )
    		return false ;
    	if( map.isEmpty(posX, posY) || canCapture( map.pieceAt( posX, posY ).getColor() ))
    		return true ;
    	return false ;
    }
    
    /**
     * Checking that JMan can capture the obstacle or not and if he can, set new color
     * @param obstacleCl is color of obstacle
     * @return boolean that JMan can capture the obstacle or not
     */
    public boolean canCapture( Color obstacleCl ){
    	if ( color == Color.GREEN && obstacleCl == Color.RED ){
    		setColor( Color.RED );
    		return true ;
    	}
    	else if ( color == Color.RED && obstacleCl == Color.YELLOW ){
    		setColor( Color.YELLOW );
    		return true ;
    	}
    	else if ( color == Color.YELLOW && obstacleCl == Color.GREEN ){
    		
    		setColor( Color.GREEN );
    		return true ;
    	}
    	return false ;
    }
    
    /** = representation of this piece */
    public String toString() {
        return getColorWord() + " J*Man at (" + getX() + ", " + getY() + ")";
    }
}