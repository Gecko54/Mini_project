/**
 * The "Part" class encapsulates a machine part in the maze adventure, each identified by a unique number.
 * This class provides methods to access and manipulate part information within the game.
 * 
 * @author Francesco Thomas, Abdul Wakil Zamani
 */

public class Part {
    private int number; // The identifier of a part
    private static final int LAST_PART = 4; // Assuming the last part number is 5. adjusted as required

    /**
     * Constructs a Part object with the specified part number.
     * 
     * @param number The part number assigned to this Part.
     */
    public Part(int number) {
        this.number = number;
    }

    /**
     * Retrieves the part number associated with this Part object.
     * 
     * @return The part number of this Part.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Determines whether this Part is the final part in the machine assembly sequence.
     * 
     * @return true if this Part is the last in the sequence, otherwise false.
     */
    public boolean isLastPart() {
        return this.number == LAST_PART;
    }

    /**
     * Determines whether this Part follows another specified Part in the assembly sequence.
     * 
     * @param previousPart The Part that should precede this Part in sequence.
     * @return true if this Part comes after the previousPart in sequence, otherwise false.
     */
    public boolean isNext(Part previousPart) {
        if (previousPart == null) {
            System.out.println("Previous part is null, this part number: " + this.number);
            return this.number == 1;  // Check if this is the first part collected
        }
        boolean result = this.number == previousPart.getNumber() + 1;
        return result;
    }
    
}