package org.usfirst.frc.team1306.robot.commands.intake;

import org.usfirst.frc.team1306.robot.Constants;
import org.usfirst.frc.team1306.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

/**
 * @SpitBoulder
 * 
 * Command that uses the indexer / intake motors to push out a boulder, using a timer to judge if the ball has exited.
 *
 * @author Ethan Dong and Jackson Goth
 */

public class SpitBoulder extends CommandBase {

	private Timer timer;
	
	public SpitBoulder() {
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
