import java.util.*;
@javax.jdo.annotations.PersistenceCapable 
public class CustomerAccount {
	String name;
	String email;
	
	HashSet<Payment> payments = new HashSet<Payment>();
}
