package org.usfirst.frc.team1306.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * @XboxController
 * 
 * An Xbox controller. This is a relatively minor extension of Joystick that adds methods specific to the xbox-controller.
 * 
 * @author Finn Voichick
 */
public class XboxController extends Joystick {

	/** Creates a new joystick using the ports seen on the driver-station */
	public XboxController(int port) {
		super(port);
	}

	/** Returns the joystick's x-axis value of either the left or right joystick */
	public double getXAxis(Hand hand) {
		if (hand.equals(Hand.kLeft)) { return getRawAxis(0); } 
		else { return getRawAxis(4); }
	}

	/** Returns the joystick's y-axis value of either the left or right joystick */
	public double getYAxis(Hand hand) {
		if (hand.equals(Hand.kLeft)) { return -getRawAxis(1); } 
		else { return -getRawAxis(5); }
	}

	/** Returns how far the left trigger is pressed down from 0.0 to 1.0. */
	public double getLT() {
		return getRawAxis(2);
	}

	/** Returns how far the right trigger is pressed down from 0.0 to 1.0. */
	public double getRT() {
		return getRawAxis(3);
	}

	/** Returns current angle of d-pad button in degrees (in 45 degree increments) or -1 if not pressed. */
	@Override
	public int getPOV() {
		return super.getPOV();
	}
	
}
