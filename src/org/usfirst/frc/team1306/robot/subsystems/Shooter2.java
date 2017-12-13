package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.Constants;
import org.usfirst.frc.team1306.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter2 extends Subsystem{
		
		CANTalon frontMotor;
		
		public Shooter2() {
			frontMotor = new CANTalon(RobotMap.TURRET_TALON_PORT);
			frontMotor.enable();
			frontMotor.reverseSensor(true);
			frontMotor.reverseOutput(true);
			frontMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
			
		}
		
		public void shootOut() {
			frontMotor.changeControlMode(TalonControlMode.Speed);
			frontMotor.set(2000);
	
		}
		
		public void stop() {
			frontMotor.changeControlMode(TalonControlMode.PercentVbus);
			frontMotor.set(0);
			
		}
		
		@Override
		public void initDefaultCommand() {}

	}




