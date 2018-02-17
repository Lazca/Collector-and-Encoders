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
		public Button Six;
		public Button Seven;
		public Button Triangle;
		public Button Nine;
		public Button L2;
		public Button R2;

	public OI(){
		
		joystick1 = new Joystick(0);
		
		A = new JoystickButton(joystick1, 3);
		X = new JoystickButton(joystick1,2);
		Triangle = new JoystickButton(joystick1, 4);
		Six = new JoystickButton(joystick1,6);
		Seven = new JoystickButton(joystick1,7);
		Nine = new JoystickButton(joystick1,9);
		L2 = new JoystickButton(joystick1, 7);
		R2 = new JoystickButton(joystick1, 8);
		
		
		L2.whenPressed(new CollectorIn());
		L2.whenReleased(new CollectorOff());
		R2.whenPressed(new CollectorOut());
		R2.whenReleased(new CollectorOff());
		Eleven.whenPressed(new EncoderReset());
		
				
	}


	public Joystick getjoystick1Joystick(){
	
		return joystick1;
}
}