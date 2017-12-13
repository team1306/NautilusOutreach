package org.usfirst.frc.team1306.lib.util;

/**
 * @ProfileParams
 *
 * Max velocity, acceleration, and jerk values to be used when creating 1D paths
 * 
 * @author Jackson Goth
 */
public class ProfileParams {

	public double velocity, acceleration, jerk;
	
	public ProfileParams(double v, double a, double j) {
		velocity = v;
		acceleration = a;
		jerk = j;
	}
}
