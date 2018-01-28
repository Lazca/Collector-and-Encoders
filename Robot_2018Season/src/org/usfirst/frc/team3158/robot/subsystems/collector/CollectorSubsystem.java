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

	
	
	//DigitalInput CollectorLimit = new DigitalInput (RobotMap.CollectorLimitSwitch);
	Talon CollectorLeft; 
	WPI_TalonSRX CollectorLeft1;
	SpeedController CollectorRight;
	Talon CollectorRight1;
	//DoubleSolenoid Piston;
	
	Double Speed;
	
	public CollectorSubsystem(){
		
		CollectorLeft = new Talon (RobotMap.CollectorLeft);
		//CollectorLeft1 = new WPI_TalonSRX (RobotMap.CollectorLeft1);
		CollectorRight = new Talon (RobotMap.CollectorRight);
		//CollectorRight1 = new WPI_TalonSRX (RobotMap.CollectorRight1);
		//Piston = new DoubleSolenoid (RobotMap.CollectorPistonsOn, RobotMap.CollectorPistonsOff);
		
	
		Speed = RobotMap.Speed;   

	}
	
	
	//boolean LimitState;
	
	@SuppressWarnings("deprecation")
	public void CollectorIn(){
		
			CollectorLeft.set(-Speed);
			//CollectorLeft1.set(Speed);	
			CollectorRight.set(-Speed);
			//CollectorRight1.set(-Speed);
			
		//SmartDashboard.putNumber("Encoder Period", encoder.getPeriod());
		
	}
	
	public void ClosePiston(){
		
		//Piston.set(DoubleSolenoid.Value.kForward);
		
	}

	public void OpenPiston(){
		
		//Piston.set(DoubleSolenoid.Value.kReverse);
		
	}
	public void CollectorOut(){
		
		
		CollectorLeft.set(Speed);
		//CollectorLeft1.set(-Speed);
		CollectorRight.set(Speed);
		//CollectorRight1.set(Speed);
		
		
		
		
	}
	
	
	
	public void CollectorOff(){
		
		CollectorLeft.set(0);
		//CollectorLeft1.set(0);
		CollectorRight.set(0);
		//CollectorRight1.set(0);
		
	}
	
	//public boolean GetLimit(){
		
		//return LimitState;
		
	

	
	
	public void initDefaultCommand() {
	
		
		
	}
}
