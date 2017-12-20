import java.util.*;
@javax.jdo.annotations.PersistenceCapable
public class Seat {

	String label;
	
	//inverse 
	SingleVenue singleVenue;
	HashSet<Price> seats= new HashSet<Price>();
	TreeSet<Ticket>seat=new TreeSet<Ticket>();
	
	public Seat(String label, SingleVenue v) {
		// TODO Auto-generated constructor stub
		this.singleVenue=v;
		this.label=label;
	}
	/* checking data
	public String toString(){
		
		return  "SeatLabel "+label+ " SeatPrice "+seats+ seat+ singleVenue;
	}*/

	public String toString(){	
		return  "SeatLabel "+label;
	}
	
}
