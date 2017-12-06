package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This Subsystem controls only the rollers on the intake arm, not the intake
 * arm itself. It has methods for bringing balls in and out of the robot.
 */
public class Intake extends Subsystem {

	Talon frontMotor;
	Talon backMotor;
	
	public Intake() {
		frontMotor = new Talon(RobotMap.INTAKE_ROLLER_1_PORT);
		backMotor = new Talon(RobotMap.INTAKE_ROLLER_2_PORT);
	}
	/**
	 * This method spin the intake forward and into the robot at positive 50% for the
	 * front intake motor and negative 50% for the inner or back intake motors to 
	 * bring the ball into the shooter motors.
	 */
	public void spinInward() {
		frontMotor.set(0.5);
		backMotor.set(-0.5);
	}
	/**
	 * This method does the opposite of spinInward and spits the ball outward at 50%
	 * power
	 */
	public void spinOutward() {
		frontMotor.set(-0.5);
		backMotor.set(0.5);
	}
	/**
	 * This method stops both front and back motor from spinning
	 */
	public void stop() {
		frontMotor.set(0);
		backMotor.set(0);
		
	}
	
	@Override
	public void initDefaultCommand() { }
}
