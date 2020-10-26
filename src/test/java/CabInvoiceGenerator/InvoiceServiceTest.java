package CabInvoiceGenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
	CabInvoiceService invoiceService = null;

	@Before
	public void setUp() throws Exception {
		invoiceService = new CabInvoiceService();
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
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		InvoiceSummary summary = invoiceService.calculateFare(rides);
		InvoiceSummary expectedSummary =  new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedSummary, summary);
	}
	
	@Test
	public void givenUserIdAndRides_shouldReturnInvoiceSummary() {
		String userId = "a@b.com";
		Ride[] rides = { new Ride(2.0, 5), 
				 new Ride(0.1, 1)
				};
		invoiceService.addRides(userId, rides);
		InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedSummary, summary);
	}
}
