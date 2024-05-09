public class RoomWithTools extends Room {
    
    /**
     * Constructs a RoomWithTools with a specified room number.
     * @param number The number of the room.
     */
    public RoomWithTools(int number) {
        super(number);
    }

    /**
     * Indicates whether this room has tools.
     * @return true because this room type always contains tools.
     */
    @Override
    public boolean hasTools() {
        return true;
    }
}