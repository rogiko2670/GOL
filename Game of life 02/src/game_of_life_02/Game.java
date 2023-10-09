package game_of_life_02;

import java.util.Random;

import javafx.scene.canvas.GraphicsContext;

public class Game {

	// Instatnzen und Variablen
	private int rows, columns;
	private int[][] grid;
	private GraphicsContext gc;
	private Random random;
	
	// Konstruktor
	public Game (int rows, int columns, GraphicsContext gc) {
		this.rows = rows;
		this.columns = columns;
		this.gc = gc;
		random = new Random();
	}
	
	// gameInit -->
	public void gameInit() {
		// Das Grid erstellen auf dem die Zellen leben
		grid = new int[rows][columns];
		// Für Jede Zelle des grids einen Status erstellen
		// 1 die Zelle lebt
		// 0 die Zelle ist tot; 
		for(int row = 0; row < rows; row++) {
			for(int column = 0; column < columns; column++) {
				grid[row][column] = random.nextInt(2);
			}
		}
		draw();
	}
	
	// draw -->
	private void draw() {
		gc.setFill(Konst.HINTERGRUND);
		gc.fillRect(0, 0, Konst.WIDTH, Konst.HEIGHT);
		for(int row = 0; row < rows; row++) {
			for(int column = 0; column < columns; column++) {
				if(grid[row][column] == 1) {
					gc.setFill(Konst.GLOW);
					gc.fillRect(row * Konst.CELL_SIZE, column * Konst.CELL_SIZE, Konst.CELL_SIZE, Konst.CELL_SIZE);
					gc.setFill(Konst.SHADOW);
					gc.fillRect(row * Konst.CELL_SIZE + 1, column * Konst.CELL_SIZE + 1, Konst.CELL_SIZE - 1, Konst.CELL_SIZE - 1);
					gc.setFill(Konst.TILE);
					gc.fillRect(row * Konst.CELL_SIZE + 1, column * Konst.CELL_SIZE + 1, Konst.CELL_SIZE - 2, Konst.CELL_SIZE - 2);

				}
			}
		}
	}
	
	// tig -->
	public void tig() {
		
	}
}