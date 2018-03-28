package org.usfirst.frc.team6894.robot.subsystems;

import org.usfirst.frc.team6894.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
	
	private Spark intakeLeft, intakeRight;
	
	public IntakeSubsystem() {
		intakeLeft = new Spark(RobotMap.INTAKE_LEFT);
		intakeRight = new Spark(RobotMap.INTAKE_RIGHT);
		intakeLeft.setInverted(false);
		intakeRight.setInverted(true);
	}
	
	public void intakeIn() {
		intakeLeft.set(RobotMap.INTAKE_LEFT_SPEED);
		intakeRight.set(RobotMap.INTAKE_RIGHT_SPEED);
	}
	
	public void intakeStop() {
		intakeLeft.set(0);
		intakeRight.set(0);
	}
	
	public void intakeOut() {
		intakeLeft.set(-RobotMap.INTAKE_LEFT_SPEED);
		intakeRight.set(-RobotMap.INTAKE_RIGHT_SPEED);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

