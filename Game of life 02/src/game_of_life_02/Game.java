package game_of_life_02;

import javafx.scene.canvas.GraphicsContext;

public class Game {

	// Instatnzen und Variablen
	private int rows, columns;
	private int[][] grid;
	private GraphicsContext gc;
	
	// Konstruktor
	public Game (int rows, int columns, GraphicsContext gc) {
		this.rows = rows;
		this.columns = columns;
		this.gc = gc;
	}
	
	// gameInit -->
	public void gameInit() {
		
	}
}