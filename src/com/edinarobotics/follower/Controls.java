package com.edinarobotics.follower;

public class Controls {

	private static Controls instance = new Controls();

	private Controls() {

	}

	/**
	 * Returns the proper instance of Controls. This method replaces our
	 * previous way to return a single instance of classes as it had the ability
	 * to create multiple instances if called within a constructor of something
	 * instantiated here.
	 *
	 * @return The current instance of Controls.
	 */
	public static Controls getInstance() {
		return instance;
	}

}
