package CabInvoiceGenerator;

public class Ride {
	private double distance;
	private int time;
	public final CabRide cabRide;
	
	public Ride(CabRide cabRide, double distance, int time) {
		this.distance = distance;
		this.time = time;
		this.cabRide = cabRide;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}
