package com.mod.niklas.engine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class MODSimpleImage implements MODDrawable{

	Image i;
	MODFPoint p;
	
	public MODSimpleImage(Image i, MODFPoint p)
	{
		this.i = i;
		this.p = p;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(i, (int)p.x, (int)p.y, null);
	}

}
