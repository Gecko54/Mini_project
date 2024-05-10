/** A room for tools that is a subclass of Room.
* @author  Alex Besaw, Connor Broderick because he knows throw stuff :) 
*/
public class RoomWithMachinePart extends Room {
    private Part machinePart; // super secret machinepart that is within said room

/**
 * Creates a RoomWithMachinePart instance with a given room number and machine part.
 * @param number The number of the room.
 * @param part The machine component found in this room.
 */
    public RoomWithMachinePart(int number, Part part) {
        super(number);
        if (part == null) {
            throw new IllegalArgumentException("Part cannot be null");
        }
        this.machinePart = part;
    }

    /**
     * Obtains the machine part in this room.
     * @return machine part
     */
    @Override
    public Part getPart() {
        return machinePart;
    }

    /**
     * Detects if the room has a machine part.
     * Should always @return true because this room type will always contains a part.
     */
    @Override
    public boolean hasPart() {
        return true;
    }
}
