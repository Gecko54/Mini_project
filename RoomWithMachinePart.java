public class RoomWithMachinePart extends Room {
    private Part machinePart; // The machine part contained in this room

    /**
     * Constructs a RoomWithMachinePart with a specified room number and machine part.
     * @param number The number of the room.
     * @param part The machine part located in this room.
     */
    public RoomWithMachinePart(int number, Part part) {
        super(number);
        if (part == null) {
            throw new IllegalArgumentException("Part cannot be null");
        }
        this.machinePart = part;
    }

    /**
     * Gets the machine part in this room.
     * @return The machine part.
     */
    @Override
    public Part getPart() {
        return machinePart;
    }

    /**
     * Checks if the room has a machine part.
     * @return true because this room type always contains a part.
     */
    @Override
    public boolean hasPart() {
        return true;
    }
}
