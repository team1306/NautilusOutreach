package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @Intake
 * 
 * Subsystem that controls our intake mechanism which we use to take in and spit out boulders,
 * from the robot. All methods in this subsystem are used to accomplish those tasks.
 * 
 * @author Ethan Dong and Jackson Goth
 */
public class Intake extends Subsystem {

	private Talon intakeMotor; //Front motor spinning mechanums
	private Talon indexerMotor; //Back motor spinning indexer wheels
	
	public Intake() {
		intakeMotor = new Talon(RobotMap.INTAKE_TALON_PORT);
		indexerMotor = new Talon(RobotMap.INDEXER_TALON_PORT);
	}
	/**
	 * This method spin the intake forward and into the robot at positive 50% for the
	 * front intake motor and negative 50% for the inner or back intake motors to 
	 * bring the ball into the shooter motors.
	 */
	public void spinInward() {
		intakeMotor.set(0.5);
		indexerMotor.set(-0.5);
	}
	/**
	 * This method does the opposite of spinInward and spits the ball outward at 50%
	 * power
	 */
	public void spinOutward() {
		intakeMotor.set(-0.5);
		indexerMotor.set(0.5);
	}
	/**
	 * This method stops both front and back motor from spinning
	 */
	public void stop() {
		intakeMotor.set(0);
		indexerMotor.set(0);
		
	}
	
	@Override
	public void initDefaultCommand() { }
}
