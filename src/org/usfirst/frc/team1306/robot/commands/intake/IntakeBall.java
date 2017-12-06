package org.usfirst.frc.team1306.robot.commands.intake;

import org.usfirst.frc.team1306.robot.commands.CommandBase;

/**
 * This command spins the intake motors and takes in the ball when pressed and 
 * stopped when pressed again.
 *
 */

public class IntakeBall extends CommandBase {

	public IntakeBall() {
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
