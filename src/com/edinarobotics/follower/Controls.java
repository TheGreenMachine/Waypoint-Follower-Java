package com.edinarobotics.follower;

import java.util.ArrayList;
import java.util.List;

import com.edinarobotics.utils.gamepad.FilteredGamepad;
import com.edinarobotics.utils.gamepad.Gamepad;
import com.edinarobotics.utils.gamepad.gamepadfilters.DeadzoneFilter;
import com.edinarobotics.utils.gamepad.gamepadfilters.GamepadFilter;
import com.edinarobotics.utils.gamepad.gamepadfilters.GamepadFilterSet;
import com.edinarobotics.utils.gamepad.gamepadfilters.PowerFilter;

public class Controls {

	private static Controls instance = new Controls();

	public final Gamepad gamepad;
	
	private Controls() {

		List<GamepadFilter> gamepadFilter = new ArrayList<GamepadFilter>();
		gamepadFilter.add(new DeadzoneFilter(0.05));
		gamepadFilter.add(new PowerFilter(1));
		GamepadFilterSet gamepadFilterSet = new GamepadFilterSet(gamepadFilter);
		
		gamepad = new FilteredGamepad(0, gamepadFilterSet);
		
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
