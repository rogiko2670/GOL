package game_of_life_02;

import java.util.concurrent.TimeUnit;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
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
		 
		 // Steuerelemente
		 Button init = new Button("Reset");
		 Button nextStep = new Button("Step");
		 Button start = new Button("Start");
		 Button stop = new Button("Stop");
		 
		 // Fuer die animation
		 AnimationTimer timer = new AnimationTimer() {		 
			long lastUpdate = 0;
			
			@Override
			public void handle(long now) {
				if(now - lastUpdate >= TimeUnit.MILLISECONDS.toNanos(500));
				lastUpdate = now;
				game.tig();
			}			 
		 };
		 
		 init.setOnAction(event -> {
			 game.gameInit();
		 });
		 nextStep.setOnAction(event -> {
			 game.tig();
		 });
		 start.setOnAction(event -> {
			 timer.start();
		 });
		 stop.setOnAction(evemt -> {
			 timer.stop();
		 });
		 
		 root.getChildren().addAll(canvas, (new HBox(10, init, nextStep, start, stop)));
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
