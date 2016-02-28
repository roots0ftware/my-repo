package com.root.game.gfx;

import com.root.game.Game;
import com.root.game.entities.Entity;

public class Camera {
	
	private float xOffset, yOffset;
	
	public Camera(Game game, float xOffset, float yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
	}
	
	public void centerOnEntity(Entity e) {
		xOffset = e.getX() - (Game.WIDTH * Game.SCALE) / 2;
		yOffset = e.getY() - (Game.HEIGHT * Game.SCALE) / 2;
	}

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
}
