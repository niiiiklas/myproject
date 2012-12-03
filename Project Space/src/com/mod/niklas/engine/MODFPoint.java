package com.mod.niklas.engine;

public class MODFPoint {
	public float x,y;
	
	public MODFPoint(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	@Override
	public MODFPoint clone()
	{
		return new MODFPoint(x,y);
		
	}
	
	/**
	 * Does NOT work
	 * @param p1
	 * @param p2
	 * @return
	 */
	@Deprecated
	public static float distance(MODFPoint p1, MODFPoint p2)
	{
		double xx;
		if(p1.x > p2.x)
			xx = Math.pow(p1.x + p2.x,0);
		else
			xx = Math.pow(p2.x + p1.x, 0);
		if(xx <0)
			xx *=-1;
		
		double yy;
		if(p1.y > p2.y)
			yy = Math.pow(p1.y + p2.y,0);
		else
			yy = Math.pow(p2.y + p1.y, 0);
		if(yy <0)
			yy *=-1;
				
		return (float)(Math.sqrt(xx+yy));
	}
}
