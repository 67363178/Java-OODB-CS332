import java.util.*;
@javax.jdo.annotations.PersistenceCapable
public class Ticket implements Comparable<Ticket>{
//n array relation?
	String IDcode;
	
	Seat seat;
	Price price;
	Payment payment;
	
	TreeSet<Event> eventOfTicket= new TreeSet<Event>();
	
	public Ticket(String idCode) {
		// TODO Auto-generated constructor stub
		this.IDcode=idCode;
	}
	
	public Ticket(TreeSet<Event> e ,Seat s, Price p, Payment pp){
		this.eventOfTicket=e;
		this.seat=s;
		this.payment=pp;
		this.price=p;
	}
	/*
	public String toString(){
		//payment is not provide in the diagram
		return "TicketId: "+IDcode+" "+eventOfTicket+" "+seat+" "+"Event "+price+" "+payment;
	}*/
	
	public String toString(){
		//payment is not provide in the diagram
		return "TicketId: "+IDcode;
	}

	@Override
	public int compareTo(Ticket that) {
		// TODO Auto-generated method stub
		return this.IDcode.compareTo(that.IDcode);
		
	}
	
}
