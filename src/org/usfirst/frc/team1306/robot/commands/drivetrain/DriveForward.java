package org.usfirst.frc.team1306.robot.commands.drivetrain;
import org.usfirst.frc.team1306.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

public class DriveForward extends CommandBase {

	private Timer timer;
	
	public DriveForward(){
		requires(drivetrain);
		timer = new Timer();
	}
	
	@Override
	protected void initialize() {
		timer.reset();
		timer.start();
	}

	@Override
	protected void execute() {
		drivetrain.driveVBus(0.5, 0.5);
	}

	@Override
	protected boolean isFinished() {
		return timer.hasPeriodPassed(6);
	}

}

