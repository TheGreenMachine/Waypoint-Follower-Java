package com.edinarobotics.follower.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Waypoint;

public class AutonomousCommand extends CommandGroup {

	public AutonomousCommand(AutonomousMode autoMode) {

		switch (autoMode) {

			case SIMPLE:
	
				addSequential(new DriveToWaypointCommand(new Waypoint(-4, -1, 0)));
				addSequential(new DriveToWaypointCommand(new Waypoint(-2, -1, Pathfinder.d2r(-45))));
				addSequential(new DriveToWaypointCommand(new Waypoint(-4, -1, Pathfinder.d2r(45))));
	
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
