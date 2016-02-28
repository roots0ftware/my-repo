package com.root.game.tiles;

import java.awt.image.BufferedImage;

public class Tile {
	
	protected BufferedImage texture;
	protected int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
	}
	
}
