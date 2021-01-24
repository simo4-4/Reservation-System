
public class Airport {
	
	private int xCoor ; //x-coordinate of the airport on a world map,scale 1km
	private int yCoor ;//y-coordinate of the airport on a world map,scale 1km
	private int airfees ; //airport fees in cents associated to this airport
	
	public Airport(int xCoor, int yCoor, int airfees) { //constructor
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		this.airfees = airfees;
		
	}
	
	public int getFees() { //returns airfees
		return this.airfees;
	}
	
	public static int getDistance(Airport a, Airport b) {
		
		
		double dd1 = Math.sqrt(Math.pow(a.xCoor-b.xCoor, 2)+ Math.pow(a.yCoor-b.yCoor, 2));
		int distance = (int) Math.ceil(dd1);
	
		
		return distance;
	}
	
	
	

}


