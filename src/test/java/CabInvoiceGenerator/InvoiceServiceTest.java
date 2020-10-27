package CabInvoiceGenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
	Ride[] rides = null;
	CabInvoiceService invoiceService = null;
	InvoiceSummary expectedSummary = null;
	private RideRepository rideRepository = null;

	@Before
	public void setUp() throws Exception {
		invoiceService = new CabInvoiceService();
		rideRepository = new RideRepository();
		invoiceService.setRideRepository(rideRepository);
		rides = new Ride[] {
				new Ride(Ride.Normal, 2.0, 5),
				new Ride(Ride.PREMIUM, 0.1, 1)
		};
		expectedSummary = new InvoiceSummary(2, 45);
	}

	@Test
	public void givenDistanceAndTime_ShouldReturnTotalFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistanceAndTime_ShouldReturnMinFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}
	
	@Test
	public void givenMultipleRides_shouldReturnInvoiceSummary() {
		Ride[] ride = { new Ride(2.0, 5), new Ride(0.1, 1) };
		InvoiceSummary summary = invoiceService.calculateFare(ride);
		InvoiceSummary expectedSummary =  new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedSummary, summary);
	}
	
	@Test
	public void givenUserIdAndRides_shouldReturnInvoiceSummary() {
		String userId = "a@b.com";
		invoiceService.addRides(userId, rides);
		InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedSummary, summary);
	}
}
