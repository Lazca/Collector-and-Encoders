package org.usfirst.frc.team3158.robot.commands.collector;

import org.usfirst.frc.team3158.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CollectorIn extends Command {

    public CollectorIn() {

    	requires (Robot.collectorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.collectorSubsystem.collectorIn();
   
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
   
    	return true;
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	Robot.collectorSubsystem.collectorOff();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
