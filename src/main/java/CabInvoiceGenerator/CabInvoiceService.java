package CabInvoiceGenerator;

public class CabInvoiceService {
	private static final double MINIMUM_COST_PER_KM = 10;
	private static final int MIN_COST_PER_TIME = 1;
	private static final double MIN_TOTAL_FARE = 5;

	public double calculateFare(double distance, int time) {
		double totalFare = (distance * MINIMUM_COST_PER_KM) + (time * MIN_COST_PER_TIME);
		return Math.max(totalFare, MIN_TOTAL_FARE);
	}

	public double calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare = totalFare + calculateFare(ride.getDistance(), ride.getTime());
		};
		return totalFare;
	}
}
