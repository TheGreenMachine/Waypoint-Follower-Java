package com.edinarobotics.follower;

public class Components {

	private static Components instance = new Components();

	private Components() {

	}

	/**
	 * Returns the proper instance of Components. This method replaces our
	 * previous way to return a single instance of classes as it had the ability
	 * to create multiple instances if called within a constructor of something
	 * instantiated here.
	 *
	 * @return The current instance of Components.
	 */
	public static Components getInstance() {
		return instance;
	}

}
