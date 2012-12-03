package com.mod.niklas.engine;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

/**
 * Simple animation class that  utilizes the POWER of the MODDrawable interface, and MODUpdateble to update.
 * This works by looping thorugh the added images by deltaTime from changeTime.
 * @author niklasandersson
 *
 */
public class MODAnimation implements MODDrawable, MODUpdateable{

	/**
	 * The default value if not specified.
	 */
	public static final long DEF_CHANGE_TIME = 200;
	
	public ArrayList<Image> images;	
	public MODFPoint pos;
	public long changeTime;
	
	private long lastChange;
	private int currImage;
	
	/**
	 * Helper constructor for initializing MODAnimation with MODFPoint 0,0 and changeTime DEF_CHANGE_TIME
	 * @param images list of Images.
	 */
	public MODAnimation(ArrayList<Image> images)
	{
		this(new MODFPoint(0,0), images, MODAnimation.DEF_CHANGE_TIME);
	}
	

	/**
	 * Main consturctor for initializing all that is necessary
	 * @param pos Position of this MODDrawable.
	 * @param images the images in order.
	 * @param changeTime the time between imagechanges in milliseconds.
	 */
	public MODAnimation(MODFPoint pos, ArrayList<Image> images, long changeTime)
	{
		this.pos = pos;
		this.images = images;
		this.changeTime = changeTime;
		lastChange = System.currentTimeMillis();
		currImage = 0;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(images.get(currImage), (int)pos.x, (int)pos.y, null);
	}

	@Override
	public void update(long dt) {
		//Update image
		if(lastChange + changeTime < System.currentTimeMillis())
		{
			currImage++;
			if(currImage >= images.size())
				currImage = 0;
			
			lastChange = System.currentTimeMillis();
		}
		
	}

}
