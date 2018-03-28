package org.usfirst.frc.team6894.robot;
//import org.usfirst.frc.team6894.robot.commands.climber.ClimbDownCommand;
//import org.usfirst.frc.team6894.robot.commands.climber.ClimbUpCommand;
//import org.usfirst.frc.team6894.robot.commands.gearOut.ContractGearOut;
//import org.usfirst.frc.team6894.robot.commands.gearOut.ExtendGearOutCommand;
//import org.usfirst.frc.team6894.robot.commands.intake.ForwardIntake;
//import org.usfirst.frc.team6894.robot.commands.intake.ReverseIntake;

import org.usfirst.frc.team6894.robot.commands.ArmUpCommand;
import org.usfirst.frc.team6894.robot.commands.IntakeDownCommand;
import org.usfirst.frc.team6894.robot.commands.IntakeInCommand;
import org.usfirst.frc.team6894.robot.commands.IntakeOutCommand;
import org.usfirst.frc.team6894.robot.commands.IntakeUpCommand;
import org.usfirst.frc.team6894.robot.commands.ArmDownCommand;
import org.usfirst.frc.team6894.robot.commands.ShiftDownCommand;
import org.usfirst.frc.team6894.robot.commands.ShiftUpCommand;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
	public Joystick leftStick, rightStick, shooterStick;
	public XboxController controller;

	public OI() {
		leftStick = new Joystick(RobotMap.LFFT_JOYSTICK_PORT);
		rightStick = new Joystick(RobotMap.RIGHT_JOYSTICK_PORT);
		shooterStick = new Joystick(RobotMap.SHOOTER_STICK);
		controller = new XboxController(RobotMap.CONTROLLER);
		
		setButtonWhenPressed(controller, 6, new ShiftUpCommand());
		setButtonWhenPressed(controller, 5, new ShiftDownCommand());
		setButtonWhileHeld(controller, 4, new ArmUpCommand());
		setButtonWhileHeld(controller, 2, new ArmDownCommand());
		setButtonWhenPressed(shooterStick, 6, new IntakeUpCommand());
		setButtonWhenPressed(shooterStick, 4, new IntakeDownCommand());
		setButtonWhileHeld(shooterStick, 1, new IntakeInCommand());
		setButtonWhileHeld(shooterStick, 2, new IntakeOutCommand());
	}
	
	private void setButtonWhenPressed(XboxController joystick, int button, Command command) {
		new JoystickButton(controller, button).whenPressed(command);
	}
	
	private void setButtonWhileHeld(XboxController joystick, int button, Command command) {
		new JoystickButton(controller, button).whileHeld(command);
	}
	
	private void setButtonWhenPressed(Joystick joystick, int button, Command command) {
		new JoystickButton(shooterStick, button).whenPressed(command);
	}
	
	private void setButtonWhileHeld(Joystick joystick, int button, Command command) {
		new JoystickButton(shooterStick, button).whileHeld(command);
	}
	
	//public double getShooterY() {
	//	if (!(shooterStick == null)) {
	//		return -deadZoneMod(shooterStick.getY());
	//	} else {
	//		return 0;
	//	}
	//}

	public double getRightX() {
		if (!(rightStick == null)) {
			return deadZoneMod(rightStick.getX());
		} else {
			return 0;
		}
	}

	public double getLeftX() {
		if (leftStick != null) {
			return deadZoneMod(leftStick.getX());
		} else {
			return 0;
		}
	}

	public double getRightY() {
		if (!(rightStick == null)) {
			return deadZoneMod(rightStick.getY());
		} else {
			return 0;
		}
	}

	public double getLeftY() {
		if (!(leftStick == null)) {
			return -deadZoneMod(leftStick.getY());
		} else {
			return 0;
		}
	}

	private double deadZoneMod(double val) {
		if (Math.abs(val) <= RobotMap.JOYSTICK_DEADZONE) {
			return 0;
		} else {
			return val;
		}
	}
	
	public double getControllerRightX() {
		if (!(controller == null)) {
			return deadZoneMod(controller.getX(Hand.kRight));
		} else {
			return 0;
		}
	}

	public double getControllerLeftX() {
		if (!(controller == null)) {
			return deadZoneMod(controller.getX(Hand.kLeft));
		} else {
			return 0;
		}
	}
	
	public double getControllerRightY() {
		if (!(controller == null)) {
			return deadZoneMod(controller.getY(Hand.kRight));
		} else {
			return 0;
		}
	}
	
	public double getControllerLeftY() {
		if (!(controller == null)) {
			return deadZoneMod(controller.getY(Hand.kLeft));
		} else {
			return 0;
		}
	}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressAQed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}