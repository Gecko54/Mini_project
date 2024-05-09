public class Part {
    private int number; // The number that identifies this machine part
    private static final int LAST_PART = 4; // Assuming the last part number is 5, modify as necessary

    /**
     * Constructor for Part class.
     * @param number The part number to initialize this Part with.
     */
    public Part(int number) {
        this.number = number;
    }

    /**
     * Getter method for the part number.
     * @return The part number of this Part.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Determines if this Part is the last part in the sequence.
     * @return true if this Part is the last one, false otherwise.
     */
    public boolean isLastPart() {
        return this.number == LAST_PART;
    }

    /**
     * Determines if this Part is the next in sequence after another specified Part.
     * @param previousPart The part that should precede this Part in sequence.
     * @return true if this Part follows the given previousPart in sequence, false otherwise.
     */
    public boolean isNext(Part previousPart) {
        if (previousPart == null) {
            System.out.println("Previous part is null, this part number: " + this.number);
            return this.number == 1;  // Checks if this is the first part to be collected.
        }
        boolean result = this.number == previousPart.getNumber() + 1;
        return result;
    }
    
}