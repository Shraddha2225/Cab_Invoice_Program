package CabInvoice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<String, ArrayList<Ride>> userRides=null;

    public RideRepository() {
        this.userRides = new HashMap<>();
    }

    public void addRide(String useriD, Ride[] rides) {

        ArrayList<Ride> rideList =this.userRides.get(useriD);

        if(rideList==null)
        {
            this.userRides.put(useriD,new ArrayList<>(Arrays.asList(rides)));
        }

    }

    public Ride[] getRides(String useriD) {
        return this.userRides.get(useriD).toArray(new Ride[0]);
    }
}
