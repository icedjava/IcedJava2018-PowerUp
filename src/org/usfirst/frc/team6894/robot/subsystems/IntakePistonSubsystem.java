package org.usfirst.frc.team6894.robot.subsystems;

import org.usfirst.frc.team6894.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakePistonSubsystem extends Subsystem {
	
	private DoubleSolenoid intakePiston;
	
	public IntakePistonSubsystem() {
		intakePiston = new DoubleSolenoid(RobotMap.INTAKE_SOLENOID_PORTS[0], RobotMap.INTAKE_SOLENOID_PORTS[1]);
		intakePiston.set(RobotMap.INTAKE_PISTON_IN);
	}
	
	public void IntakeDown() {
		intakePiston.set(RobotMap.INTAKE_PISTON_OUT);
	}
	
	public void IntakeUp() {
		intakePiston.set(RobotMap.INTAKE_PISTON_IN);
	}
	
	public Value ShiftedState() {
		return intakePiston.get();
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

