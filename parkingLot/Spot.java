package parkingLot;

import java.util.Date;

public class Spot {
    VechicleType vechicleType;
    String id;
    User OccupiedBy;
    Date startTime;

    public Spot(VechicleType vehicleType,String id){
        this.vechicleType = vehicleType;    
        this.id = id;
        this.OccupiedBy = null;
        this.startTime = null;
    }

    public VechicleType getVechicleType() {
        return vechicleType;
    }

    public void setVechicleType(VechicleType vechicleType) {
        this.vechicleType = vechicleType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getOccupiedBy() {
        return OccupiedBy;
    }

    public void setOccupiedBy(User occupiedBy) {
        OccupiedBy = occupiedBy;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    
}
