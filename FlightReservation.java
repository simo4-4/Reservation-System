
public class FlightReservation extends Reservation {
	Airport depart;
	Airport arrival;
	
	public FlightReservation(String name,Airport a, Airport b) {
		super(name);
		
		if(a.equals(b)) {
			throw new IllegalArgumentException("same airport, not possible");
			
		}
		
		this.depart = a;
		this.arrival = b;
		
		
		
	}
	
	public int getCost() {
		
		int fullCost = 0; //in cents
		
		double distFees = (Airport.getDistance(this.depart,this.arrival)/167.52)*124;
		
		fullCost= (int) Math.ceil(distFees+5375+this.depart.getFees()+ this.arrival.getFees()) ;
		return fullCost;
	}
	
	public boolean equals(Object obj) { 
		if(obj instanceof FlightReservation) {
			FlightReservation fRes = (FlightReservation) obj;
			
			if(fRes.depart.equals(this.depart)&& fRes.reservationName().equalsIgnoreCase(this.reservationName()) && fRes.arrival.equals(this.arrival) ) {
				return true;
			}
			
		}
		
			return false;
	
	}
	
	
	
}
