public class Workshop extends Room {
/**
 * subclass Workshop room
* @author Abdul Wakil Zamani
*/

/**
 * Workshop class represents a room designated for workshops.
 * @param number represents the number of the current room.
 */
    public Workshop(int number) {
        super(number);
    }

/**
 * Determines whether this room is designated as a workshop.
 * should @return true, as this room is always a workshop.
 */
    @Override
    public boolean isWorkshop() {
        return true;
    }
}
