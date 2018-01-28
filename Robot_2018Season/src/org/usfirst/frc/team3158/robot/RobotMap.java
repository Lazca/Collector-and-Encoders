package org.usfirst.frc.team3158.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	Joystick joystick1;
	
	
	//Collector Subsystem
	public static int CollectorLeft = 2;
	public static int CollectorLeft1 = 1;
	public static int CollectorRight = 4;
	public static int CollectorRight1 = 3;
	public static int CollectorPistonsOn;
	public static int CollectorPistonsOff;
	public static int CollectorLimitSwitch;
	public static double Speed = 0.3;
	public static int MotorFrontLeft = 1;   //1 Talon
	public static int MotorFrontRight = 4; //4 TalonSRX
	public static int MotorBackRight = 3; //3 Talon
	public static int MotorBackLeft = 2; //2 TalonSRX
	
}
	
	

