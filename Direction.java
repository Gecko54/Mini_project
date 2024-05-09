/**
 * This class has four static constants that can be used as 
 * indices for doors array be the classes calling setDoor and 
 * getDoor methods in Class Room 
 * @author Sahar Al Seesi
 */

public class Direction {
	public static final int right = 0;
	public static final int left = 1;
	public static final int up = 2;
	public static final int down = 3;

	   /**
	    * returns the opposite index of a given direction 
	    * ex: getOpposite(0) or getOpposite(right) return 1 or left
	    * @return int
	    */

	public static int getOpposite(int direction)  {
		int retVal = -1;
		switch (direction) {
			case right:
				retVal = left;
				break;
			case left:
				retVal = right;
				break;
			case up:
				retVal = down;
				break;
			case down:
				retVal = up;
				break;
			default:
				break;		
		}
		return retVal;
	}
}