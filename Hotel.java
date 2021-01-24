
public class Hotel {
	private String hotelName;
	private Room[] allRooms;
	
	public Hotel(String r, Room[] room) {
		//deep copy of room
		this.hotelName = r;
		this.allRooms = new Room[room.length];
		
		for(int i=0; i<room.length; i++) { //deep copy
			Room rr = new Room(room[i]);
			this.allRooms[i] = rr; 			
			
		}	
		
	}
	
	public int reserveRoom(String typerRoom) {
		Room c = Room.findAvailableRoom(this.allRooms, typerRoom);
		
		//System.out.println("c="+c);
		if(c != null) {
			c.changeAvailability();
			return c.getPrice();
		}
		else {
			throw new IllegalArgumentException("not possible");
		}
		
	}
	
	public boolean cancelRoom(String typerRoom) { //makes a room of that type available again
		
		return Room.makeRoomAvailable(this.allRooms, typerRoom);
	
	}
	
	
}
