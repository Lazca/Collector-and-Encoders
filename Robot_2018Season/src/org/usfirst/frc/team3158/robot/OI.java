package org.usfirst.frc.team3158.robot;

import org.usfirst.frc.team3158.robot.commands.chassis.EncoderReset;
import org.usfirst.frc.team3158.robot.commands.collector.CollectorIn;
import org.usfirst.frc.team3158.robot.commands.collector.CollectorOff;
import org.usfirst.frc.team3158.robot.commands.collector.CollectorOut;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick joystick1;
	
	public Button X;
	public Button A;
	public Button Eleven;

	public OI(){
		
		joystick1 = new Joystick(0);
		
		A = new JoystickButton(joystick1, 3);
		X = new JoystickButton(joystick1,1);
		Eleven = new JoystickButton(joystick1, 4);
		
		A.whenPressed(new CollectorIn());
		A.whenReleased(new CollectorOff());
		X.whenPressed(new CollectorOut());
		X.whenReleased(new CollectorOff());
		Eleven.whenPressed(new EncoderReset());
		
	}


public Joystick getjoystick1Joystick(){
	
	return joystick1;
}
}