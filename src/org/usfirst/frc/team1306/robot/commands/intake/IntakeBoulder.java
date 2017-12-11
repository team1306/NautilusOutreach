package org.usfirst.frc.team1306.robot.commands.intake;

import org.usfirst.frc.team1306.robot.commands.CommandBase;

/**
 * @IntakeBoulder
 * 
 * Command that is toggled on and off and spins the intake / indexer motors inward to take in a boulder
 * 
 * @author Ethan Dong and Jackson Goth
 */
public class IntakeBoulder extends CommandBase {

	public IntakeBoulder() {
		requires(intake);
	}

	@Override
	protected void execute() {
		intake.spinInward();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
		intake.stop();
	}

	@Override
	protected void interrupted() {
		end(); //Needs to end if un-toggled
	}
}
