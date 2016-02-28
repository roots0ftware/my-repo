package com.root.game;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.root.game.assets.Assets;
import com.root.game.entities.creatures.Player;
import com.root.game.gfx.Camera;
import com.root.game.input.KeyManager;
import com.root.game.worlds.World;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 210;
	public static final int HEIGHT = WIDTH / 12 * 8;
	public static final int SCALE = 3;
	public static final String NAME = "Java Game";
	
	private boolean running = false;
	private Thread thread;
	private JFrame frame;
	
	private KeyManager keyManager;
	private Camera camera;
	private Player player;
	private World world;
	
	public KeyManager getKeyManager() { return keyManager; }
	public Camera getCamera() { return camera; }
	
	public Game() {
		setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		frame = new JFrame(NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setFocusable(false);
		frame.setResizable(false);
		frame.setVisible(true);
		
		keyManager = new KeyManager();
		
		addKeyListener(keyManager);
		
		Assets.init();
		camera = new Camera(this, 0, 0);
		world = new World(this, "");
		player = new Player(this, 0, 0);
		
		start();
	}
	
	public synchronized void start() {
		if (running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void tick() {
		keyManager.tick();
		world.tick();
		player.tick();
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		world.render(g);
		player.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double ns = 1000000000.0 / 60.0f;
		int ticks = 0;
		int frames = 0;
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while (delta >= 1) {
				ticks++;
				tick();
				delta--;
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			frames++;
			render();
			
			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				
				System.out.println("frames: " + frames + ", ticks: " + ticks);
				
				ticks = 0;
				frames = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		new Game();
	}
}
