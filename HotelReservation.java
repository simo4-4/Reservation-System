
public class HotelReservation extends Reservation {
	Hotel r ; 
	
	String typeRoomReserve;
	int numNights = 0;
	int pricePerNight = 0; //in cents
	
	public HotelReservation(String nameRes, Hotel h, String typeRoom, int numNights) {
		super(nameRes); //not sure if this is where I should place it
		
		if((typeRoom.equalsIgnoreCase("double") || typeRoom.equalsIgnoreCase("queen") || typeRoom.equalsIgnoreCase("king")) == false){
			throw new IllegalArgumentException("Such hotel reservation is not possible");
		}
		
		else {
		this.r = h;
		this.typeRoomReserve = typeRoom;
		this.numNights = numNights;
		
		
		
		if(typeRoom.equalsIgnoreCase("double")) {
			 this.pricePerNight = 9000;
			 h.reserveRoom(typeRoom);
			 
		 }
		 
		 else if(typeRoom.equalsIgnoreCase("queen")) {
			 this.pricePerNight = 11000;
			 h.reserveRoom(typeRoom);
		 }
		 
		 else if(typeRoom.equalsIgnoreCase("king")) {
			 this.pricePerNight = 15000;
			 h.reserveRoom(typeRoom);
		 }
		}
		
	}
	
	public int getNumOfNights() {
		return this.numNights;
	}
	
	public int getCost() {
//		Room ttt = new Room(this.typeRoomReserve);
//		ttt.changeAvailability();
		return (this.numNights*this.pricePerNight); //we never actually use pricePernight
	}
	
	public boolean equals(Object obj) { //not sure...... override equals (deep comparison)(downcast)
		if(obj instanceof HotelReservation) {				
				HotelReservation hr = (HotelReservation) obj;
				
				if(hr.r.equals(this.r) && hr.typeRoomReserve.equalsIgnoreCase(this.typeRoomReserve) && hr.numNights==(this.numNights) && hr.pricePerNight==this.pricePerNight)
				return true;
			
		}
		
			return false;
	
	
	}
	
	
}
