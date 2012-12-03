package com.mod.niklas.engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Paint;

/**
 * MODDrawable extension to draw a simple Filled square. Primarly used to debug and draw simple tests.
 * @author niklasandersson
 *
 */
public class MODFillSquare implements MODDrawable{
	public MODFPoint pos;
	public MODIPoint pSize;
	public Color color;
	public MODFillSquare(MODFPoint pPos, MODIPoint pSize, Color color)
	{
		this.pos = pPos;
		this.pSize = pSize;
		this.color = color;
	}
	
	
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect((int)pos.x, (int)pos.y, (int)pSize.x, (int)pSize.y);
	}
	
}
