package org.usfirst.frc.team1306.robot;

import org.usfirst.frc.team1306.robot.commands.intake.IntakeBall;
import org.usfirst.frc.team1306.robot.commands.intake.SpitBall;
import org.usfirst.frc.team1306.robot.triggers.ControllerButton;
import org.usfirst.frc.team1306.robot.triggers.DPadDirection;
import org.usfirst.frc.team1306.robot.triggers.DPadPress;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * @OI
 * 
 * This class is the glue that binds the controls on the physical operator interface to the 
 * commands and command groups that allow control of the robot. It is also where commands 
 * can get joystick/trigger readings and set the rumble on the controller.
 * 
 * @author Jackson Goth 
 */
public class OI {

	//Declare primary and secondary xbox controllers
	private static XboxController primaryController = null;
	private static XboxController secondaryController = null;
	
	/**
	 * Initialized controllers + buttons, and binds commands to them
	 */
	public OI() {
		//Declare ports of xbox controllers
		primaryController = new XboxController(RobotMap.PRIMARY_PORT);
		secondaryController = new XboxController(RobotMap.SECONDARY_PORT);
		
		//Declares and maps buttons to xbox controller buttons for primary controller
		Button pbuttonA = new JoystickButton(primaryController, ControllerButton.A.value);
		Button pbuttonB = new JoystickButton(primaryController, ControllerButton.B.value);
		Button pbuttonX = new JoystickButton(primaryController, ControllerButton.X.value);
		Button pbuttonY = new JoystickButton(primaryController, ControllerButton.Y.value);
//		Button pbuttonRB = new JoystickButton(primaryController, ControllerButton.RB.value);
//		Button pbuttonLB = new JoystickButton(primaryController, ControllerButton.LB.value); 
		Button pbuttonStart = new JoystickButton(primaryController, ControllerButton.START.value);
		Button pbuttonBack = new JoystickButton(primaryController, ControllerButton.BACK.value);
		DPadPress primaryDPadUp = new DPadPress(primaryController, DPadDirection.UP);
		DPadPress primaryDPadRight = new DPadPress(primaryController, DPadDirection.RIGHT);
		DPadPress primaryDPadLeft = new DPadPress(primaryController, DPadDirection.LEFT);
		DPadPress primaryDPadDown = new DPadPress(primaryController, DPadDirection.DOWN);
		
		//Declares and maps buttons to xbox controller buttons for secondary controller
		Button sbuttonA = new JoystickButton(secondaryController, ControllerButton.A.value);
		Button sbuttonB = new JoystickButton(secondaryController, ControllerButton.B.value);
		Button sbuttonX = new JoystickButton(secondaryController, ControllerButton.X.value);
		Button sbuttonY = new JoystickButton(secondaryController, ControllerButton.Y.value);
		Button sbuttonRB = new JoystickButton(secondaryController, ControllerButton.RB.value);
		Button sbuttonLB = new JoystickButton(secondaryController, ControllerButton.LB.value);
		Button sbuttonStart = new JoystickButton(secondaryController, ControllerButton.START.value);
		Button sbuttonBack = new JoystickButton(secondaryController, ControllerButton.BACK.value);
		DPadPress secondaryDPadUp = new DPadPress(secondaryController, DPadDirection.UP);
		DPadPress secondaryDPadRight = new DPadPress(secondaryController, DPadDirection.RIGHT);
//		DPadPress secondaryDPadLeft = new DPadPress(secondaryController, DPadDirection.LEFT);
		DPadPress secondaryDPadDown = new DPadPress(secondaryController, DPadDirection.DOWN);

		// Bind input devices to commands
		pbuttonY.toggleWhenPressed(new IntakeBall());
		pbuttonX.whenPressed(new SpitBall());
	}

	public enum Controller {P,S}; //Controller (primary or secondary)
	public enum Joystick {L,R}; //Joystick (left or right)
	public enum Axis {X,Y}; //Joystick axis (x or y)
	
	public enum Trigger {L,R}; //Trigger (left or right)
	
	public enum Side {L,R}; //Side (left or right) (for rumble)
	
