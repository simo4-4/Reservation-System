
public class Room {
	
	private String typeRoom ; //type of the room
	private int roomPrice = 0; //indicates the print(in cents) of the room
	private boolean roomAvailable; //indicates whether room is available or not
	
	public Room(String typeRoom) {
					//not sure what to take as input String or Room type
		 if(typeRoom.equalsIgnoreCase("double")) {
			 this.roomPrice = 9000;
			 this.roomAvailable = true;
			 this.typeRoom = "double";
		 }
		 
		 else if(typeRoom.equalsIgnoreCase("queen")) {
			 this.roomPrice = 11000;
			 this.roomAvailable = true;
			 this.typeRoom = "queen";
		 }
		 
		 else if(typeRoom.equalsIgnoreCase("king")) {
			 this.roomPrice = 15000;
			 this.roomAvailable = true;
			 this.typeRoom = "king";
		 }
		 
		 else {
			 throw new IllegalArgumentException("no room of such type can be created");
		 }
		
	}
	
	public Room(Room r) {
		//Room roomCopy = new Room(r.typeRoom); //is this right or should I use this.
		
		this.roomAvailable = r.roomAvailable;
		this.roomPrice = r.getPrice();  //this. or roomCopy.?	
		this.typeRoom =r.getType();
		
	}
		
//		
	
	public String getType() {
		return this.typeRoom;
	}
	
	public int getPrice() {
		return this.roomPrice;
	}
	
	public void changeAvailability() { //does opposite
		
		this.roomAvailable = !this.roomAvailable;
		 
	}
	
	public static Room findAvailableRoom(Room[] allRooms, String typeRoom) { //finds first available room of such typeRoom
		for(int i = 0; i < allRooms.length; i++) {
			
			if(allRooms[i].typeRoom.equalsIgnoreCase(typeRoom)) {
				
				if(allRooms[i].roomAvailable == true) {
					
					return allRooms[i];
				}
			}
		}
		return null;
	}
	
	public static boolean makeRoomAvailable(Room[] allRooms, String typeRoom) { //makes first room in such typeroom available again
		for(int i = 0; i < allRooms.length; i++) {
			if(allRooms[i].typeRoom.equalsIgnoreCase(typeRoom) && allRooms[i].roomAvailable == false) {
				
				allRooms[i].roomAvailable = true;
				return true;
				
			}
		}
		return false;
	}
	


}
