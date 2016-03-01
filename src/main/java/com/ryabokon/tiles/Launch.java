package com.ryabokon.tiles;
import java.awt.image.BufferedImage;

public class Launch {

	public static void main(String[] args) throws Throwable {

		TileMaster master = new TileMaster();
		for (int i = 0; i < 100; i++) {
			Wall wall = master.arrangeTiles();
			BufferedImage image = ImageTools.getWallImage(wall, 100);
			ImageTools.saveImage(image);
		}

		Wall designerWall = new Wall(5, 17);
		designerWall.tiles = new String[][] {
				{ "T", "S", "T", "S", "W", "W", "S", "S", "W", "W", "S", "S", "T", "S", "S", "T", "T" },
				{ "T", "S", "T", "W", "W", "T", "W", "W", "W", "W", "S", "S", "T", "T", "S", "T", "T" },
				{ "T", "W", "W", "B", "B", "T", "S", "W", "W", "W", "W", "B", "B", "T", "S", "W", "W" },
				{ "T", "S", "T", "B", "B", "T", "B", "B", "S", "S", "S", "B", "B", "W", "W", "S", "T" },
				{ "W", "W", "T", "W", "W", "T", "B", "B", "W", "W", "S", "S", "S", "S", "W", "W", "T" } };
		BufferedImage image = ImageTools.getWallImage(designerWall, 100);
		ImageTools.saveImage(image, "design");
	}

}
