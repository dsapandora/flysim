package org.flysim.Simulator;

public class Vector {
	public double x;
	public double y;
	public double z;
	
	public Vector() {
	}
	
	public Vector(double px, double py, double pz) {
		this.x = px;
		this.y = py;
		this.z = pz;
	}
	
	public Vector plus(Vector a) {
		Vector result = new Vector(this.x+a.x, this.y+a.y, this.z+a.z);
		return result;
	}
	
	public Vector neg() {
		Vector result = new Vector(0-this.x, 0-this.y, 0-this.z);
		return result;
	}
	
	public Vector mul(double a) {
		Vector result = new Vector(this.x*a, this.y*a, this.z*a);
		return result;
	}
	
	public double mul(Vector a) {
		double result = this.x*a.x + this.y*a.y + this.z*a.z;
		return result;
	}
	
	public double abs() {
		double result = Math.sqrt(x*x + y*y + z*z);
		return result;
	}
	
	public Vector norm() {
		double abs = this.abs();
		Vector result = new Vector(0,0,0);
		if (abs>0) {
			result = this.mul(1/abs);
		}
		return result;
	}
	

	public String toString() {
		String result = String.format("x=%f y=%f z=%f", x, y, z);
		return result;
	}
	
}
