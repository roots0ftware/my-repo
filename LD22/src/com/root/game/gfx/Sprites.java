package com.root.game.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprites {
	
	public static final int SPRITE_WIDTH = 16, SPRITE_HEIGHT = 16;
	private static SpriteSheet sheet;
	public static BufferedImage grass, dirt, player;
	
	public static void init() {
		sheet = new SpriteSheet(load("/sheet.png"));
		
		grass = sheet.crop(0, 0, SPRITE_WIDTH, SPRITE_HEIGHT);
		dirt = sheet.crop(SPRITE_WIDTH, 0, SPRITE_WIDTH, SPRITE_HEIGHT);
		player = sheet.crop(SPRITE_WIDTH * 2, 0, SPRITE_WIDTH, SPRITE_HEIGHT);
	}
	
	private static BufferedImage load(String path) {
		try {
			return ImageIO.read(SpriteSheet.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
