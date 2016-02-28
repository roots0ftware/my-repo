package com.root.game.entities.creatures;

import com.root.game.entities.Entity;

public abstract class Creature extends Entity {
	
	public static final int DEFAULT_CREATURE_WIDTH = 32;
	public static final int DEFAULT_CREATURE_HEIGHT = 32;
	public static final int DEFAULT_CREATURE_HEALTH = 10;
	public static final float DEFAULT_CREATURE_SPEED = 3.0f;
	
	protected int width;
	protected int height;
	protected int health;
	protected float speed;
	protected float xMove, yMove;
	
	public Creature(float x, float y) {
		super(x, y);
		
		width = DEFAULT_CREATURE_WIDTH;
		height = DEFAULT_CREATURE_HEIGHT;
		health = DEFAULT_CREATURE_HEALTH;
		speed = DEFAULT_CREATURE_SPEED;
	}
	
	public void move() {
		x += xMove;
		y += yMove;
	}
	
}
