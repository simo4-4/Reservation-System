
public class Basket { //represents list of reservations, make linkedlist
	private Reservation[] listRes;
	private int numRes ;
	
		public Basket() {
		//are we allowed to change classes so that I can count the amount of objects i made
		//int numRes =55; //should equal amount of reservation objects, find a way to count them
		this.listRes = new Reservation[numRes];
		this.numRes = 0;
			
		}
		
		public Reservation[] getProducts() {
			
			Reservation[] copyListRes = new Reservation[numRes];
			
			
			for(int i = 0; i<this.listRes.length; i++) {
				copyListRes[i]= this.listRes[i];
			}
			return copyListRes;
			
			
		}
		
		public int add(Reservation res) { //count how many Reservs were made and add a Reservation to end of list
			this.numRes++;
			
			Reservation[] newListRes = new Reservation[this.numRes];
			
			for(int i = 0; i<this.listRes.length; i++) {
				newListRes[i]= this.listRes[i];
			
			}
			
			
			newListRes[newListRes.length-1] = res; //adds input res to end
			
			
			
			this.listRes = newListRes;
			
			return this.numRes;
			
			
		}
		
		
		
		
		public boolean remove(Reservation r) {
			
			for(int i = 0; i< this.listRes.length; i++) {
				if(this.listRes[i].equals(r)) {//removing starts here
					
					if(i != this.listRes.length-1 ) { //checks if Reservation that I want to remove is not at the end
						for(int j = i; j< (this.listRes.length-1) ; j++ ) {//shifts
							
							this.listRes[j]=this.listRes[j+1];
							
						}
					}
					
					else {
						this.listRes[i] = null;
					}
					
					Reservation[] newListRes = new Reservation[this.listRes.length-1];
					
					for(int p = 0; p<this.listRes.length-1; p++) { //shallow copy
						newListRes[p]= this.listRes[p];
					
					}
					
					this.listRes = newListRes;
					//System.out.println("thislist="+this.listRes.toString());
					this.numRes--;
					return true;
				}
			}
			return false;
		}
		
		
		public void clear() {
			
			Reservation[] newListRes = new Reservation[0];
			this.listRes = newListRes;
			this.numRes = 0;
			
			
		}
		
		public int getNumOfReservations(){
			return numRes;
		}
		
		public int getTotalCost() {
			
			int totalCost = 0;
			
			for(int i = 0; i<numRes; i++) {
				totalCost= totalCost + listRes[i].getCost();
			}
			
			return totalCost;
			
		}
		
}
