package com.root.game.tiles;

import com.root.game.assets.Assets;

public class WaterTile extends Tile {

	public WaterTile(int id) {
		super(Assets.water, id);
	}
	
	public boolean isSolid() {
		return true;
	}
	
}
