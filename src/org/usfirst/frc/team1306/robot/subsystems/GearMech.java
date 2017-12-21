package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearMech extends Subsystem{

	private Spark intakeMotor;
	
	public GearMech(){
		intakeMotor = new Spark(RobotMap.GEARTAKE_SPARK_PORT);
	}
	
	public void spinInward()  {
		intakeMotor.set(0.5);
	}
	
	public void spinOutward() {
		intakeMotor.set(-0.5);
	}
	
	public void stop() {
		intakeMotor.set(0);
	}
	
	
	
	@Override
	protected void initDefaultCommand() {}
	
	

}
