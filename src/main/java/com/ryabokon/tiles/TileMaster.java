package com.ryabokon.tiles;
import java.util.LinkedList;

import org.apache.commons.lang3.RandomUtils;

public class TileMaster {

	LinkedList<Tile> tiles;
	Wall wall;

	public Wall arrangeTiles() {

		int height = 5;
		int width = 17;

		tiles = new LinkedList<>();
		wall = new Wall(height, width);

		Tile small = new Tile(1, 1, "S");
		Tile tall = new Tile(2, 1, "T");
		Tile wide = new Tile(1, 2, "W");
		Tile big = new Tile(2, 2, "B");

		//addTiles(big, 3);
		addTiles(tall, 15);
		addTiles(wide, 15);
		//addTiles(small, 40);

		while (!tiles.isEmpty()) {
			int retries = 0;
			Tile tile = tiles.removeFirst();
			boolean result = false;
			while (!result && retries < 10000) {
				int x = RandomUtils.nextInt(0, height);
				int y = RandomUtils.nextInt(0, width);
				result = wall.placeTileHere(tile, x, y);
				retries++;
			}
			wall.printTiles();
		}

		return wall;

	}

	private void addTiles(Tile tile, int amount) {
		for (int i = 0; i < amount; i++) {
			tiles.add(tile);
		}
	}
}
