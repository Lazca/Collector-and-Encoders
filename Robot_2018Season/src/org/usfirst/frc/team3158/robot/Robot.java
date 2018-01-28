
package org.usfirst.frc.team3158.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3158.robot.autonomous.Test;
import org.usfirst.frc.team3158.robot.subsystems.chassis.DriveTrainSubsystem;
import org.usfirst.frc.team3158.robot.subsystems.collector.CollectorSubsystem;
import org.usfirst.frc.team3158.robots.commands.EncoderDistanceTest;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {


	public static CollectorSubsystem collectorSubsystem;
	public static DriveTrainSubsystem driveTrainSubsystem;

	Command autonomousCommand;
	SendableChooser<Command> chooser;
	public static OI oi;
	

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		
		driveTrainSubsystem = new DriveTrainSubsystem();
		collectorSubsystem = new CollectorSubsystem();
		oi = new OI();	


		chooser = new SendableChooser();
		
		chooser.addDefault("Default", new EncoderDistanceTest());	
		//chooser.addObject("Test", new Test());
		chooser.addObject("EncoderTest", new EncoderDistanceTest());
		SmartDashboard.putData("Auto mode chooser", chooser);
		
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * choos	er code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();
		
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
		
	
		
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		//Scheduler.getInstance().run();
	
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		
		
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		SmartDashboard.putNumber("Encoder Rate", Robot.driveTrainSubsystem.getEncoderRate());
		SmartDashboard.putNumber("Encoder Period", Robot.driveTrainSubsystem.getEncoderPeriod());
		SmartDashboard.putNumber("Encoder Distance", Robot.driveTrainSubsystem.getEncoderDistance());
		SmartDashboard.putNumber("Encoder Distance Per Pulse", Robot.driveTrainSubsystem.getDistancePerPulse());
		SmartDashboard.putNumber("Encoder Raw", Robot.driveTrainSubsystem.getEncoderRaw());
		
		
		if(Robot.oi.A.get()== true && Robot.driveTrainSubsystem.getEncoderRate() < 0){
			
			System.out.println("Error, negative values");
			
		}
		
		if(Robot.oi.X.get()== true && Robot.driveTrainSubsystem.getEncoderRate() > 0){
			
			System.out.println("Error, positive values");
			
		}
		
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
