package org.usfirst.frc.team3158.robot.subsystems.chassis;

import org.usfirst.frc.team3158.robot.Robot;
import org.usfirst.frc.team3158.robot.RobotMap;
import org.usfirst.frc.team3158.robot.commands.chassis.DefaultDriveCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMTalonSRX;
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
	
	public Encoder encoder;
	Boolean IsEncoderInverted = true;
	
	public RobotDrive robotDrive;
	
	public DriveTrainSubsystem(){
		
		MotorFrontLeft = new Talon (RobotMap.MotorFrontLeft);
    	MotorBackLeft = new WPI_TalonSRX (RobotMap.MotorBackLeft);
    	MotorBackRight = new Talon (RobotMap.MotorBackRight);
    	MotorFrontRight = new WPI_TalonSRX (RobotMap.MotorFrontRight);
    	
    	encoder = new Encoder (8,9, IsEncoderInverted, CounterBase.EncodingType.k4X);
		encoder.setDistancePerPulse(((3.875*Math.PI)/315.5));
		encoder.setMaxPeriod(10);
		encoder.setMinRate(0.1);
		encoder.setSamplesToAverage(7);
		
    	
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
    
	
	
public double getEncoderRate(){
		
		return(encoder.getRate());
		
		
		
	}
	
	
	public double getEncoderDistance(){
		
		return(encoder.getDistance());
		
	}
	
	public double getEncoderRaw(){
		
		return(encoder.getRaw());
		
	}
	
	public double getDistancePerPulse(){
		
		return(encoder.getDistancePerPulse());
		
	}
	
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
	
	
	public void encoderReset(){
		
		encoder.reset();
		
	}
		
	
	@SuppressWarnings("deprecation")
	public double getEncoderPeriod(){
		
		return(encoder.getPeriod());
	}
	
	
	
	
 

    public void initDefaultCommand() {
    
    	    	
    	setDefaultCommand(new DefaultDriveCommand());
    }
    
    public void GoStraight(){
    	
    	MotorFrontLeft.set(0.5);
    	MotorFrontRight.set(0.5);
    	MotorBackLeft.set(-0.5);
    	MotorBackRight.set(-0.5);
    	
    }
    
}

