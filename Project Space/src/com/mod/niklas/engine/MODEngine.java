package com.mod.niklas.engine;

import java.util.ArrayList;

public class MODEngine implements Runnable{
	
	/**
	 * The renderer to update
	 */
	private MODRenderer rend;
	
	/**
	 * stop the Thread, can't be used for pause, Use boolean paused instead.
	 */
	private boolean isRunning = true; 
	/**
	 * Pause the updating
	 */
	private boolean paused = false;
	
	/**
	 * The objects needing frequent updates
	 */
	private ArrayList<MODUpdateable> updates;
	
	/**
	 * last update, reference for deltaTime specifying.
	 */
	private long lastUpdate;
	
	
	/**
	 * Init Engine
	 * @param rend The renderer to update.
	 */
	public MODEngine(MODRenderer rend)
	{
		this.rend = rend;
		updates = new ArrayList<MODUpdateable>();
		lastUpdate = System.currentTimeMillis();
	}
	
	
	/**
	 * the Main-loop
	 */
	@Override
	public void run() {
		while(isRunning)
		{
			rend.repaint();
			update();
		}
	}
	
	
	/**
	 * the update method, Duh!?.
	 */
	private synchronized void update()
	{
		long dt = System.currentTimeMillis() - lastUpdate;
		lastUpdate = System.currentTimeMillis();
		
		if(paused)
			dt = 0;
			for(MODUpdateable up : updates)
			{
				up.update(dt);
			}
			try{
				Thread.sleep(1);
			}catch(InterruptedException ie){}
		
		System.out.println("SIZE: " + updates.size());
	}
	/**
	 * Register MODUpdateable to be updated frequently
	 * @param u
	 */
	public synchronized void registerUpdateable(MODUpdateable u)
	{
		updates.add(u);
	}
	
	public synchronized void unregisterUpdateable(MODUpdateable u)
	{
		updates.remove(u);
	}
	/**
	 * Pause the updateLoop
	 */
	public void pause()
	{
		paused = true;
	}
	
	/**
	 * Resume updateLoop, set lastUpdate to currTime.
	 */
	public void resume()
	{
		paused = false;
		lastUpdate = System.currentTimeMillis();
	}
}
