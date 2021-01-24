
public class BnBReservation extends HotelReservation {
	public BnBReservation(String nameRes, Hotel r, String roomType, int numNights) {
		super(nameRes, r, roomType, numNights);
	}
	
	public int getCost() {
		return (this.numNights*(this.pricePerNight+1000));
	}
}
