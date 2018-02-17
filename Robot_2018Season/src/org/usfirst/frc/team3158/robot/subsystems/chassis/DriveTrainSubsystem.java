package org.usfirst.frc.team3158.robot.subsystems.chassis;

import org.usfirst.frc.team3158.robot.Robot;
import org.usfirst.frc.team3158.robot.RobotMap;
import org.usfirst.frc.team3158.robot.commands.chassis.DefaultDriveCommand;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
@SuppressWarnings("deprecation")

public class DriveTrainSubsystem extends Subsystem {

	public WPI_TalonSRX MotorFrontRight;
	public Talon MotorFrontLeft;
	public SpeedController MotorBackRight;
	public WPI_TalonSRX MotorBackLeft;
	public TalonSRX kha;
	int quad;
	
	
	public Encoder encoder;
	Boolean IsEncoderInverted = true;
	
	public RobotDrive robotDrive;
	
	
	/*
	 * This is a simple 4 motor,, single transmission drivetrain
	 * made to test encoders attached
	 * to the axis that goes to the wheel
	 */
	
	
	public DriveTrainSubsystem(){
		
		MotorFrontLeft = new Talon (RobotMap.MotorFrontLeft);
    	MotorBackLeft = new WPI_TalonSRX (RobotMap.MotorBackLeft);
    	MotorBackRight = new Talon (RobotMap.MotorBackRight);
    	MotorFrontRight = new WPI_TalonSRX (RobotMap.MotorFrontRight);
    	kha = new TalonSRX(0);
    	quad = kha.getSensorCollection().getQuadraturePosition();
    	
    	//The encoder can be set with four parameters: the two DIO ports to which it
    	//it is connected, a boolean to invert the values that the encoder returns, 
    	//and the encodingType, which is used to count rising and/or falling edges. This
    	//doubles or quadruples the count
    	encoder = new Encoder (8,9, IsEncoderInverted, CounterBase.EncodingType.k4X);
		encoder.setDistancePerPulse(((3.875*Math.PI)/315.5));
		encoder.setMaxPeriod(10);
		encoder.setMinRate(0.1);
		encoder.setSamplesToAverage(7);
		
		
    	//Inverted motors to match the front of our chassis
    	MotorFrontLeft.setInverted(true);
    	MotorBackLeft.setInverted(true);
    	MotorFrontRight.setInverted(true);
    	MotorBackRight.setInverted(true);
    	
    	
    	
    	robotDrive = new RobotDrive(MotorFrontLeft, MotorBackLeft, MotorFrontRight, MotorBackRight);
    	robotDrive.setSafetyEnabled(false);
    	
	}
	
	
	
	public void driveT(){
    	robotDrive.arcadeDrive(Robot.oi.getjoystick1Joystick().getY(), Robot.oi.getjoystick1Joystick().getX());
    	//System.out.println("// Y" + Robot.oi.getjoystick1Joystick().getY() +"// X" + Robot.oi.getjoystick1Joystick().getX());
	}
    
	
	//Returns the rate of the encoder
	public double getEncoderRate(){
		
		return(encoder.getRate());
		
	
		
	}
	
	//Returns the distancethe encoder has recorded. This function uses setDistancePerPulse
	public double getEncoderDistance(){
		
		return(encoder.getDistance());
		
	}
	
	//Returns the raw count of the encoder without k2X or k4X
	public double getEncoderRaw(){
		
		return(encoder.getRaw());
		
	}
	
	//Returns the Distance per pulse
	public double getDistancePerPulse(){
		
		return(encoder.getDistancePerPulse());
		
	}
	

	//Sets the robot to stop after 10 feet (120 inches)
	public void encoderTest(){

		double i = encoder.getDistance();
		
		while(i < 120){
			i = encoder.getDistance();
			
			MotorFrontLeft.set(0.5);
	    	MotorFrontRight.set(0.5);
	    	MotorBackLeft.set(-0.5);
	    	MotorBackRight.set(-0.5);
	    	
		}
	}
	
	
	
	//Resets the Encoder
	public void encoderReset(){
		
		encoder.reset();
		
	}
		
	
	//Returns the period
	@SuppressWarnings("deprecation")
	public double getEncoderPeriod(){
		
		return(encoder.getPeriod());
	}
	

    public void initDefaultCommand() {
    
    	    	
    	setDefaultCommand(new DefaultDriveCommand());
    }

    
}

