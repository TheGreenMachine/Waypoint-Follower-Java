package com.edinarobotics.follower.trajectory.util;

import com.edinarobotics.utils.common.Updatable;

/**
 * Controller.java
 *
 * @author tombot
 */
public abstract class Controller implements Updatable {

    protected boolean enabled = false;

    public abstract void update();

    public abstract void reset();

    public abstract double getGoal();

    public void enable() {
        enabled = true;
    }

    public void disable() {
        enabled = false;
    }

    public boolean enabled() {
        return enabled;
    }

}
