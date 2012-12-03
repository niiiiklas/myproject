package com.psgs.projectspace;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

import com.mod.niklas.engine.MODDrawable;
import com.mod.niklas.engine.MODFPoint;
import com.mod.niklas.engine.MODFillSquare;
import com.mod.niklas.engine.MODIPoint;
import com.mod.niklas.engine.MODUpdateable;

public class Shot implements MODUpdateable, MODDrawable{
	
	static final float SPEED = -1f;
	
	private MODFillSquare draw;
	private float velx,vely;
	
	public Shot(Applet applet, MODFPoint startPos){
		velx = vely = 0;
		vely = SPEED;
		MODFPoint pos = startPos.clone();
		MODIPoint size = new MODIPoint(5,5);
		draw = new MODFillSquare(pos, size, Color.RED);
		
		Start.engine.registerUpdateable(this);
		Start.rend.addImageToLayer(this, 1);
	}
	
	@Override
	public void draw(Graphics g) {
		draw.draw(g);
		
	}

	@Override
	public void update(long dt) {
		draw.pos.y += dt*vely;
		
		if(draw.pos.y < 0)
			Start.engine.unregisterUpdateable(this);
			
		
	}

}
