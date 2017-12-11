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

	public void spinInward() {
		intakeMotor.set(0.5);
		indexerMotor.set(-0.5);
	}
	
	public void spinOutward() {
		intakeMotor.set(-0.5);
		indexerMotor.set(0.5);
	}
	
	public void stop() {
		intakeMotor.set(0);
		indexerMotor.set(0);
		
	}
	
	@Override
	public void initDefaultCommand() { }
}
