package com.edinarobotics.follower.commands;

import com.edinarobotics.follower.Components;
import com.edinarobotics.follower.subsystems.Drivetrain;
import com.edinarobotics.utils.gamepad.Gamepad;

import edu.wpi.first.wpilibj.command.Command;

public class GamepadDriveCommand extends Command {

	private Drivetrain drivetrain;
	private Gamepad gamepad;
	
	public GamepadDriveCommand(Gamepad gamepad) {
		super("gamepaddrivecommand");
		this.gamepad = gamepad;
		drivetrain = Components.getInstance().drivetrain;
		requires(drivetrain);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		double verticalStrafe = gamepad.getLeftY();
		double rotation = gamepad.getRightX();
		
		drivetrain.setDrivetrain(verticalStrafe, rotation);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		drivetrain.setDrivetrain(0.0, 0.0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
