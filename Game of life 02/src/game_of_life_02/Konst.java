package game_of_life_02;

import javafx.scene.paint.Color;

/**
 * Farben und Groessen
 */
public class Konst {

	// Farben -->
	public static Color HINTERGRUND = new Color((double) 1 / 256 * 165, (double) 1 / 256 * 140, (double) 1 / 256 * 39, 1.0D);
	public static Color GLOW = new Color((double) 1 / 256 * 239, (double) 1 / 256 * 216, (double) 1 / 256 * 161, 1.0D);
	public static Color SHADOW = new Color((double) 1 / 256 * 171, (double) 1 / 256 * 92, (double) 1 / 256 * 28, 1.0D);
	public static Color TILE = new Color((double) 1 / 256 * 239, (double) 1 / 256 * 172, (double) 1 / 256 * 40, 1.0D);

	// Groessen
	public static final int WIDTH = 700;
	public static final int HEIGHT = 700;
	public static final int CELL_SIZE = 10;

}
