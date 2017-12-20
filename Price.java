import java.util.*;
@javax.jdo.annotations.PersistenceCapable
public class Price {
	
	float amount;
	HashSet<Seat> seats=new HashSet<Seat>();
	TreeSet<Event> eventsOfPrice=new TreeSet<Event>();
	
	//inverse
	TreeSet<Ticket> price=new TreeSet<Ticket>();
	
	public Price(float price) {
		// TODO Auto-generated constructor stub
		this.amount=price;
	}
	
	public Price(HashSet<Seat>s, TreeSet<Event>e, TreeSet<Ticket>t){
		this.seats=s;
		this.eventsOfPrice=e;
		this.price=t;
	}
	/* checking data
	public String toString(){
		return  "Price: "+Float.toString(amount)+" Seats: "+seats+" Event: "+eventsOfPrice+" Ticket: "+price;
	}*/
	
	public String toString(){
		return  "Price: "+Float.toString(amount);
	}
}
