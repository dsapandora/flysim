package org.flysim.Simulator;

public interface FlySensorsInterface {
	
	public Vector getAccelerometer();
	public Vector getGyroscope();
	public double getUsBottom();
	
	public double getUsForward();
	public double getUsBackward();
	public double getUsLeft();
	public double getUsRight();

	public double getSystemTime();
}
