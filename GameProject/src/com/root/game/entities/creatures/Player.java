package com.root.game.entities.creatures;

import java.awt.Graphics;

import com.root.game.Game;
import com.root.game.assets.Assets;

public class Player extends Creature {
	
	private Game game;
	
	public Player(Game game, float x, float y) {
		super(x, y);
		this.game = game;
	}

	public void tick() {
		getInput();
		move();
		game.getCamera().centerOnEntity(this);
	}
	
	private void getInput() {
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
		g.drawImage(Assets.player, (int) (x - game.getCamera().getxOffset()), (int) (y - game.getCamera().getyOffset()), Creature.CREATURE_WIDTH, Creature.CREATURE_HEIGHT, null);
	}

}
