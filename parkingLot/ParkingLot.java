package parkingLot;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// OWNER(Raj Kaneriya raj0408)
public final class ParkingLot {

/*
lass ParkingLot:
    totalCapacity: int
    spots: Spots[]
    activeTickets: Map<String, Ticket>  // ticketId -> Ticket for quick lookup
    hourlyRate: int  // in cents to avoid float precision issues

    // Single entry point — finds spot, creates ticket, marks spot occupied
    enter(vehicleType): returns Ticket | NULL

    // Single exit point — validates ticket, calculates fee, frees spot, invalidates ticket
    exit(ticketId): returns Amount | NULL  // returns null for invalid/already-used ticket

    checkCurrentOccupied(): returns Spots[]

    // getter methods for data analytics filtering by vehicle type etc.
    getOccupiedSpotsByVehicleType(vehicleType): returns Spots[]

    // private helpers — not exposed publicly, used internally by enter/exit
    private getAvailableSpot(vehicleType): returns Spots | NULL
    private calculateBilling(Ticket, exitTime): returns Amount
    private freeSpot(spotId): returns TRUE | FALSE
*/
    
    int totalCapacity;
    List<Spot> spots;
    Map<String,String> activeTicket;
    int hourlyRate;

    public ParkingLot(int totalCapacity,List<Spot> spots,Map<String,String> activeTickets,int hourlyRate) {
        this.activeTicket = activeTickets;
        this.totalCapacity = totalCapacity;
        this.hourlyRate = hourlyRate;
        this.spots = spots;
    }

    public Ticket Enter(VechicleType vechicleType){

        
        List<Spot> availabeSpots = this.spots.stream().filter(spot -> spot.vechicleType == vechicleType).filter(spot -> spot.OccupiedBy == null).collect(Collectors.toList());
        if(availabeSpots.isEmpty()){
            return null;
        }

        // lock
        Ticket t = new Ticket(1,new Date());

        
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public List<Spot> getSpots() {
        return Collections.unmodifiableList(spots);
    }

    public Map<String, String> getActiveTicket() {
        return Collections.unmodifiableMap(activeTicket);
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    
}
