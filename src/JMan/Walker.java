package JMan;
import java.awt.Color;

/** An instance of this class is a Walker. */
public class Walker extends Piece {
    
    /** Constructor: a new Walker at position (x, y) on Map m
     with color c. Precondition: c is one of
     Color.RED, Color.GREEN, and Color.YELLOW.*/
    public Walker(int x, int y, Color c, Map m){
        super(Piece.WALKER, m);
        setX( x );
        setY( y );
        setColor( c );
    }
    
    /** Walker should move based on what button is pushed.
     * 	Random number and if number is more than 1, the walker will move
     */
    public void act(){
    	if ( Math.random()* 2 > 1 )
    		step( (int) Math.round(Math.random()*3) );
    }
    
    /** Move Walker one step based on the value of i:
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
     * Checking that the walker can move or not.
     * @param posX is x position that walker want to move.
     * @param posY is y position that walker want to move.
     * @return boolean that the walker can move or not.
     */
    public boolean canMove( int posX , int posY ){
    	if ( map.isEmpty( posX , posY ) && map.isEmpty( posX , posY )) 
    		return true ;
    	return false ;
    }
        
    /** = representation of this piece */
    public String toString() {
        return getColorWord() + " Walker at (" + getX() + ", " + getY() + ")";
    }
}