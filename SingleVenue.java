import java.util.*;
@javax.jdo.annotations.PersistenceCapable
public class SingleVenue extends Venue{

	TreeSet<Event> holds =new TreeSet<Event>();
	HashSet<Seat> seats=new HashSet<Seat>();
	
	//inverse of ComplexVenue-->SingleVenue
	ComplexVenue complexVenue;
	
	
	public SingleVenue(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	

	
	public String toString(){
		return  name;
	}
	
}
