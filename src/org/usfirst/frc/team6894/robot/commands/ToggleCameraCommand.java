package org.usfirst.frc.team6894.robot.commands;

<<<<<<< HEAD
import org.usfirst.frc.team6894.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
=======
//import org.usfirst.frc.team6894.robot.Robot;

//import edu.wpi.first.wpilibj.command.Command;
>>>>>>> Initial Commit

/**
 *
 */
<<<<<<< HEAD
public class ToggleCameraCommand extends Command {
=======
/*public class ToggleCameraCommand extends Command {
>>>>>>> Initial Commit

    public ToggleCameraCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Robot.usingCamera1) {
    		Robot.server.setSource(Robot.camera2);
    	} else {
    		Robot.server.setSource(Robot.camera1);
    	}
    	Robot.usingCamera1 = !Robot.usingCamera1;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
<<<<<<< HEAD
}
=======
}*/
>>>>>>> Initial Commit
