package com.root.game.assets;

import java.awt.image.BufferedImage;

import com.root.game.gfx.ImageLoader;
import com.root.game.gfx.SpriteSheet;

public class Assets {
	
	public static final int SPRITE_WIDTH = 32, SPRITE_HEIGHT = 32;
	private static SpriteSheet sheet;
	public static BufferedImage grass, dirt, water, player;
	
	public static void init() {
		sheet = new SpriteSheet(ImageLoader.load("/spritesheet.png"));
		
		grass = sheet.crop(0, 0, SPRITE_WIDTH, SPRITE_HEIGHT);
		dirt = sheet.crop(SPRITE_WIDTH, 0, SPRITE_WIDTH, SPRITE_HEIGHT);
		water = sheet.crop(SPRITE_WIDTH * 2, 0, SPRITE_WIDTH, SPRITE_HEIGHT);
		player = sheet.crop(SPRITE_WIDTH * 3, 0, SPRITE_WIDTH, SPRITE_HEIGHT);
	}
}
