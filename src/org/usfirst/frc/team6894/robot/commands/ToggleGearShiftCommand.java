package org.usfirst.frc.team6894.robot.commands;

import org.usfirst.frc.team6894.robot.Robot;
import org.usfirst.frc.team6894.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleGearShiftCommand extends Command {

    public ToggleGearShiftCommand() {
    	requires(Robot.gearShiftSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		if (Robot.gearShiftSubsystem.ShiftedState() == RobotMap.DRIVETRAIN_SHIFT_UP) {
			Robot.gearShiftSubsystem.ShiftDown();
		} else {
			Robot.gearShiftSubsystem.ShiftUp();
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
