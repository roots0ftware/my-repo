package com.root.game.worlds;

import java.awt.Graphics;

import com.root.game.Game;
import com.root.game.tiles.Tile;

public class World {
	
	private int width, height; //In terms of tiles
	private int[][] tiles;
	private Game game;
	
	public World(Game game, String path) {
		loadWorld(path);
		this.game = game;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				getTile(x, y).render(g, (int) (x * Tile.TILE_WIDTH - game.getCamera().getxOffset()), (int) (y * Tile.TILE_HEIGHT - game.getCamera().getyOffset()));
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null) {
			return Tile.dirtTile; //return a default tile
		}
		
		return t;
	}
	
	private void loadWorld(String path) {
		width = 40;
		height = 40;

		tiles = new int[width][height];
		
		for (int x = 0; x < width; x++) {
			if (x % 2 == 0) {
				for (int y = 0; y < height; y++) {
					tiles[x][y] = 1;
				}
			}
		}
	}
	
}
