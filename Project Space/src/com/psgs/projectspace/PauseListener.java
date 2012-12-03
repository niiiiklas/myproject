package com.psgs.projectspace;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.mod.niklas.engine.MODEngine;

public class PauseListener implements KeyListener{

	private MODEngine engine;
	public PauseListener(MODEngine engine)
	{
		this.engine = engine;
	}
	
	@Override
	public void keyPressed(KeyEvent ke) {
		if(ke.getKeyCode() == KeyEvent.VK_P)
		{
			engine.pause();
		}
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		if(ke.getKeyCode() == KeyEvent.VK_P)
		{
			engine.resume();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent ke) {
		
	}

}
