package org.usfirst.frc.team6894.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddleRightSwitchAutonomous extends CommandGroup {

    public MiddleRightSwitchAutonomous() {
    	//addSequential(new DriveDistanceCommand( 5, 1 )); //Encoders
    	//addSequential(new TurnCommand(.75, 90));
    	//addSequential(new DriveDistanceCommand( 5, 1 ));
    	//addSequential(new TurnCommand(.75, -90));
    	//addSequential(new DriveDistanceCommand( 5, 1 ));
    	//addSequential(new ArmAutonomous(1, .6));
    	
    	addSequential(new DriveForwardCommand(1, 1)); //time based
    	addSequential(new TurnAtTimeCommand(.5, .5));
    	addSequential(new DriveForwardCommand(1, 1));
    	addSequential(new TurnAtTimeCommand(-.5, .5));
    	addSequential(new DriveForwardCommand(1, 1));
    	addSequential(new ArmAutonomous(1, .6));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
