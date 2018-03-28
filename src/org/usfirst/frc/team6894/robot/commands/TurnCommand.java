package org.usfirst.frc.team6894.robot.commands;

import org.usfirst.frc.team6894.robot.Robot;
import org.usfirst.frc.team6894.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnCommand extends Command {
	private double degrees, power, turnArcLength;

    public TurnCommand(double power, double degrees) {
    	this.degrees = degrees;
    	this.power = power;
    	requires(Robot.driveTrainSubsystem);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrainSubsystem.resetEncoders();
    	turnArcLength = (degrees / 360.0) * (RobotMap.ROBOT_TRACK_WIDTH_FT * Math.PI);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(degrees > 0){
    		Robot.driveTrainSubsystem.moveLeftTrain(power);
    		Robot.driveTrainSubsystem.moveRightTrain(-power);
    	} else if(degrees < 0){
    		Robot.driveTrainSubsystem.moveLeftTrain(-power);
    		Robot.driveTrainSubsystem.moveRightTrain(power);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.driveTrainSubsystem.getLeftEncoderDistance()) >= turnArcLength;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
