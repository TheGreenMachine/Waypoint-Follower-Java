
package com.edinarobotics.follower;

import com.edinarobotics.follower.commands.AutonomousCommand;
import com.edinarobotics.follower.commands.AutonomousCommand.AutonomousMode;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class WaypointFollower extends IterativeRobot {

	private SendableChooser autoChooser;
	
	public void robotInit() {
		Controls.getInstance();
		Components.getInstance();
		
		setupDashboard();
	}

	public void autonomousInit() {
		if (autoChooser == null) {
			setupDashboard();
		}
		
		Command command = new AutonomousCommand((AutonomousMode) autoChooser.getSelected());
		command.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {

	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
	public void setupDashboard() {
		autoChooser = new SendableChooser();
		
		autoChooser.addDefault("Nothing", AutonomousMode.NOTHING);
		autoChooser.addObject("Simple", AutonomousMode.SIMPLE);
		
		SmartDashboard.putData("Autonomous Chooser", autoChooser);
	}

}
