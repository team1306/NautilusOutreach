package org.usfirst.frc.team1306.robot.commands.intake;

import org.usfirst.frc.team1306.robot.Constants;
import org.usfirst.frc.team1306.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

public class SpitBall extends CommandBase {

	Timer timer;
	
	public SpitBall() {
		requires(intake);
		
		timer = new Timer();
	}
	
	@Override
	protected void initialize() {
		timer.reset();
		timer.start();
	}
	
	@Override
	protected void execute() {
		intake.spinOutward();
	}

	@Override
	protected boolean isFinished() {
		if(timer.hasPeriodPassed(Constants.INTAKE_SPIT_TIME)) {
			intake.stop();
			return true;
		}
		return false;
	}
}
