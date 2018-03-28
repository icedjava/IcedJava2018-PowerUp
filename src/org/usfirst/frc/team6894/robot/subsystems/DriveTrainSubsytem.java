package org.usfirst.frc.team6894.robot.subsystems;

import org.usfirst.frc.team6894.robot.RobotMap;
import org.usfirst.frc.team6894.robot.commands.UserDriveCommand;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrainSubsytem extends Subsystem {
	
	private Spark left1, left2, left3, right1, right2, right3;
	private Encoder leftEncoder, rightEncoder;

	public DriveTrainSubsytem() {
		left1 = new Spark(RobotMap.FRONT_LEFT_SPARK);
		left2 = new Spark(RobotMap.CENTER_LEFT_SPARK);
		left3 = new Spark(RobotMap.BACK_LEFT_SPARK);
		right1 = new Spark(RobotMap.FRONT_RIGHT_SPARK);
		right2 = new Spark(RobotMap.CENTER_RIGHT_SPARK);
		right3 = new Spark(RobotMap.BACK_RIGHT_SPARK);
		
		leftEncoder = new Encoder(0, 1, false, EncodingType.k4X);
		rightEncoder = new Encoder(2, 3, false, EncodingType.k4X);
		
		leftEncoder.setDistancePerPulse(1);
		rightEncoder.setDistancePerPulse(1);
		
		//Deciding to invert motors or not
		right1.setInverted(false);
		right2.setInverted(true);
		right3.setInverted(false);
		left1.setInverted(false);
		left2.setInverted(true);
		left3.setInverted(false);	
	}
	
	public void driveStraight(double speed) {
		moveLeftTrain(speed);
		
		moveRightTrain(-speed);
	}

	public void moveLeftTrain(double speed) {
		left1.set(speed);
		left2.set(speed);
		left3.set(speed);
	}

	public void moveRightTrain(double speed) {
		right1.set(speed);
		right2.set(speed);
		right3.set(speed);
	}
	
	public void tankDrive(double left, double right) {
		moveLeftTrain(left);
		moveRightTrain(right);
	}
	
	public double getLeftEncoderDistance() {
		return leftEncoder.getDistance();
	}
	
	public double getRightEncoderDistance() {
		return rightEncoder.getDistance();
	}
	
	public double getAvgEncoderDistance() {
		return (rightEncoder.getDistance() + leftEncoder.getDistance()) / 2;
	}
	
	
	
	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new UserDriveCommand());
     
    }
}

