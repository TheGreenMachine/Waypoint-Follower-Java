package com.edinarobotics.follower;

import com.edinarobotics.follower.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class Components {

	private static Components instance = new Components();

	public Drivetrain drivetrain;
	public Gyro gyro;
	
	// CAN Constants
			// Drivetrain Constants
			private static final int TOP_LEFT_CANTALON = 3;
			private static final int TOP_RIGHT_CANTALON = 7;
			private static final int MIDDLE_LEFT_CANTALON = 2;
			private static final int MIDDLE_RIGHT_CANTALON = 6;
			private static final int BOTTOM_LEFT_CANTALON = 1;
			private static final int BOTTOM_RIGHT_CANTALON = 5;
			// End Drivetrain Constants
			
	// End CAN Constants
	
	private Components() {

		drivetrain = new Drivetrain(TOP_LEFT_CANTALON, TOP_RIGHT_CANTALON, 
				MIDDLE_LEFT_CANTALON, MIDDLE_RIGHT_CANTALON, BOTTOM_LEFT_CANTALON, 
				BOTTOM_RIGHT_CANTALON);
		
		gyro = new ADXRS450_Gyro();
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
