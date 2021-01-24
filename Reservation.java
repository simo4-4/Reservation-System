
public abstract class Reservation { //do more research on abstract classes
	private String name;
	
	public Reservation(String clientName) {
		this.name = clientName;
		
	}
	
	final public String reservationName() {
		return this.name;
	}
	
	public abstract int getCost() ;
	
	public abstract boolean equals(Object obj) ; 
		
	
}
