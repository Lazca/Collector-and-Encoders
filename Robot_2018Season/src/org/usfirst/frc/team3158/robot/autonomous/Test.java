package org.usfirst.frc.team3158.robot.autonomous;

import org.usfirst.frc.team3158.robot.subsystems.chassis.GoStraight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Test extends CommandGroup {

    public Test() {
        
    	addSequential(new GoStraight());
    	
    }
}
