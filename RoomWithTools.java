public class RoomWithTools extends Room {
/** A room for tools that is a subclass of Room.
* @author Connor Broderick
*/
    
/**
 * Creates a RoomWithTools instance associated with a specific room number.
 * @param number is the identifier of the room.
 */
    public RoomWithTools(int number) {
        super(number);
    }

    /**
     * Determines if this room has tools
     * should @return true, as this room type will always contains tools.
     */
    @Override
    public boolean hasTools() {
        return true;
    }
}