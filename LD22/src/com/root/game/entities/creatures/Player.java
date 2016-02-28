package com.root.game.entities.creatures;

import java.awt.Graphics;

import com.root.game.Game;
import com.root.game.gfx.Sprites;

public class Player extends Creature {
	
	private Game game;
	
	public Player(Game game, float x, float y) {
		super(x, y);
		this.game = game;
	}

	public void tick() {
		input();
		move();
	}
	
	private void input() {
		xMove = 0;
		yMove = 0;
		
		if (game.getKeyManager().down)
			yMove = speed;
	
		if (game.getKeyManager().up)
			yMove = -speed;
	
		if (game.getKeyManager().right)
			xMove = speed;
	
		if (game.getKeyManager().left)
			xMove = -speed;
	}

	public void render(Graphics g) {
		g.drawImage(Sprites.player, (int) x, (int) y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT, null);
	}
}
