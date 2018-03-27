package org.usfirst.frc.team6894.robot.commands;

import org.usfirst.frc.team6894.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnAtTimeCommand extends Command {
	
	private double time, power;

    public TurnAtTimeCommand(double time, double power) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.time = time;
    	this.power = power;
    	requires(Robot.driveTrainSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(this.time);
    	if(power > 0) {
    		Robot.driveTrainSubsystem.moveLeftTrain(power);
    		Robot.driveTrainSubsystem.moveRightTrain(-power);
    	}else if(power < 0) {
<<<<<<< HEAD
    		Robot.driveTrainSubsystem.moveRightTrain(-power);
    		Robot.driveTrainSubsystem.moveLeftTrain(power);
=======
    		Robot.driveTrainSubsystem.moveRightTrain(power);
    		Robot.driveTrainSubsystem.moveLeftTrain(-power);
>>>>>>> Initial Commit
    	}
    			
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
