package CabInvoice;

public class InvoiceSummary {
    private double averageFare;
    private double totalFare;
    private int nuOfRides;

    public InvoiceSummary(int numOfRides, double totalFare) {
        this.nuOfRides=numOfRides;
        this.totalFare=totalFare;
        this.averageFare=this.totalFare/this.nuOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return Double.compare(that.averageFare, averageFare) == 0 &&
                Double.compare(that.totalFare, totalFare) == 0 &&
                nuOfRides == that.nuOfRides;
    }
}
