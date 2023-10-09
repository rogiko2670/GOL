package game_of_life_02;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameOfLifeMain extends Application{
	
	// createScene -->
	private Parent createScene() {
		// Eine Vertikale Box
		 VBox root = new VBox(10);
		 root.setPrefSize(Konst.WIDTH, Konst.HEIGHT + 60);
		 Canvas canvas = new Canvas(Konst.WIDTH, Konst.HEIGHT);
		 GraphicsContext gc = canvas.getGraphicsContext2D();
		 
		 // Die Anzahl der Zeilen und Spalten des Grids
		 int rows = Math.floorDiv(Konst.WIDTH, Konst.CELL_SIZE);
		 int columns = Math.floorDiv(Konst.HEIGHT, Konst.CELL_SIZE);
		 
		 // Eine neues Spiel
		 Game game = new Game(rows, columns, gc);
		 // das Spiel initialisieren
		 game.gameInit();
		 
		 
		 root.getChildren().add(canvas);
		 return root;
	}

	// start -->
	@Override
	public void start(Stage stage) {
		stage.setScene(new Scene(createScene()));
		stage.setTitle("Game of life");
		stage.setResizable(false);
		stage.show();
	}
	
	// main -->
	public static void main(String[] args) {
		try {
			launch(args);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
}
