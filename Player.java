import java.util.ArrayList;
import java.util.List;

/**
 * The "Player" class represents a player in the maze adventure game.
 * Each player has a name, current room, and a list of collected machine parts.
 * This class provides methods for player actions such as moving between rooms, collecting parts, 
 * collecting tools, building the machine, and resetting collected items.
 * 
 * @author Francesco Thomas, Alex Besaw, Connor Broderick
 */
public class Player {
    private String name; // name of player
    private Room currentRoom; // where player is located
    private List<Part> collectedParts; // list of collected machine parts
    private boolean toolsCollected; // boolean flag for whether or not player has tools
    public static final int TOTAL_PARTS_NEEDED_TO_WIN = 4;

    /**
     * Constructs a new Player object with the specified name and starting room.
     * 
     * @param name The name of the player.
     * @param currentRoom The starting room of the player.
     */    
    public Player(String name, Room currentRoom) {
        this.name = name;
        this.currentRoom = currentRoom;
        this.collectedParts = new ArrayList<>();
        this.toolsCollected = false;
    }

    /**
     * Setter method for the current room of the player.
     * 
     * @param room The room to set as the current room.
     */    
    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

   /**
     * Getter method for the current room.
     * 
     * @return The current room of the player.
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Getter method for the last machine part collected by the player.
     * 
     * @return The last machine part collected, or null if none has been collected yet.
     */
    public Part getLastMachinePartCollected() {
        if (collectedParts.isEmpty()) {
            return null;
        }
        return collectedParts.get(collectedParts.size() - 1);
    }

    /**
     * Boolean check for if the player has collected tools.
     * 
     * @return true if the player has collected tools, false otherwise.
     */
    public boolean hasTools() {
        return toolsCollected;
    }

    /**
     * Moves the player in the specified direction
     * @param direction The direction in which the player wants to move (0-Up, 1-Down, 2-Left, 3-Right).
     * @return A message indicating the result of the movement attempt.
     */ 
    public String move(int direction) {
        Room nextRoom = currentRoom.getDoor(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            return "Welcome to Room " + currentRoom.getNumber();
        } else {
            return "No door in this direction";
        }
    }

    /**
     * Attempts to collect a machine part from the current room.
     * 
     * @return A message indicating the result of the collection attempt.
     */
    public String collectPart() {
        if (!currentRoom.hasPart()) {
            return "Room does not have machine parts";
        }
        Part part = currentRoom.getPart();
        if (part == null) {
            return "Part already collected";
        }
        Part lastCollected = getLastMachinePartCollected();
        if (lastCollected != null && !part.isNext(lastCollected)) {
            return "Parts must be collected in order";
        }
        collectedParts.add(part);
        return "You successfully collected part " + part.getNumber();
    }

    /**
     * Attempts to collect tools from the current room.
     * 
     * @return A message indicating the result of the collection attempt.
     */
    public String collectTools() {
        if (!currentRoom.hasTools()) {
            return "Room does not have tools";
        }
        if (toolsCollected) {
            return "Tools already collected";
        }
        toolsCollected = true;
        return "You successfully collected tools";
    }

    /**
     * Attempts to build the machine in the current room's workshop.
     * 
     * @return A message indicating the result of the build attempt.
     */
    public String buildMachine() {
        if (!currentRoom.isWorkshop()) {
            return "You are not in the workshop";
        }
        if (!hasAllParts()) {
            return "You don’t have all the parts";
        }
        if (!toolsCollected) {
            return "You don’t have the tools";
        }
        return "Task Completed! You Win!!!!";
    }

    /**
     * Boolean check for if the player has collected all the required machine parts.
     * 
     * @return true if the player has collected all the parts, false otherwise.
     */
    private boolean hasAllParts() {
        return collectedParts.size() == TOTAL_PARTS_NEEDED_TO_WIN;
    }

    /**
     * Resets the player's collected items, including machine parts and tools.
     */
    public void resetCollectedItems() {
        collectedParts.clear();
        toolsCollected = false;
    }
}
