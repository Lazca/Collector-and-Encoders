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
	public static int CollectorLeft = 2;//Talon
	public static int CollectorLeft1 = 1;//TalonSRX 
	public static int CollectorRight = 4; //Talon
	public static int CollectorRight1 = 3; //TalonSRX
	public static int CollectorPistonsOn;   //Port for kForward
	public static int CollectorPistonsOff;   //Port for kReverse
	public static int CollectorLimitSwitch;   //Port for the LimitSwitch
	
	
	//DriveTrain Subsystem
	public static double Speed = 0.3;
	public static int MotorFrontLeft = 1;   // Talon
	public static int MotorFrontRight = 4; // TalonSRX
	public static int MotorBackRight = 3; // Talon
	public static int MotorBackLeft = 2; // TalonSRX
	
	//PID
	public static edu.wpi.first.wpilibj.SPI.Port PIDport;
	public static boolean isNavx;
	public static int gyro;
	
	//Escalator 2013
	public static int EscalatorMotor1 = 6;
	public static int EscalatorMotor2 = 5;
	
	
}
	
	

