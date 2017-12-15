package org.usfirst.frc.team1306.robot.commands.shooter;

import org.usfirst.frc.team1306.robot.Constants;
import org.usfirst.frc.team1306.robot.commands.CommandBase;
import edu.wpi.first.wpilibj.Timer;

public class Fire2 extends CommandBase{
	
	private Timer timer;
	public double speed = 1000;
	private int i = 1;
	
	
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
		
		if (timer.hasPeriodPassed(3 * i) && speed < 5000) {
			speed += 1000;
			i++;
		}
		shooter2.shootOut(speed);
		
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
		shooter2.stop();
	}
	
	protected void interrupted() {
	end();
	}
	}
	



