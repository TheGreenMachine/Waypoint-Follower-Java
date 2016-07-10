package com.edinarobotics.follower.trajectory.io;


import com.edinarobotics.follower.trajectory.Path;

/**
 * Interface for methods that deserializes a Path or Trajectory.
 *
 * @author Jared341
 */
public interface IPathDeserializer {

    Path deserialize(String serialized);

}
