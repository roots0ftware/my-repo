package com.root.game.entities.creatures;

import com.root.game.entities.Entity;

public abstract class Creature extends Entity {
	
	public static final float DEFAULT_SPEED = 4.0f;
	public static final int DEFAULT_HEALTH = 10;
	public static final int CREATURE_WIDTH = 32;
	public static final int CREATURE_HEIGHT = 32;
	
	protected int health;
	protected int width, height;
	protected float speed;
	protected float xMove, yMove;
	
	public Creature(float x, float y) {
		super(x, y);
		speed = DEFAULT_SPEED;
		health = DEFAULT_HEALTH;
		width = CREATURE_WIDTH;
		height = CREATURE_HEIGHT;
	}
	
	public void move() {
		x += xMove;
		y += yMove;
	}
	
}