	/**
	 * Returns the joystick value (from -1.0 to 1.0) for a specified controller's joystick's axis (uses deadband)
	 */
	public static double getJoyVal(Controller c, Joystick j, Axis a) {
		
		XboxController controller;
		Hand side;
		
		if(c.equals(Controller.P)) { controller = primaryController; }
		else { controller = secondaryController; }
		if(j.equals(Joystick.L)) { side = Hand.kLeft; }
		else { side = Hand.kRight; }
		
		if(a.equals(Axis.X)) {
			return Math.pow(deadband(controller.getXAxis(side)),Constants.JOYSTICK_MULTIPLIER);
		} else {
			return Math.pow(deadband(controller.getYAxis(side)),Constants.JOYSTICK_MULTIPLIER);
		}
	}
	
	/**
	 * Returns the value of the specified trigger (from 0.0 to 1.0)
	 */
	public static double getTriggerVal(Controller c, Trigger t) {
		
		XboxController controller;
		if(c.equals(Controller.P)) { controller = primaryController; }
		else { controller = secondaryController; }
		
		if(t.equals(Trigger.L)) {
			return controller.getLT();
		} else {
			return controller.getRT();
		}
	}
	
	/**.
	 * Returns the value of a specified button on a specified controller
	 */
	public static boolean getButtonStatus(Controller c, ControllerButton b) {
		
		XboxController controller;
		if(c.equals(Controller.P)) { controller = primaryController; }
		else { controller = secondaryController; }
		
		return controller.getRawButton(b.value);
	}
	
	/**
	 * Sets the rumble of a specified controller to a specified amount of rumble
	 */
	public static void setRumble(Controller c, Side s, double rumbleness) {
		
		XboxController controller;
		if(c.equals(Controller.P)) { controller = primaryController; }
		else { controller = secondaryController; }
		
		if(s.equals(Side.L)) {
			controller.setRumble(GenericHID.RumbleType.kLeftRumble, rumbleness);
		} else {
			controller.setRumble(GenericHID.RumbleType.kRightRumble, rumbleness);
		}
	}
	
	/**
	 * Resets the rumble on the specified side of a specified controller
	 */
	public static void resetRumble(Controller c, Side s) {
		
		XboxController controller;
		if(c.equals(Controller.P)) { controller = primaryController; }
		else { controller = secondaryController; }
		
		if(s.equals(Side.L)) {
			controller.setRumble(GenericHID.RumbleType.kLeftRumble, 0);
		} else {
			controller.setRumble(GenericHID.RumbleType.kRightRumble, 0);
		}
	}
	
	/**
	 * Gets the intended velocity of the turret. This is controlled by the right
	 * joystick on the secondary controller only when targeting is manually
	 * overridden.
	 * 
	 * @return the overridden velocity of the turret.
	 */
	public double getTurretVel() {
		return deadband(secondaryController.getX(Hand.kRight));
	}

	/**
	 * Gets the intended velocity of the hood. This is controlled by the left
	 * joystick on the secondary controller only when targeting is manually
	 * overridden.
	 * 
	 * @return the overridden velocity of the hood.
	 */
	public double getHoodVel() {
		return deadband(secondaryController.getY(Hand.kLeft));
	}

	/**
	 * Gets whether the turret is overridden. The turret is overridden when the
	 * right trigger is pressed.
	 * 
	 * @return true if the turret should be manually overridden, otherwise
	 *         false.
	 */
	public boolean getTurretOverrride() {
		return secondaryController.getRT() > 0.5;
	}

	public boolean getHoodOverride() {
		return secondaryController.getLT() > 0.5;
	}
	
	/**
	 * Applies deadband to joystick values to prevent false readings when joystick is idle. It prevents 
	 * very small changes to an idle joystick to trigger anything.
	 */
	private static double deadband(double value) {
		if (value < -Constants.DEADBAND) {
			return (value + Constants.DEADBAND) / (1.0 - Constants.DEADBAND);
		} else if (value > Constants.DEADBAND) {
			return (value - Constants.DEADBAND) / (1.0 - Constants.DEADBAND);
		} else {
			return 0;
		}
	}
}
