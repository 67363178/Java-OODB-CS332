import java.util.*;
@javax.jdo.annotations.PersistenceCapable
public class Event implements Comparable<Event>{

	String name;
	String date;
	
	//inverse of Performer, Ticket, Price and SingleVenue
	SingleVenue holdBy;
	
	TreeSet<Performer> performBy = new TreeSet<Performer>();
	
	TreeSet <Ticket> ticketOfEvent= new TreeSet<Ticket>();
	HashSet<Price> priceOfevent=new HashSet<Price>();
	
	public Event(String event, String date, SingleVenue v){
		this.name=event;
		this.date=date;
		this.holdBy=v;
		//this.holdBy=v;
	}
	
	public Event(SingleVenue v,TreeSet<Ticket> t,HashSet<Price> p) {
		// TODO Auto-generated constructor stub
		this.ticketOfEvent=t;
		this.priceOfevent=p;
	}
	/*// checking data in Event
	public String toString(){
		return  "Event name: "+name+" Event date: "+date+" Venue: "+holdBy+" Ticket: "+ticketOfEvent+" Price: "+priceOfevent;
	}*/
	
	public String toString(){
		return  "Event name: "+name+" Event date: "+date;
	}

	@Override
	public int compareTo(Event that) {
		return this.date.compareTo(that.date);	}
	
}
