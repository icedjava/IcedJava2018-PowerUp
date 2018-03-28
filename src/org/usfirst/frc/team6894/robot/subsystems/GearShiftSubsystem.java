package org.usfirst.frc.team6894.robot.subsystems;

import org.usfirst.frc.team6894.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearShiftSubsystem extends Subsystem {

	private DoubleSolenoid shifter;
	
	public GearShiftSubsystem() {
		shifter = new DoubleSolenoid(RobotMap.GEAR_SHIFT_SOLENOID_PORTS[0], RobotMap.GEAR_SHIFT_SOLENOID_PORTS[1]);
		shifter.set(RobotMap.DRIVETRAIN_SHIFT_DOWN);
	}
	
	public void ShiftUp() {
		shifter.set(RobotMap.DRIVETRAIN_SHIFT_UP);
	}
	
	public void ShiftDown() {
		shifter.set(RobotMap.DRIVETRAIN_SHIFT_DOWN);
	}
	
	public Value ShiftedState() {
		return shifter.get();
	}
	
	@Override
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

