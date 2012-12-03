package com.mod.niklas.engine;

import java.applet.Applet;
import java.awt.Image;
import java.awt.MediaTracker;
import java.net.URL;

/**
 * Simple helper for Initializing and tracking loading of Images
 * @author niklasandersson
 *
 */
public class MODImageUtil {
	
	private Applet applet;
	private URL codeBase;
	private MediaTracker tracker;
	
	/**
	 * Initialize all resources for this instance. Such as CodeBase URL and MediaTracker
	 * @param applet
	 */
	public MODImageUtil(Applet applet)
	{
		this.applet = applet;
		codeBase = applet.getCodeBase();
		tracker = new MediaTracker(applet);
	}
	
	/**
	 * Fetch Image from directory using default codeBase. 
	 * Also adds image to this MediaTracker.
	 * @param dir
	 * @return the Image, perhaps not already loaded.
	 */
	public Image getImageFromDir(String dir)
	{
		Image img = applet.getImage(codeBase, dir);
		tracker.addImage(img, 0);
		return img;
	}
	
	/**
	 * A check that indicates images loaded.
	 * @return true if ALL images are loaded, or something went horribly wrong. false if loading is in progress.
	 */
	public boolean isImagesLoaded()
	{
		return tracker.checkAll();
	}
	
}
