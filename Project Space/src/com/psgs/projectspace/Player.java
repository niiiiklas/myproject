package com.psgs.projectspace;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.mod.niklas.engine.MODDrawable;
import com.mod.niklas.engine.MODFPoint;
import com.mod.niklas.engine.MODFillSquare;
import com.mod.niklas.engine.MODIPoint;
import com.mod.niklas.engine.MODUpdateable;

public class Player implements MODUpdateable, MODDrawable{

	static final float SPEED_X = 0.003f;
	static final float SPEED_DAMPER = 0.003f;
	
	MODFillSquare draw;
	Applet applet;
	float velx, vely;
	Controller cont;
	public Player(Applet applet)
	{
		velx = vely = 0;
		this.applet = applet;
		MODFPoint pos = new MODFPoint(SS.GAME_AREA_SIZE.width/2, SS.GAME_AREA_SIZE.height-100);
		MODIPoint size = new MODIPoint(50,50);
		draw = new MODFillSquare(pos, size, Color.BLUE);
		
		cont = new Controller();
		applet.addKeyListener(cont);
		
	}
	
	@Override
	public void update(long dt) {
		//Update pos.
		draw.pos.x += velx*dt;
		draw.pos.y += vely*dt;
		
		
		//Wall collision
		if(draw.pos.x <0)
		{
			draw.pos.x = 1;
			velx = 0;
		}
		if(draw.pos.x + 50 > SS.GAME_AREA_SIZE.width)
		{
			draw.pos.x = SS.GAME_AREA_SIZE.width-50;
			velx = 0;
		}
		
		//Update velocity
		if(cont.hori != 0)
			velx += (cont.hori * SPEED_X);
		else
		{
			if(velx >0)
				velx -= dt*SPEED_DAMPER;
			else
				velx +=dt*SPEED_DAMPER;
		}
		
	}
	@Override
	public void draw(Graphics g) {
		draw.draw(g);
		
	}
	public class Weapons{
		
		public Weapons()
		{
			
		}
	}
	
	public class Controller implements KeyListener{

		public int vert, hori;
		
		public Controller()
		{
			vert = hori = 0;
		}
		
		@Override
		public void keyPressed(KeyEvent ke) {
			if(ke.getKeyCode() == KeyEvent.VK_LEFT)
			{
				if(hori > -1)
					hori -=1;
			}
			if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				if(hori < 1)
					hori +=1;
			}
			
			
		}

		@Override
		public void keyReleased(KeyEvent ke) {
			if(ke.getKeyCode() == KeyEvent.VK_LEFT)
			{
				hori +=1;
			}
			if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				hori -=1;
			}
			
			if(ke.getKeyCode() == KeyEvent.VK_SPACE)
			{
				Shot shot = new Shot(applet, draw.pos);
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

	

}
