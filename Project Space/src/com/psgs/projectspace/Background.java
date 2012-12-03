package com.psgs.projectspace;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import com.mod.niklas.engine.MODDrawable;
import com.mod.niklas.engine.MODFPoint;
import com.mod.niklas.engine.MODFillSquare;
import com.mod.niklas.engine.MODIPoint;
import com.mod.niklas.engine.MODUpdateable;

public class Background implements MODDrawable, MODUpdateable{
	
	static final int STAR_COUNT = 50;
	static final float STAR_MAX_SPEED_X = 0.1f;
	static final float STAR_MAX_SPEED_Y = 0.5f;
	static final float STAR_MIN_SPEED_Y = 0.4f;
	static final int STAR_MAX_SIZE = 10;
	//Be changed to MODSimpleImage or MODAnimation later
	private ArrayList<Star> arrStars;
	private MODFillSquare drawBack;
	
	public Background(Applet applet)
	{
		initStars();
		drawBack = new MODFillSquare(new MODFPoint(0,0),
				new MODIPoint(SS.GAME_AREA_SIZE.width, SS.GAME_AREA_SIZE.height),
				Color.BLACK);
		
		
	}
	private void initStars()
	{
		arrStars = new ArrayList<Star>();
		
		for(int i = 0; i < STAR_COUNT;i++)
		{
			Star star = new Star();
			arrStars.add(star);
		}
	}
	
	@Override
	public void draw(Graphics g) {
		//Draw background IMAGE
		drawBack.draw(g);
		
		//Draw Stars
		for(Star s :arrStars)
			s.draw.draw(g);
		
	}
	


	@Override
	public void update(long dt) {
		System.out.println("HEJ! dt: " + dt);
		for(Star s: arrStars)
			s.update(dt);
		
		
	}
	class Star implements MODUpdateable{
		MODFillSquare draw;
		float velx, vely;
		
		public Star()
		{
			velx = vely = 0;
			Dimension s = SS.GAME_AREA_SIZE;
			MODFPoint pos = new MODFPoint((float)(Math.random()*s.width), (float)(Math.random()*s.height));
			MODIPoint size = new MODIPoint(2+(int)(Math.random()*10), 2+(int)(Math.random()*10));
			draw = new MODFillSquare(pos, size, Color.YELLOW);
			
			firstTimePos();
		}
		
		private void firstTimePos()
		{
			reset();
			draw.pos.y = (float)(Math.random()*SS.GAME_AREA_SIZE.height);
		}
		
		public void reset()
		{
			velx = -(STAR_MAX_SPEED_X/2);
			velx += (float) (Math.random()*STAR_MAX_SPEED_X);
			vely = STAR_MIN_SPEED_Y + (float) (Math.random()*STAR_MAX_SPEED_Y);
			
			draw.pos.y = (draw.pSize.y * -1);
			draw.pos.x = (float) (SS.GAME_AREA_SIZE.width * Math.random());
		}
		@Override
		public void update(long dt) {
			draw.pos.x += dt*velx;
			draw.pos.y += dt*vely;
			
			if(draw.pos.y > SS.GAME_AREA_SIZE.height)
				reset();
		}
		
	}
}
