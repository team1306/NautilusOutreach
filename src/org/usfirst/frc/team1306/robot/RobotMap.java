package org.usfirst.frc.team1306.robot;

/**
 * @RobotMap
 * 
 * The RobotMap is a mapping from the ports sensors and actuators are wired into to a variable 
 * name. This provides flexibility changing wiring, makes checking the wiring easier and significantly 
 * reduces the number of magic numbers floating around.
 * 
 * @author Jackson Goth and Ethan Dong
 */
public class RobotMap {

	/** @OI_Ports */
	public static final int PRIMARY_PORT = 0;
	public static final int SECONDARY_PORT = 1;

	/** @Intake_Ports */
	public static final int INTAKE_TALON_PORT = 0;
	public static final int INDEXER_TALON_PORT = 2;
	
	/** @Drivetrain_Ports */ //TODO Re-name each talon to specify 'front' or 'back' instead of '1,2,3,4'
	public static final int LEFT_TALON_1_PORT = 1;
	public static final int LEFT_TALON_2_PORT = 2;
	public static final int RIGHT_TALON_1_PORT = 4;
	public static final int RIGHT_TALON_2_PORT = 5;

	/** @Shooter_Turret_Ports */
	public static final int FLYWHEEL_TALON_PORT = 9;
	public static final int HOOD_TALON_PORT = 11;
	public static final int TURRET_TALON_PORT = 10;

	/** @Indexer_Ports */
	public static final int INDEXER_PORT = 1; //TODO Re-write indexer subsystem - this will change
	public static final int INDEXER_LIMIT_1_PORT = 0;
	public static final int INDEXER_LIMIT_2_PORT = 1;
	public static final int PRESSURE_PAD_PORT = 0;

}
