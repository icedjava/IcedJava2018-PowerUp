package org.usfirst.frc.team6894.robot.subsystems;

import org.usfirst.frc.team6894.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class ArmSubsystem extends Subsystem {
	
	private Spark armSpark;
	
	
	public ArmSubsystem() {
		armSpark = new Spark(RobotMap.ARM_SPARK);
		armSpark.setInverted(true);
	}
	
	public void armUp() {
		armSpark.set(RobotMap.ARM_SPEED);
	}
	
	public void armStop() {
		armSpark.set(0);
	}

	public void armDown() {
		armSpark.set(-RobotMap.ARM_SPEED);
	}
	
	
	public void armAutonomous(double power) {
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

