package org.usfirst.frc.team3158.robot.autonomous;

import org.usfirst.frc.team3158.robot.commands.chassis.EncoderDistanceTest;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class EncoderTest extends CommandGroup {

    public EncoderTest() {
       
    	addSequential(new EncoderDistanceTest());
    	
    	
    }
}
