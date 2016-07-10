package com.edinarobotics.follower.auto;

import com.edinarobotics.follower.trajectory.Path;
import com.edinarobotics.follower.trajectory.PathGenerator;
import com.edinarobotics.follower.trajectory.TrajectoryGenerator;
import com.edinarobotics.follower.trajectory.WaypointSequence;

public class AutoPath {

    private static TrajectoryGenerator.Config config = new TrajectoryGenerator.Config();

    private static int wheelbaseWidth = 16;

    public static Path getSamplePath() {
        WaypointSequence p = new WaypointSequence(10);
        p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
        p.addWaypoint(new WaypointSequence.Waypoint(7.0, 0, 0));
        p.addWaypoint(new WaypointSequence.Waypoint(14.0, 1.0, Math.PI / 12.0));

        Path path = PathGenerator.makePath(p, config,
                wheelbaseWidth, "SamplePath");

        return path;
    }

}
