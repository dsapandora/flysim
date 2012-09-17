package org.flysim.AI;

import org.flysim.Simulator.FlyControlInterface;
import org.flysim.Simulator.FlySensorsInterface;

public class AI implements Runnable{
	
	private FlyControlInterface control;
	private FlySensorsInterface sensors;
	
	private double extTime;

	public AI(FlyControlInterface pControl, FlySensorsInterface pSensors) {
		control = pControl;
		sensors = pSensors;
	}
	
	public void run() {
		while (true) {
			getSituation();
			calcControls();
		}
	}
	
	private void getSituation() {
		//System.out.println("AI getSituation");
		extTime = sensors.getSystemTime();
	}
	
	private void calcControls() {
		//System.out.println("AI calcControls");
		int tp = (int) extTime;
		int tt = ((int) (extTime / 2)) % 4;
		
		double aileron = 50;
		double elevator = 50;
		double rudder = 50;
		double throttle = 50;
		if (tp<=2) {
			throttle = 50.1;
		}
		
		if (tp>6)
		switch (tt) {
		case 0:
			elevator = 70;
			break;
		case 1:
			aileron = 70;
			break;
		case 2:
			elevator = 30;
			break;
		case 3:
			aileron = 30;
			break;
		default:
			break;
		}
		
		control.setAileron(aileron);
		control.setElevator(elevator);
		control.setRudder(rudder);
		control.setThrottle(throttle);
		
		
	}
}
