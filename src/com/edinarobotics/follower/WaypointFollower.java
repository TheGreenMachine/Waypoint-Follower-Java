
package com.edinarobotics.follower;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class WaypointFollower extends IterativeRobot {

    public void robotInit() {
		
    }

    public void autonomousInit() {
        
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

}
