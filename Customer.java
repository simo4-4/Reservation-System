
public class Customer {
	private String name;
	private int balance = 0; //in cents
	private Basket basket; //reservations customer would like to make
	
	public Customer(String name, int iniBalance) {
		this.name = name;
		this.balance = iniBalance;
		
		this.basket = new Basket();
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public Basket getBasket() {
		
		return this.basket;
		
	}
	
	public int addFunds(int addToBalance) { //works
		if(addToBalance<0) {
			throw new IllegalArgumentException("negative value, not possible");
		}
		
		this.balance = this.balance + addToBalance;
		return this.balance;
	}
	
	public int addToBasket(Reservation res) { //works
		
		//System.out.println("basket = " + this.basket);
		
		if(this.getName().equalsIgnoreCase(res.reservationName())){
			this.basket.add(res);
			return basket.getNumOfReservations();
			
		}
		
		else {
		
			throw new IllegalArgumentException("not possible, names don't match");
		
		}
		
	}
	
	public int addToBasket(Hotel h, String roomType, int numNights, boolean bFastOrNot) {
		
		if(bFastOrNot) { //if there will be a breakfast
			
		BnBReservation bNBRes = new BnBReservation(this.name, h, roomType, numNights);
		this.basket.add(bNBRes);
			
		}
		
		else {
		HotelReservation hRes = new HotelReservation(this.name, h, roomType, numNights);
		this.basket.add(hRes);
		}
		
		return this.basket.getNumOfReservations();
		
	}
	
	public int addToBasket(Airport a, Airport b) { //check this
		FlightReservation flightres = new FlightReservation(this.name, a, b);
		int numOfRes = basket.getNumOfReservations();
		//if successfull
		if (basket.add(flightres)==numOfRes+1) {
			//FlightReservation fRes = new FlightReservation(this.name, a,b);
			this.basket.add(flightres);
			return basket.getNumOfReservations();
			
		}

		//if not successfull, return original number of reservations
		return numOfRes;
		
		
	}
	
	public boolean removeFromBasket(Reservation res) {
		return this.basket.remove(res);
	}
	
	public int checkOut() {
		if(this.basket.getTotalCost() <= this.balance) {
			this.balance = this.balance - this.basket.getTotalCost();
			this.basket.clear();
			return this.balance;
		}
		
		else {
		throw new IllegalArgumentException("not enough funds");
		}
		
	}
	

	
}
