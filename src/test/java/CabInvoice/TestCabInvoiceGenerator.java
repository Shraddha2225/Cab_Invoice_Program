package CabInvoice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCabInvoiceGenerator {
    private InvoiceService invoiceService =null;

    @Before
    public void setUp() throws Exception {
        invoiceService = new InvoiceService();
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance=2.0;
        int time=5;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(25.0,fare,0.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinFare() {
        double distance=0.1;
        int time=1;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5.0,fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5),new Ride(0.1, 1)};
        InvoiceSummary invoiceSummary  = invoiceService.calculateFare(rides);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedSummary,invoiceSummary);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
        String useriD="b@b.com";
        Ride[] rides = {new Ride(2.0, 5),new Ride(0.1, 1)};
        invoiceService.addRides(useriD,rides);
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(useriD);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedSummary,invoiceSummary);
    }

}
