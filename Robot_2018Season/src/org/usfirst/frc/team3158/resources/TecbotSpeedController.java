package org.usfirst.frc.team3158.resources;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedController;

public class TecbotSpeedController {

	private TalonSRX cant;
	private SpeedController t;
	private boolean isCan = false;

	public TecbotSpeedController(int port, boolean isSRX) {
		isCan = isSRX;
		if (isSRX)
			cant = new TalonSRX(port);
		else
			t = new PWMTalonSRX(port);
	}

	public void set(double speed) {
		if (isCan) {
			cant.set(ControlMode.PercentOutput, speed);
		} else {
			t.set(speed);
		}
	}
	
	public double getEncPosition(){
		if(isCan)
			return cant.getSelectedSensorPosition(0);
		else return 0.0;
		
}
	
}
