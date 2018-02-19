package org.usfirst.frc.team3158.robot.subsystems.collector;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class CollectorSubsystem extends Subsystem {

	DigitalInput lsIntake;
	TalonSRX taIntakeFrontLeft,taIntakeFrontRight,taArmLeft,taArmRight,taIntakeBackLeft,taIntakeBackRight;
	boolean limitState;
	boolean isLimit;
	
	/*
	 * This subsystem uses 6 motors for the claw, and a limit switch
	 * to stop the motors once the power cube is in the claw
	 */
	
	public CollectorSubsystem(){
		
		taIntakeFrontLeft = new TalonSRX (0);
		taIntakeBackLeft = new TalonSRX (1);
		taIntakeFrontRight = new TalonSRX (2);
		taIntakeBackRight = new TalonSRX (3);
		taArmLeft = new TalonSRX(4);
		taArmRight = new TalonSRX(5);
		lsIntake = new DigitalInput(0);
		boolean limitState = false;
		boolean isLimit = false; 

	}
	
	public void collectorIn(){
		
		taIntakeFrontLeft.set(ControlMode.PercentOutput, 1);
		taIntakeFrontRight.set(ControlMode.PercentOutput, 1);
		taIntakeBackLeft.set(ControlMode.PercentOutput, 1);
		taIntakeBackRight.set(ControlMode.PercentOutput, 1);
		
	}
	
	
	public void collectorOutFront(){
		
		taIntakeBackLeft.set(ControlMode.PercentOutput, -0.5);
		taIntakeBackRight.set(ControlMode.PercentOutput, -0.5);
			
	}
	
	
	public void collectorOutBack(){
		
		taIntakeBackRight.set(ControlMode.PercentOutput, 0.5);
		taIntakeBackLeft.set(ControlMode.PercentOutput, 0.5);
		
	}
	
	public void collectorOff(){
		
		taIntakeFrontLeft.set(ControlMode.PercentOutput, 0);
		taIntakeFrontRight.set(ControlMode.PercentOutput, 0);
		taIntakeBackLeft.set(ControlMode.PercentOutput, 0);
		taIntakeBackRight.set(ControlMode.PercentOutput, 0);
		
	}
	
	
	public void openArm(){
		
		taArmLeft.set(ControlMode.PercentOutput, 0.5);
		taArmRight.set(ControlMode.PercentOutput, 0.5);
		
	}
	
	
	public void closeArm(){
		
		taArmLeft.set(ControlMode.PercentOutput, -0.5);
		taArmRight.set(ControlMode.PercentOutput, -0.5);
		
	}
	
	
	public boolean isLimit(){
		
		return isLimit;
		
	}
	
	public boolean limitState(){
		
		return limitState;
		
	}
	
	public void initDefaultCommand() {	
	}
	
	
	
}
