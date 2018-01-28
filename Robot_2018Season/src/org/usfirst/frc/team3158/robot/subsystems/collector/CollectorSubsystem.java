package org.usfirst.frc.team3158.robot.subsystems.collector;

import org.usfirst.frc.team3158.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class CollectorSubsystem extends Subsystem {

	
	
	DigitalInput CollectorLimit;
	Talon CollectorLeft; 
	WPI_TalonSRX CollectorLeft1;
	WPI_TalonSRX CollectorRight;
	Talon CollectorRight1;
	DoubleSolenoid Piston;
	Double Speed;
	boolean LimitState;
	
	/*
	 * This subsystem uses 4 motors for the claw,
	 * two pistons to open and close the claw, and a limit switch
	 * to stop the motors once the power cube is in the claw
	 */
	
	
	public CollectorSubsystem(){
		
		CollectorLeft = new Talon (RobotMap.CollectorLeft);
		CollectorLeft1 = new WPI_TalonSRX (RobotMap.CollectorLeft1);
		CollectorRight = new WPI_TalonSRX (RobotMap.CollectorRight);
		CollectorRight1 = new Talon (RobotMap.CollectorRight1);
		Piston = new DoubleSolenoid (RobotMap.CollectorPistonsOn, RobotMap.CollectorPistonsOff);
		CollectorLimit = new DigitalInput (RobotMap.CollectorLimitSwitch);
		LimitState = CollectorLimit.get();
		Speed = RobotMap.Speed; //Used to set the speed of the motors

	}
	
	public void collectorIn(){
		
			CollectorLeft.set(Speed);
			CollectorLeft1.set(Speed);	
			CollectorRight.set(-Speed);
			CollectorRight1.set(-Speed);
		
	}
	
	public void closePiston(){
		
		Piston.set(DoubleSolenoid.Value.kForward);
		
	}

	public void openPiston(){
		
		Piston.set(DoubleSolenoid.Value.kReverse);
		
	}
	
	public void collectorOut(){
		
		CollectorLeft.set(-Speed);
		CollectorLeft1.set(-Speed);
		CollectorRight.set(Speed);
		CollectorRight1.set(Speed);
		
	}
	
	
	
	public void collectorOff(){
		
		CollectorLeft.set(0);
		CollectorLeft1.set(0);
		CollectorRight.set(0);
		CollectorRight1.set(0);
		
	}
	
	public boolean getLimit(){
		
		return LimitState;
		
	}

	
	
	public void initDefaultCommand() {
	
		
		
	}
}
