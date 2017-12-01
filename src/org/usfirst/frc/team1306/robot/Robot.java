package org.usfirst.frc.team1306.robot;

import org.usfirst.frc.team1306.robot.commands.CommandBase;
import org.usfirst.frc.team1306.robot.commands.SmartDashboardUpdate;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @Nautilus_Outreach
 * 
 * Our 2016 robot Nautilus, re-programmed for outreach purposes and allowing
 * younger students to drive and learn about our program.
 * 
 * @author Jackson Goth
 */
public class Robot extends IterativeRobot {

	/**
	 * This function is run when the robot is first started up and we use it for
	 * sending an autonomous mode selection to the smartdashboard, setting up driver
	 * cameras, and initializing subsystems.
	 */
	@Override
	public void robotInit() {
		
		CommandBase.init(); //Initializes all Subsystems
		//CameraServer.getInstance().startAutomaticCapture("usb",0); //Camera 1
		
		new SmartDashboardUpdate().start();
	}

	/**
	 * Robot is disabled
	 */
	@Override
	public void disabledPeriodic() {
		SmartDashboard.putString("STATUS:","DISABLED");
		Scheduler.getInstance().run();
	}

	/**
	 * This version of the code doesn't need an autonomous
	 */
	@Override
	public void autonomousInit() { }

	/**
	 * Robot is enabled and under autonomous control
	 */
	@Override
	public void autonomousPeriodic() {
		SmartDashboard.putString("STATUS:","AUTONOMOUS");
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() { }

	/**
	 * Robot is enabled and under operator control
	 */
	@Override
	public void teleopPeriodic() {
		SmartDashboard.putString("STATUS:","ENABLED");
		Scheduler.getInstance().run();
	}

	//Haven't ever needed this
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
