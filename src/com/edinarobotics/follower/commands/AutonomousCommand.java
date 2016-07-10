package com.edinarobotics.follower.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommand extends CommandGroup {

	public AutonomousCommand(AutonomousMode autoMode) {

		switch (autoMode) {

			case SIMPLE:
	
				break;
	
			case NOTHING:
	
				break;
	
			default:
	
				break;
		}

	}

	public enum AutonomousMode {
		SIMPLE, NOTHING;
	}

}
