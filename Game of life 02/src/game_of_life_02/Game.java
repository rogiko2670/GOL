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
	
	// getNaighbours -->
	private int getNaighbours(int row, int column) {
		int sum = 0;
		// Die Raender berücksichtigen und den Bereich um die Zelle vestlegen
		int startRow = row == 0 ? 0 : -1;
		int endRow = row == grid.length - 1 ? 0 : 1;
		int startColumn = column == 0 ? 0 : -1;
		int endColumn = column == grid[0].length -1 ? 0 : 1;
		 
		// Diesen Bereich untersuchen und lebende Zellen summieren
		for(int i = startRow; i <= endRow; i++) {
			for(int j = startColumn; j <= endColumn; j++) {
				sum += grid[i + row][j + column];
			}
		}
		// Der Zustand der Ausgangs Zelle darf nicht berücksichtigt werden
		return sum -= grid[row][column];
	}
	
	// tig -->
	public void tig() {
		// Der nächste Zyklus mus gespeichert werden
		int nextGrid[][] = new int[rows][columns];
		// Über das alte grid gehen und die neuen Zustände einer Zelle
		// auf Grund der Zustaende ihrer Nachbarn festlegen
		for(int row = 0; row < rows; row++) {
			for(int column = 0; column < columns; column++) {
				int sum = getNaighbours(row, column);
				if(sum == 3) {
					nextGrid[row][column] = 1;
				} else if (sum < 2 || sum > 3) {
					nextGrid[row][column] = 0;
				} else {
					nextGrid[row][column] = grid [row][column];
				}
			}
		}
		grid = nextGrid;
		draw();
	}
}