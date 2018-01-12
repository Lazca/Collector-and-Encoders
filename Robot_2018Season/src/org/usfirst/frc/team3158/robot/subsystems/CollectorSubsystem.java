package org.usfirst.frc.team3158.robot.subsystems;

import org.usfirst.frc.team3158.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3158.robot.commands.CollectorOff;;
/**
 *
 */
public class CollectorSubsystem extends Subsystem {

	CANTalon CollectorLeft = new CANTalon (RobotMap.CollectorLeft);
	CANTalon CollectorRight = new CANTalon (RobotMap.CollectorRight);
	DoubleSolenoid Piston = new DoubleSolenoid (RobotMap.CollectorPistonsOn, RobotMap.CollectorPistonsOff);
	DigitalInput CollectorLimit = new DigitalInput (RobotMap.CollectorLimitSwitch);
	double SwitchSpeed = RobotMap.SwitchSpeed;
	double ScaleSpeed = RobotMap.ScaleSpeed;
	boolean LimitState;
	
	public void CollectorIn(){
		
		LimitState = CollectorLimit.get();
		
		if(!LimitState){
		
			CollectorLeft.set(0.5);
			CollectorRight.set(-0.5);
			
		}
		
		if(LimitState){
			
			CollectorLeft.set(0);
			CollectorRight.set(0);
			Piston.set(DoubleSolenoid.Value.kForward);
	
		}
		
		System.out.println("LimitState" + LimitState);
		
	}

	public void CollectorOutSwitch(){
		
		Piston.set(DoubleSolenoid.Value.kReverse);
		CollectorLeft.set(SwitchSpeed);
		CollectorRight.set(-SwitchSpeed);
	
	}
	
	public void CollectorOutScale(){
		
		Piston.set(DoubleSolenoid.Value.kReverse);
		CollectorLeft.set(ScaleSpeed);
		CollectorRight.set(-ScaleSpeed);
		
	}
	
	public void CollectorOff(){
		
		CollectorLeft.set(0);
		CollectorRight.set(0);
		
	}
	
	public boolean GetLimit(){
		
		return LimitState;
		
	}

	
	
	public void initDefaultCommand() {
	
		setDefaultCommand(new CollectorOff());
		
	}
}
