package org.usfirst.frc.team1306.robot.subsystems;

import org.usfirst.frc.team1306.robot.Constants;
import org.usfirst.frc.team1306.robot.RobotMap;
import org.usfirst.frc.team1306.robot.commands.turret.ScanDirection;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 * The turret that controls the heading of the shooter relative to the robot.
 * This PIDSubsystem takes the camera image as feedback, and adjusts the turret
 * heading to match. It uses PID in two distinct ways. One PID loop is run here,
 * on this PIDSubsystem, taking the camera image as feedback and setting the
 * throttle on the motor accordingly. The TalonSRX also uses the encoder to run
 * its own PID loop that resets the turret to the forward position when it isn't
 * targeting.
 * 
 * @author Finn Voichick, James Tautges
 */
public class Turret extends PIDSubsystem {

	private final static boolean ENABLED = true;

	/** The Talon SRX that controls the turret motor. */
	private final CANTalon turretTalon;
	private ScanDirection scanDirection;

	/**
	 * Creates a new turret with the PID constants set in the Constants file and
	 * the right settings.
	 */
	public Turret() {

		super("Turret PID", Constants.TURRET_P, Constants.TURRET_I, Constants.TURRET_D);

		if (ENABLED) {

			setAbsoluteTolerance(Constants.TURRET_VISION_TOLERANCE);
			setOutputRange(-0.2, 0.2);

			turretTalon = new CANTalon(RobotMap.TURRET_TALON_PORT);
			turretTalon.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
			turretTalon.changeControlMode(TalonControlMode.PercentVbus);
			turretTalon.enableBrakeMode(true);
			setSetpoint(0.0);

			scanDirection = ScanDirection.LEFT;

		} else {
			turretTalon = null;
		}
	}

	/**
	 * Sets the default command for the Turret. Nothing is done to the turret
	 * until commands are called, so no default command must be specified.
	 */
	@Override
	public void initDefaultCommand() {
	}

	/**
	 * Set the velocity of the turret motor, on a scale from -1.0 to 1.0. This
	 * doesn't use PID control; it just directly sets the throttle.
	 * 
	 * @param velocity
	 *            the new velocity.
	 */
	public void setVel(double speed) {
		if (!ENABLED) {
			return;
		}

		turretTalon.changeControlMode(TalonControlMode.PercentVbus);
		turretTalon.set(-Constants.TURRET_SCAN_SPEED * speed);
	}

	/**
	 * Set the target position for the turret to straight forward (encoder
	 * position 0). The Talon will then use its PID position control to point
	 * forward.
	 */
	public void setTurretForward() {
		setTurretPosition(0.0);
	}

	public void setTurretPosition(double position) {
		if (!ENABLED) {
			return;
		}

		getPIDController().reset();

		turretTalon.changeControlMode(TalonControlMode.Position);
		turretTalon.set(position);
		turretTalon.enable();
	}

	/**
	 * Determines whether the turret is all the way to the right. This is used
	 * when scanning back and forth, so it knows when to change direction.
	 * 
	 * @return true if the turret is far to the right, otherwise false.
	 */
	public boolean isRight() {
		if (!ENABLED) {
			return false;
		}

		return turretTalon.getPosition() * 4096.0 < -Constants.TURRET_SCAN_THRESHOLD;
	}

	/**
	 * Determines whether the turret is all the way to the left. This is used
	 * when scanning back and forth, so it knows when to change direction.
	 * 
	 * @return true if the turret is far to the left, otherwise false.
	 */
	public boolean isLeft() {
		if (!ENABLED) {
			return false;
		}

		return turretTalon.getPosition() * 4096.0 > Constants.TURRET_SCAN_THRESHOLD;
	}

	public void setScanDirection(ScanDirection scanDirection) {
		this.scanDirection = scanDirection;
	}

	public ScanDirection getScanDirection() {
		return scanDirection;
	}

	/**
	 * Gets the input from the camera that gives the angle of the target
	 * relative to the current position. This is the difference between the
	 * intended position and the current position. Because this is already the
	 * error, the setpoint stays at zero.
	 * 
	 * @return The position of the target relative to the robot, or 0.0 if it
	 *         can't be seen.
	 */
	protected double returnPIDInput() {
		if (!ENABLED) {
			return 0.0;
		}

//		double yaw = -Vision.getData().getYaw();
		return 0;
//		return Math.abs(yaw) <= Constants.TURRET_VISION_TOLERANCE ? 0.0 : yaw;
	}

	/**
	 * Sets the velocity of the turret based on the output of the PID loop.
	 */
	protected void usePIDOutput(double output) {
//		if (!ENABLED) {
//			return;
//		}
//
//		turretTalon.changeControlMode(TalonControlMode.PercentVbus);
//
//		double yaw = -Vision.getData().getYaw();
//		if (Math.abs(yaw) <= Constants.TURRET_VISION_TOLERANCE) {
//			turretTalon.set(0.0);
//		} else {
//			turretTalon.set(output);
//		}
	}

}
