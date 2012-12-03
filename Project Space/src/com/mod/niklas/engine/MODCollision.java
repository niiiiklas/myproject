package com.mod.niklas.engine;

public class MODCollision {
	
	/**
	 * Simple BoundingBox Collision detection between 2 MODFSquare
	 * @param s1
	 * @param s2
	 * @return true if BoundingBox intersects
	 */
	public static boolean intersectsBB(MODFSquare s1, MODFSquare s2)
	{
		 if(!((s1.x2) >= s2.x)){
			 return false;     
		 }
		 if (!(s1.x <= (s2.x2))){
			 return false;
		 }
		 if(!((s1.y2) <= s2.y)){
			 return false;
		 }
		 if (!(s1.y >= (s2.y2))){
			 return false;} 
		return true;
	}
	
	
	/**
	 * Collision Detection between CenterPixel of pixel and MODFSquare square.
	 * @param pixel
	 * @param square
	 * @return true if Intersects
	 */
	public static boolean intersectsPixelToBB(MODFSquare pixel, MODFSquare square)
	{
		float left = pixel.x + (pixel.x2-pixel.x);
		float top = pixel.y + (pixel.y2 - pixel.y);
		
		MODFSquare sqPixel = new MODFSquare(left, top, left+1, top+1);
		
		return intersectsBB(sqPixel, square);
	}
	
	
}
