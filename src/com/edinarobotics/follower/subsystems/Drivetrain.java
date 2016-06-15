package com.edinarobotics.follower.subsystems;

import com.edinarobotics.utils.controllers.SpeedControllerWrapper;
import com.edinarobotics.utils.subsystems.Subsystem1816;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;

public class Drivetrain extends Subsystem1816 {

	private RobotDrive robotDrive;

	private SpeedControllerWrapper leftSide, rightSide;
	private CANTalon topLeft, topRight, middleLeft, middleRight, bottomLeft, bottomRight;

	private double verticalStrafe, rotation;

	public Drivetrain(int topLeft, int topRight, int middleLeft, int middleRight, 
			int bottomLeft, int bottomRight) {

		this.topLeft = new CANTalon(topLeft);
		this.topRight = new CANTalon(topRight);
		this.middleLeft = new CANTalon(middleLeft);
		this.middleRight = new CANTalon(middleRight);
		this.bottomLeft = new CANTalon(bottomLeft);
		this.bottomRight = new CANTalon(bottomRight);

		this.middleLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		this.middleRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);

		this.middleLeft.configEncoderCodesPerRev(256);
		this.middleRight.configEncoderCodesPerRev(256);

		leftSide = new SpeedControllerWrapper(this.topLeft, this.middleLeft, this.bottomLeft);
		rightSide = new SpeedControllerWrapper(this.topRight, this.middleRight, this.bottomRight);

		leftSide.setInverted(true);

		robotDrive = new RobotDrive(leftSide, rightSide);

	}

	@Override
	public void update() {
		robotDrive.arcadeDrive(verticalStrafe, rotation);
	}

	public void setDefaultCommand(Command command) {
		if (getDefaultCommand() != null) {
			super.getDefaultCommand().cancel();
		}

		super.setDefaultCommand(command);
	}

	public void setDrivetrain(double verticalStrafe, double rotation) {
		this.verticalStrafe = verticalStrafe;
		this.rotation = rotation;
		update();
	}

	public void setMotors(double leftSide, double rightSide) {
		robotDrive.setLeftRightMotorOutputs(leftSide, rightSide);
	}

	public void setRotation(double rotation) {
		this.rotation = rotation;
		update();
	}

	public void setVerticalStrafe(double verticalStrafe) {
		this.verticalStrafe = verticalStrafe;
		update();
	}
	
	public CANTalon getMiddleLeftCANTalon() {
		return middleLeft;
	}
	
	public CANTalon getMiddleRightCANTalon() {
		return middleRight;
	}

}
