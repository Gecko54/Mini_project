public class Game {
    private Player[] players;
    private Room[] rooms;
    private Player currentPlayer;

    /**
     * Constructor for the Game class.
     * Initializes rooms, players, and sets up the doors according to a predefined map.
     */
    public Game() {
        // Initialize rooms with specific characteristics
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

        // Set up doors between rooms
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
     * Sets up the doors between the rooms as described in the map.
     * @throws Exception if inconsistencies found by setDoor
     */
    private void setUpDoors() throws Exception {
        // Door setup example based on your code snippet above
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
     * Retrieves the current player.
     * @return the currently active player.
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Switches the current player between the two players.
     */
    public void switchPlayer() {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
    }

    /**
     * Initiates the game by setting up the initial configuration.
     */
    public void initGame() {
        // Reset player positions to start room, clear collected items
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
