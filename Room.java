/**
 * A class representing a room in the Maze adventure 
 * @author Sahar Al Seesi
 */
public class Room {
	
	private int number;
	private Room [] doors;
	
	public Room(int number) {
		this.number = number;
		doors = new Room[4];				
	}
	
	   /**
	    * Sets the door[direction] to r, after checking for inconsistencies
	    *
	    * @param direction, one of the values in class Direction
	    * @param r a Room object
	    * @return void
	    * @throws Exception if inconsistencies found
	    */
	public void setDoor(int direction, Room r) throws Exception {

		if (r.getDoor(Direction.getOpposite(direction)) ==  null || 
				r.getDoor(Direction.getOpposite(direction)) == this) { 
			doors[direction] = r;
		}
		else throw (new Exception ("Inconsistent Door from Room "+number+" to Room "+ r.getNumber()));
	}
	
	   /**
	    * returns the Room object to which a door in 
	    * a specific direction points; null if none
	    * @param direction, one of the values in class Direction
	    * @return Room
	    */
	public Room getDoor(int direction) {
		System.out.println(direction);
		System.out.println("Room "+number);		
		return doors[direction];
	}

	   /**
	    * getter method. Returns number
	    * @return int
	    */

	public int getNumber() {
		return number;
	}

	   /**
	    * returns false for generic room type. To be overridden 
	    * in subclass RoomWithMachinePart
	    * @return boolean
	    */

	public boolean hasPart () {
		return false;
	}

	   /**
	    * returns false for generic room type. To be overridden 
	    * in subclass RoomWithTools
	    * @return boolean
	    */

	public boolean hasTools() {
		return false;
	}
	   /**
	    * returns false for generic room type. To be overridden 
	    * in subclass Workshop
	    * @return boolean
	    */
	
	public boolean isWorkshop () {
		return false;
	}
	   /**
	    * returns the welcome message for a player entering this room
	    * @return String
	    */
	
	public String printMessage() {
		return "Welcome to Room "+number;
	}

	   /**
	    * returns a help message for specifying this room number
	    * @return String
	    */

	public String helpMessage() {
		return "You are in Room "+number;
	}
	
	public Part getPart() {
		return null; // Override this method in RoomWithMachinePart
	}	
}
