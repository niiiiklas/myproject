package com.mod.niklas.engine;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MODRenderer extends JPanel{

	/*
	 * 
	 * Layered Renderer rendering Images in different layers. 
	 * Using a SpriteInterface for animations and other
	 *  
	 * 
	 */
	
	private ArrayList<MODDrawable> objectsLayer0;
	private ArrayList<MODDrawable> objectsLayer1;
	private ArrayList<MODDrawable> objectsLayer2;
	
	Dimension offDimension;
	Graphics offGraphics;
	Image offImage;
	
	
	public MODRenderer(Dimension d)
	{
		objectsLayer0 = new ArrayList<MODDrawable>();
		objectsLayer1 = new ArrayList<MODDrawable>();
		objectsLayer2 = new ArrayList<MODDrawable>();
		
		//Init double buffer wizardry! :P
		offDimension = d;
	}
	
	public void addImageToLayer(MODDrawable d , int layer)
	{
		switch(layer){
		case 0:
			objectsLayer0.add(d);
		break;
		case 1:
			objectsLayer1.add(d);
		break;
		case 2:
			objectsLayer2.add(d);
		break;
		}
	}
	
	
	@Override
	public void paint(Graphics g)
	{
		if(offGraphics == null)
		{
		    offImage = createImage(offDimension.width, offDimension.height);
		    offGraphics = offImage.getGraphics();
		}
		
		//Render 0 first 1 second and finish with top layer 2
		for(MODDrawable d : objectsLayer0)
			d.draw(offGraphics);
		
		for(MODDrawable d : objectsLayer1)
			d.draw(offGraphics);
		
		for(MODDrawable d : objectsLayer2)
			d.draw(offGraphics);
		
		g.drawImage(offImage, 0, 0, null);
	}
}
