package org.usfirst.frc.team6894.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// Drivetrain
	public static final int FRONT_LEFT_SPARK = 4;
	public static final int CENTER_LEFT_SPARK =  5;
	public static final int BACK_LEFT_SPARK = 3;
	public static final int FRONT_RIGHT_SPARK = 1;
	public static final int CENTER_RIGHT_SPARK = 2;
	public static final int BACK_RIGHT_SPARK =  0;
	public static final double DRIVE_FORWARD_POWER_AUTO = 0.5;
	public static final double DRIVE_FORWARD_TIME_AUTO = 1.0; //In Seconds
	
	public static final double ROBOT_TRACK_WIDTH_FT = 26.5 / 12;
	
	//GearShift
	public static final int[] GEAR_SHIFT_SOLENOID_PORTS = { 0, 1 };
	public static final Value DRIVETRAIN_SHIFT_UP = Value.kReverse;
	public static final Value DRIVETRAIN_SHIFT_DOWN = Value.kForward;
	
	//Arm
	public static final int ARM_SPARK = 6;
	public static final double ARM_SPEED = .7;
	
	//Intake
	public static final int INTAKE_LEFT = 7;
	public static final int INTAKE_RIGHT = 8;
	public static final double INTAKE_LEFT_SPEED = .7;
	public static final double INTAKE_RIGHT_SPEED = .7;
	public static final int[] INTAKE_SOLENOID_PORTS = { 2, 3 };
	public static final Value INTAKE_PISTON_OUT = Value.kForward;
	public static final Value INTAKE_PISTON_IN = Value.kReverse;
	
	//Camera
	public static final int IMG_WIDTH = 640;
	public static final int IMG_HEIGHT = 480;
	public static final int CAM_EXPOSURE_VISION = 0;
	public static final int CAM_BRIGHTNESS_VISION = 50;
	public static final int CAM_EXPOSURE_DRIVING = 50;
	public static final int CAM_BRIGHTNESS_DRIVING = 100;
	public static final double HORIZONTAL_FOV = 66 * Math.cos(Math.atan(9.0 / 16.0));
	public static final double VERTICAL_FOV = 66 * Math.sin(Math.atan(9.0 / 16.0));
	public static final double FOCAL_LENGTH = 683.4736842;
	public static final double TARGET_WIDTH_INCH = /*10.25*/9.5;
	public static final double TARGET_HEIGHT_INCH = /*5*/4.75;
	
	
	//Joystick
	public static final int LFFT_JOYSTICK_PORT = 4;
	public static final int RIGHT_JOYSTICK_PORT = 3;
	public static final int SHOOTER_STICK = 2;
	public static final double JOYSTICK_DEADZONE = .15;
	public static final int CONTROLLER = 0;
	

}