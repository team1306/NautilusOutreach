package org.usfirst.frc.team1306.lib.util;

/**
 * @PathParams
 * 
 * Parameters the 2D motion profiling generater uses, max time, how much time in-between each
 * new segment of the profile, and how much space is in-between the wheels.
 * 
 * @author Jackson Goth
 */
public class PathParams {

	public double time, timeInterval, robotTrackWidth;
	
	public PathParams(double time, double timeInterval, double robotTrackWidth) {
		this.time = time;
		this.timeInterval = timeInterval;
		this.robotTrackWidth = robotTrackWidth;
	}
}
