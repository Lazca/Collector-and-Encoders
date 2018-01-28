package org.usfirst.frc.team3158.robots.commands;

import org.usfirst.frc.team3158.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GoStraight extends Command {

    public GoStraight() {

    	requires (Robot.driveTrainSubsystem);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.driveTrainSubsystem.GoStraight();
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
