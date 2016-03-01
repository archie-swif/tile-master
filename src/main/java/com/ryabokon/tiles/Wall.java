package com.ryabokon.tiles;
public class Wall {

	String[][] tiles;

	int height;
	int width;

	public Wall(int height, int width) {
		this.height = height;
		this.width = width;
		tiles = new String[height][width];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				tiles[i][j] = " ";
			}
		}
	}

	public boolean placeTileHere(Tile tile, int x, int y) {

		int tileHeigth = tile.getHeight();
		int tileWidth = tile.getWidth();

		if (x + tileHeigth > height || y + tileWidth > width) {
			return false;
		}

		for (int i = 0; i < tileHeigth; i++) {
			for (int j = 0; j < tileWidth; j++) {
				if (tiles[x + i][y + j] != " ") {
					return false;
				}
			}
		}

		for (int i = 0; i < tileHeigth; i++) {
			for (int j = 0; j < tileWidth; j++) {
				tiles[x + i][y + j] = tile.getId();
			}
		}
		return true;
	};

	public void printTiles() {
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[0].length; j++) {
				System.out.print(tiles[i][j] + " ");
			}
			System.out.print("\n");
		}
		System.out.println("--------------------------------------------------------------");
	}

}
