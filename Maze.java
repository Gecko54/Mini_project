import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Maze extends Application {
    private Button[][] directions = new Button[2][4]; // 0-Up, 1-Down, 2-Left, 3-Right
    private Button[] collectPart = new Button[2];
    private Button[] collectTools = new Button[2];
    private Button[] buildMachine = new Button[2];
    private TextField[] playerMessages = new TextField[2];
    private Button restartButton = new Button("Restart");
    private Button[] help = new Button[2];
    private Game game;

    @Override
    public void start(Stage primaryStage) {
        game = new Game(); // Initializes the game
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
    
        setupControls();
        placeComponents(grid);
        setupEventHandlers();
        togglePlayerControls();
    
        Scene scene = new Scene(grid, 800, 400);
        primaryStage.setTitle("Maze");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void setupControls() {
        for (int i = 0; i < 2; i++) {
            directions[i][0] = new Button("Up");
            directions[i][1] = new Button("Down");
            directions[i][2] = new Button("Left");
            directions[i][3] = new Button("Right");
            collectPart[i] = new Button("Collect Part");
            collectTools[i] = new Button("Collect Tools");
            buildMachine[i] = new Button("Build Machine");
            playerMessages[i] = new TextField("Welcome to Room 1");
            playerMessages[i].setEditable(false);
            help[i] = new Button("Help! I am lost!!");
            for (Button button : directions[i]) {
                button.setPrefWidth(120);
            }
            collectPart[i].setPrefWidth(120);
            collectTools[i].setPrefWidth(120);
            buildMachine[i].setPrefWidth(120);
            playerMessages[i].setPrefWidth(360);
        }
        restartButton.setPrefWidth(120);
    }

    private void placeComponents(GridPane grid) {
        grid.add(new Label("PLAYER 1"), 2, 0, 2, 1);
        grid.add(new Label("PLAYER 2"), 7, 0, 2, 1);
        for (int i = 0; i < 2; i++) {
            int columnOffset = 5 * i;
            grid.add(directions[i][0], 2 + columnOffset, 1);
            grid.add(directions[i][2], 1 + columnOffset, 2);
            grid.add(directions[i][3], 3 + columnOffset, 2);
            grid.add(directions[i][1], 2 + columnOffset, 3);
            grid.add(collectPart[i], 1 + columnOffset, 4);
            grid.add(collectTools[i], 2 + columnOffset, 4);
            grid.add(buildMachine[i], 3 + columnOffset, 4);
            grid.add(playerMessages[i], 1 + columnOffset, 5, 3, 1);
            grid.add(help[i], 2 + columnOffset, 6);
        }
        grid.add(restartButton, 5, 7, 1, 1);
    }

    private void setupEventHandlers() {
        restartButton.setOnAction(e -> resetGame());
        for (int i = 0; i < 2; i++) {
            final int playerIndex = i;
            directions[i][0].setOnAction(e -> movePlayer(playerIndex, Direction.up));
            directions[i][1].setOnAction(e -> movePlayer(playerIndex, Direction.down));
            directions[i][2].setOnAction(e -> movePlayer(playerIndex, Direction.left));
            directions[i][3].setOnAction(e -> movePlayer(playerIndex, Direction.right));
            collectPart[i].setOnAction(e -> collectPart(playerIndex));
            collectTools[i].setOnAction(e -> collectTools(playerIndex));
            buildMachine[i].setOnAction(e -> buildMachine(playerIndex));
            help[i].setOnAction(e -> showHelp(playerIndex));
        }
    }

    private void movePlayer(int playerIndex, int direction) {
        String result = game.getCurrentPlayer().move(direction);
        playerMessages[playerIndex].setText(result);
        game.switchPlayer();
        togglePlayerControls();
    }

    private void collectPart(int playerIndex) {
        String result = game.getCurrentPlayer().collectPart();
        playerMessages[playerIndex].setText(result);
        game.switchPlayer();
        togglePlayerControls();
    }

    private void collectTools(int playerIndex) {
        String result = game.getCurrentPlayer().collectTools();
        playerMessages[playerIndex].setText(result);
        game.switchPlayer();
        togglePlayerControls();
    }

    private void buildMachine(int playerIndex) {
        String result = game.getCurrentPlayer().buildMachine();
        playerMessages[playerIndex].setText(result);
        if (result.contains("Win")) {
            disableAllControls();
        } else {
            game.switchPlayer();
            togglePlayerControls();
        }
    }

    private void showHelp(int playerIndex) {
        String result = game.getCurrentPlayer().getCurrentRoom().helpMessage();
        playerMessages[playerIndex].setText(result);
    }

    private void resetGame() {
        game.initGame();
        playerMessages[0].setText("Welcome to Room 1");
        playerMessages[1].setText("Welcome to Room 1");
        togglePlayerControls(); // Reset controls to reflect the initial player
    }

    private void togglePlayerControls() {
        int currentPlayerIndex = game.getCurrentPlayer() == game.getPlayers()[0] ? 0 : 1;
        for (int i = 0; i < 2; i++) {
            boolean disable = i != currentPlayerIndex;
            for (Button btn : directions[i]) {
                btn.setDisable(disable);
            }
            collectPart[i].setDisable(disable);
            collectTools[i].setDisable(disable);
            buildMachine[i].setDisable(disable);
            help[i].setDisable(disable);
        }
    }
    

    private void disableAllControls() {
        for (int i = 0; i < 2; i++) {
            for (Button btn : directions[i]) {
                btn.setDisable(true);
            }
            collectPart[i].setDisable(true);
            collectTools[i].setDisable(true);
            buildMachine[i].setDisable(true);
            help[i].setDisable(true);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
