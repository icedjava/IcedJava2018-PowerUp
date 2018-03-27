
package org.usfirst.frc.team6894.robot;

import org.usfirst.frc.team6894.robot.subsystems.*;
import org.usfirst.frc.team6894.robot.commands.*;

//import edu.wpi.cscore.UsbCamera;
//import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static DriveTrainSubsytem driveTrainSubsystem;
	public static GearShiftSubsystem gearShiftSubsystem;
	public static Compressor compressor;
	public static ArmSubsystem armSubsystem;
	public static IntakeSubsystem intakeSubsystem;
	public static IntakePistonSubsystem intakePistonSubsystem;

	public static OI oi;

	/*public static UsbCamera camera1;
	public static UsbCamera camera2;
	public static VideoSink server;
	public static boolean usingCamera1 = true;*/

	
	// private VisionThread visionThread;
	// private final Object imgLock = new Object();
	public static boolean runVisionThread;

	public SendableChooser<AutoModes> autoChooser;

	public static enum AutoModes {
		LEFT_SIDE, RIGHT_SIDE, MIDDLE
	};


	Command autonomousCommand;
	public static Command leftSideLeftSwitchAutonomous;
	public static Command leftSideRightSwitchAutonomous;
	public static Command rightSideLeftSwitchAutonomous;
	public static Command rightSideRightSwitchAutonomous;
	public static Command middleLeftSwitchAutonomous;
	public static Command middleRightSwitchAutonomous;
	public static Command driveFowardAutonomous;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */

	public void robotInit() {
		driveTrainSubsystem = new DriveTrainSubsytem();
		gearShiftSubsystem = new GearShiftSubsystem();
		armSubsystem = new ArmSubsystem();
		compressor = new Compressor(0);
		compressor.setClosedLoopControl(true);
		intakeSubsystem = new IntakeSubsystem();
		intakePistonSubsystem = new IntakePistonSubsystem();

		oi = new OI();

		leftSideLeftSwitchAutonomous = new LeftSideLeftSwitchAutonomous();
		leftSideRightSwitchAutonomous = new LeftSideRightSwitchAutonomous();
		rightSideLeftSwitchAutonomous = new RightSideLeftSwitchAutonomous();
		rightSideRightSwitchAutonomous = new RightSideRightSwitchAutonomous();
		middleLeftSwitchAutonomous = new MiddleLeftSwitchAutonomous();
		middleRightSwitchAutonomous = new MiddleRightSwitchAutonomous();
		autoChooser = new SendableChooser<AutoModes>();
		autoChooser.addDefault("Middle", AutoModes.MIDDLE);
		autoChooser.addObject("Left", AutoModes.LEFT_SIDE);
		autoChooser.addObject("Right", AutoModes.RIGHT_SIDE);
		SmartDashboard.putData("Auto Chooser", autoChooser);

		// pcamera1 = CameraServer.getInstance().startAutomaticCapture(0);
		// camera2 = CameraServer.getInstance().startAutomaticCapture(1);
		// camera1.setResolution(RobotMap.IMG_WIDTH, RobotMap.IMG_HEIGHT);
		// camera2.setResolution(RobotMap.IMG_WIDTH, RobotMap.IMG_HEIGHT);
		// camera1.setExposureManual(RobotMap.CAM_EXPOSURE_DRIVING);
		// camera2.setExposureManual(RobotMap.CAM_EXPOSURE_DRIVING);
		// server = CameraServer.getInstance().getServer();

	}

	// autonomousCommand = new DriveForwardAutonomous();

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */

	public void disabledInit() {

	}

	public void autonomousInit() {
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if (gameData.length() > 0) {
			if (gameData.charAt(0) == 'L') {
				switch (autoChooser.getSelected()) {
				case LEFT_SIDE:
					autonomousCommand = new LeftSideLeftSwitchAutonomous();
					break;
				case MIDDLE:
					autonomousCommand = new MiddleLeftSwitchAutonomous();
					break;
				case RIGHT_SIDE:
					autonomousCommand = new RightSideLeftSwitchAutonomous();
					break;
				}
			} else {
				switch (autoChooser.getSelected()) {
				case LEFT_SIDE:
					autonomousCommand = new LeftSideRightSwitchAutonomous();
					break;
				case MIDDLE:
					autonomousCommand = new MiddleRightSwitchAutonomous();
					break;
				case RIGHT_SIDE:
					autonomousCommand = new RightSideRightSwitchAutonomous();
					break;
				}
			}
		}
		
		autonomousCommand.start();
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopPeriodic() {
		try {
			Scheduler.getInstance().run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
