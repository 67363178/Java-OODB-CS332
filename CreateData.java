import java.util.*;
import javax.jdo.*;
import com.objectdb.Utilities;

public abstract class CreateData {
	public static void main(String args[]){
		SingleVenue v1= new SingleVenue("venue1");
		
		Event e1=new Event("event1","01/20/2018",v1);
		Event e2=new Event("event2","02/10/2018",v1);
		Event e3=new Event("event3","03/15/2018",v1);
		Event e4=new Event("event4","03/16/2018",v1);
		
		//note:
		Seat s1=new Seat("001",v1);
		Seat s2=new Seat("002",v1);
		Seat s3=new Seat("003",v1);
		Seat s4=new Seat("004",v1);
		Seat s5=new Seat("005",v1);
		
		Price p1=new Price(20);
		Price p2=new Price(30);
		Price p3=new Price(40);
		Price p4=new Price(50);
		Price p5=new Price(60);
		
		//Since 
		Ticket t1=new Ticket("T001");
		Ticket t2=new Ticket("T002");
		Ticket t3=new Ticket("T003");
		Ticket t4=new Ticket("T004");
		
		
		PersistenceManager pm = Utilities.getPersistenceManager("ticket.odb");//a 
	
		pm.currentTransaction().begin();
		
		pm.makePersistent(e1);
		pm.makePersistent(e2);
		pm.makePersistent(e3);
		pm.makePersistent(e4);
		
		//We don't need the makePersistent v1 since e1.holdBy=v1; and s1.singleVenue=v1
		//persistence-by-reachability
		//pm.makePersistent(v1);
		
		pm.makePersistent(s1);
		pm.makePersistent(s2);
		pm.makePersistent(s3);
		pm.makePersistent(s4);
		pm.makePersistent(s5);
		
		pm.makePersistent(p1);
		pm.makePersistent(p2);
		pm.makePersistent(p3);
		pm.makePersistent(p4);
		pm.makePersistent(p5);
		
		pm.makePersistent(t1);
		pm.makePersistent(t2);
		pm.makePersistent(t3);
		pm.makePersistent(t4);
		pm.currentTransaction().commit();
		
		
		pm.currentTransaction().begin();
		e1.holdBy=v1;
		e2.holdBy=v1;
		e3.holdBy=v1;
		e4.holdBy=v1;
		
		e1.ticketOfEvent.add(t1);
		e1.ticketOfEvent.add(t2);
		
		e2.ticketOfEvent.add(t3);
		e3.ticketOfEvent.add(t4);
		e4.ticketOfEvent.add(t4);
		
		e1.priceOfevent.add(p1);
		e1.priceOfevent.add(p2);
		e2.priceOfevent.add(p3);
		e3.priceOfevent.add(p5);
		e4.priceOfevent.add(p5);
		pm.currentTransaction().commit();
		
		pm.currentTransaction().begin();
		//Seat price
		s1.seats.add(p1);
		s2.seats.add(p1);
		s2.seats.add(p3);
		s3.seats.add(p1);
		s3.seats.add(p4);
		s4.seats.add(p2);
		s4.seats.add(p4);
		s5.seats.add(p4);
		s5.seats.add(p2);
		
		//Seat ticket
		s1.seat.add(t1);
		s1.seat.add(t3);
		s4.seat.add(t2);
		pm.currentTransaction().commit();
		
		//Price
		pm.currentTransaction().begin();
		p1.seats.add(s1);
		p1.seats.add(s2);
		p1.seats.add(s3);
		p1.eventsOfPrice.add(e1);
		p1.price.add(t1);
		
		p2.seats.add(s4);
		p2.seats.add(s5);
		p2.eventsOfPrice.add(e1);
		p2.price.add(t2);
		
		p3.seats.add(s1);
		p3.seats.add(s2);
		p3.eventsOfPrice.add(e2);
		p3.price.add(t3);
		
		p4.seats.add(s3);
		p4.seats.add(s4);
		p4.seats.add(s5);
		p4.eventsOfPrice.add(e2);
		
		p5.eventsOfPrice.add(e3);
		p5.eventsOfPrice.add(e4);
		p5.price.add(t4);
		pm.currentTransaction().commit();
		
		//Ticket
		pm.currentTransaction().begin();
		t1.eventOfTicket.add(e1);
		t1.price=p1;
		t1.seat=s1;
		
		t2.eventOfTicket.add(e1);
		t2.price=p2;
		t2.seat=s4;
		
		t3.eventOfTicket.add(e2);
		t3.price=p3;
		t3.seat=s1;

		t4.eventOfTicket.add(e3);
		t4.eventOfTicket.add(e4);
		t4.price=p5;
		
		pm.currentTransaction().commit();
		
		
		System.out.println( "print Event:" );
		Query q = pm.newQuery(
		        "select "+
			"from Event "
		       );
		Collection<Price> ee = (Collection<Price>) q.execute();
		Utility.printCollection( ee );
		q.closeAll();
		System.out.println();
		
		System.out.println( "print Price:" );
		 q = pm.newQuery(
		        "select "+
			"from Price "
		       );
		Collection<Price> pp = (Collection<Price>) q.execute();
		Utility.printCollection( pp );
		q.closeAll();
		System.out.println();
		
		System.out.println( "print Venue:" );
		 q = pm.newQuery(
		        "select "+
			"from SingleVenue "
		       );
		Collection<SingleVenue> v = (Collection<SingleVenue>) q.execute();
		Utility.printCollection( v );
		q.closeAll();
		System.out.println();
		
		System.out.println( "print Seat:" );
		 q = pm.newQuery(
		        "select "+
			"from Seat "
		       );
		Collection<Seat> s = (Collection<Seat>) q.execute();
		Utility.printCollection( s );
		q.closeAll();
		System.out.println();
		
		System.out.println( "print Ticket:" );
		 q = pm.newQuery(
		        "select "+
			"from Ticket "
		       );
		Collection<Ticket> t = (Collection<Ticket>) q.execute();
		Utility.printCollection( t );
		q.closeAll();
		System.out.println();
			

		if ( !pm.isClosed() )
       			pm.close();
		
	}
	

}
