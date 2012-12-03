package com.psgs.projectspace;

import java.applet.Applet;
import java.awt.BorderLayout;

import com.mod.niklas.engine.MODEngine;
import com.mod.niklas.engine.MODRenderer;

public class Start extends Applet{
	
	static MODRenderer rend;
	static MODEngine engine;
	
	@Override
	public void init()
	{
		this.setSize(SS.GAME_AREA_SIZE);
		
		rend = new MODRenderer(SS.GAME_AREA_SIZE);
		engine = new MODEngine(rend);
		Background back = new Background(this);
		rend.addImageToLayer(back, 0);
		engine.registerUpdateable(back);
		
		this.setLayout(new BorderLayout());
		this.add(rend, BorderLayout.CENTER);
		
		Player player = new Player(this);
		rend.addImageToLayer(player, 1);
		engine.registerUpdateable(player);
		
		PauseListener pause = new PauseListener(engine);
		this.addKeyListener(pause);
		
		new Thread(engine).start();
	}
}
