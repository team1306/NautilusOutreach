package org.usfirst.frc.team1306.robot.commands.shooter;

import org.usfirst.frc.team1306.robot.Constants;
import org.usfirst.frc.team1306.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

public class Fire2 extends CommandBase{
	
	Timer timer;
	
	
	public Fire2() {
		requires(shooter2);
		
		timer = new Timer();
	}
	
	@Override
	protected void initialize(){
		timer.reset();
		timer.start();
		
	}
		

	@Override
	protected void execute() {
		shooter2.shootOut();
	}

	@Override
	protected boolean isFinished() {
		if (timer.hasPeriodPassed(Constants.SHOOT_TIME)){
			shooter2.stop();
			return true;
		}
		return false;
	}
	
	@Override
	protected void interrupted() {
		end(); //Needs to end if un-toggled
	}
}


