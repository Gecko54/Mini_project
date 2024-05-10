/**
 * The "Game" class manages the core mechanics and state of the maze adventure game.
 * It orchestrates player movements, room configurations, and gameplay progression.
 * 
 * This class provides methods to initialize the game, switch between players, and reset the game state.
 * 
 * @author Francesco Thomas, Abdul Wakil Zamani, Alex Besaw, Connor Broderick
 */

public class Game {
    private Player[] players;
    private Room[] rooms;
    private Player currentPlayer;

/**
 * Constructs a new instance of Game, initializing its configurations according to the map.
 */
    public Game() {
        // Populate rooms with specified attributes
        rooms = new Room[10];
        rooms[0] = new Room(1);
        rooms[1] = new RoomWithMachinePart(2, new Part(3));
        rooms[2] = new RoomWithMachinePart(3, new Part(1));
        rooms[3] = new Room(4);
        rooms[4] = new RoomWithMachinePart(5, new Part(2));
        rooms[5] = new RoomWithMachinePart(6, new Part(4));
        rooms[6] = new Room(7);
        rooms[7] = new RoomWithTools(8);
        rooms[8] = new Room(9);
        rooms[9] = new Workshop(10);

        // Establish connections between rooms
        try {
            setUpDoors();
        } catch (Exception e) {
            System.out.println("Error setting up doors: " + e.getMessage());
        }

        // Initialize players
        players = new Player[2];
        players[0] = new Player("Player 1", rooms[0]); // Start in room 1
        players[1] = new Player("Player 2", rooms[0]); // Start in room 1 as well
        currentPlayer = players[0];
    }

/**
 * Configures the doors between rooms according to the predefined map.
 * @throws Exception if inconsistencies are detected during setdoor function
 */
    private void setUpDoors() throws Exception {
        // Establish door connections based on the predefined map
        rooms[0].setDoor(Direction.up, rooms[3]);
        rooms[0].setDoor(Direction.left, rooms[8]);
        rooms[1].setDoor(Direction.up, rooms[4]);
        rooms[1].setDoor(Direction.down, rooms[7]);
        rooms[1].setDoor(Direction.right, rooms[9]);
        rooms[2].setDoor(Direction.down, rooms[8]);
        rooms[3].setDoor(Direction.down, rooms[0]);
        rooms[3].setDoor(Direction.right, rooms[4]);
        rooms[4].setDoor(Direction.down, rooms[1]);
        rooms[4].setDoor(Direction.right, rooms[5]);
        rooms[4].setDoor(Direction.left, rooms[3]);
        rooms[5].setDoor(Direction.down, rooms[9]);
        rooms[5].setDoor(Direction.left, rooms[4]);
        rooms[6].setDoor(Direction.up, rooms[8]);
        rooms[6].setDoor(Direction.right, rooms[7]);
        rooms[7].setDoor(Direction.up, rooms[1]);
        rooms[7].setDoor(Direction.left, rooms[6]);
        rooms[8].setDoor(Direction.up, rooms[2]);
        rooms[8].setDoor(Direction.down, rooms[6]);
        rooms[8].setDoor(Direction.right, rooms[0]);
        rooms[9].setDoor(Direction.up, rooms[5]);
        rooms[9].setDoor(Direction.left, rooms[1]);
    }

    /**
     * 'Getter' method for  currentPlayer.
     * @return who is the current player.
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Alternates between the two players.
     */
    public void switchPlayer() {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
    }

    /**
     * Initiates the game by moving players back to the start and clearing their inventory of collected items.
     */
    public void initGame() {
        // Put players back in starting room and reset their inventory
        for (Player player : players) {
            player.setCurrentRoom(rooms[0]);
            player.resetCollectedItems();
        }
        currentPlayer = players[0];
    }

	public Player[] getPlayers() {
        return players;
    }
}
