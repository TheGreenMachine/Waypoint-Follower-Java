package com.edinarobotics.follower.commands;

import com.edinarobotics.follower.Components;
import com.edinarobotics.follower.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

public class DriveToWaypointCommand extends Command {

	private Drivetrain drivetrain;
	private Waypoint[] waypoint;
	private TankModifier modifier;
	private EncoderFollower left, right;

	private Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC,
			Trajectory.Config.SAMPLES_HIGH, 0.05, 1.7, 2.0, 60.0);
	private Trajectory trajectory;

	private final int WHEEL_DIAMETER = 5;
	private final int MAX_VELOCITY = 9;

	public DriveToWaypointCommand(Waypoint waypoint) {
		super("drivetowaypointcommand");
		drivetrain = Components.getInstance().drivetrain;
		this.waypoint = new Waypoint[1];
		this.waypoint[0] = waypoint;
		requires(drivetrain);
	}

	@Override
	protected void initialize() {
		trajectory = Pathfinder.generate(waypoint, config);
		modifier = new TankModifier(trajectory).modify(0.5);

		left = new EncoderFollower(modifier.getLeftTrajectory());
		right = new EncoderFollower(modifier.getRightTrajectory());

		left.configureEncoder(drivetrain.getMiddleLeftCANTalon().getEncPosition(), 1000, WHEEL_DIAMETER);
		left.configurePIDVA(1.0, 0.0, 0.0, 1 / MAX_VELOCITY, 0);

		right.configureEncoder(drivetrain.getMiddleRightCANTalon().getEncPosition(), 1000, WHEEL_DIAMETER);
		right.configurePIDVA(1.0, 0.0, 0.0, 1 / MAX_VELOCITY, 0);
	}

	@Override
	protected void execute() {

		double leftPower = left.calculate(drivetrain.getMiddleLeftCANTalon().getEncPosition());
		double rightPower = right.calculate(drivetrain.getMiddleRightCANTalon().getEncPosition());

		double gyroHeading = Components.getInstance().gyro.getAngle();
		double desiredHeading = Pathfinder.r2d(left.getHeading());

		double angleDifference = Pathfinder.boundHalfDegrees(desiredHeading - gyroHeading);
		double turn = 0.8 * (-1.0 / 80.0) * angleDifference;

		drivetrain.setMotors(leftPower + turn, rightPower - turn);
	}

	@Override
	protected boolean isFinished() {
		return left.isFinished() && right.isFinished();
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
