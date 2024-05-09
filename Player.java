import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Room currentRoom;
    private List<Part> collectedParts;
    private boolean toolsCollected;
    public static final int TOTAL_PARTS_NEEDED_TO_WIN = 4;

    public Player(String name, Room currentRoom) {
        this.name = name;
        this.currentRoom = currentRoom;
        this.collectedParts = new ArrayList<>();
        this.toolsCollected = false;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Part getLastMachinePartCollected() {
        if (collectedParts.isEmpty()) {
            return null;
        }
        return collectedParts.get(collectedParts.size() - 1);
    }

    public boolean hasTools() {
        return toolsCollected;
    }

    public String move(int direction) {
        Room nextRoom = currentRoom.getDoor(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            return "Welcome to Room " + currentRoom.getNumber();
        } else {
            return "No door in this direction";
        }
    }

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

    private boolean hasAllParts() {
        return collectedParts.size() == TOTAL_PARTS_NEEDED_TO_WIN;
    }

    public void resetCollectedItems() {
        collectedParts.clear();
        toolsCollected = false;
    }
}