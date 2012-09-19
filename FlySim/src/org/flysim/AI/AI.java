package org.flysim.AI;

import org.flysim.Simulator.FlyControlInterface;
import org.flysim.Simulator.FlySensorsInterface;

public class AI implements Runnable{
	
	private static final double RECALC_PERIOD = 0.05;

	private FlyControlInterface control;
	private FlySensorsInterface sensors;
	
	private double extTime;
	private double selfTime;
	private double lastTime = 0;

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
		//selfTime = System.currentTimeMillis()/1000.0;
		while (lastTime + RECALC_PERIOD > extTime) {
			long sleepTime = (long) ((lastTime + RECALC_PERIOD - extTime)*1000);
			System.out.printf("AI sleep to %d ms, lastTime=%f extTime=%f\n", sleepTime, lastTime, extTime);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("AI wake up\n", sleepTime);
			extTime = sensors.getSystemTime();
		}
		lastTime = extTime;
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
		
		if (tp>=8)
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
