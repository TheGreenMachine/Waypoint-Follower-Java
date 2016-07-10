package com.edinarobotics.follower.commands;

import com.edinarobotics.follower.trajectory.Path;
import edu.wpi.first.wpilibj.command.Command;

public class DrivePathCommand extends Command {

    private Path path;
    private double heading;

    public DrivePathCommand(Path path, double timeout) {
        this.path = path;
        setTimeout(timeout);
    }

    @Override
    protected void initialize() {
        System.out.println("Initiated DrivePathCommand");

    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
