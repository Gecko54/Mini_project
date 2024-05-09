public class Workshop extends Room {
    /**
     * Constructor for the Workshop class.
     * @param number The number of this room.
     */
    public Workshop(int number) {
        super(number);
    }

    /**
     * Indicates whether this room is a workshop.
     * @return true because this room is always a workshop.
     */
    @Override
    public boolean isWorkshop() {
        return true;
    }
}
