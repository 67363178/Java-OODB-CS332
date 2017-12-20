import java.util.*;
@javax.jdo.annotations.PersistenceCapable
public class Payment {
	Float amount;
	String method;
	
	CustomerAccount payments;
	//inverse
	HashSet<Ticket> ticket = new HashSet<Ticket>();
	

}
