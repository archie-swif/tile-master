package com.ryabokon.tiles;
public class Tile {

	int height;
	int width;
	String id;

	public Tile(int height, int width, String id) {
		super();
		this.height = height;
		this.width = width;
		this.id = id;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id;
	}

}
