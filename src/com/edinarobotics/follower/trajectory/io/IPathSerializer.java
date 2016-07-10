package com.edinarobotics.follower.trajectory.io;


import com.edinarobotics.follower.trajectory.Path;

/**
 * Interface for methods that serialize a Path or Trajectory.
 *
 * @author Jared341
 */
public interface IPathSerializer {

    String serialize(Path path);

}
