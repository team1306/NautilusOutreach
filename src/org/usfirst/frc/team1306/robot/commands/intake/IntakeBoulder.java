package org.usfirst.frc.team1306.robot.commands.intake;

import org.usfirst.frc.team1306.robot.commands.CommandBase;

/**
<<<<<<< HEAD:src/org/usfirst/frc/team1306/robot/commands/intake/IntakeBall.java
 * This command spins the intake motors and takes in the ball when pressed and 
 * stopped when pressed again.
 *
 */

public class IntakeBall extends CommandBase {
=======
 * @IntakeBoulder
 * 
 * Command that is toggled on and off and spins the intake / indexer motors inward to take in a boulder
 * 
 * @author Ethan Dong and Jackson Goth
 */
public class IntakeBoulder extends CommandBase {
>>>>>>> 5dd580eb443663a489b6c970808ceeb71115420d:src/org/usfirst/frc/team1306/robot/commands/intake/IntakeBoulder.java

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
