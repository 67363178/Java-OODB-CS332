import java.util.*;
@javax.jdo.annotations.PersistenceCapable
public class ComplexVenue extends Venue {
	HashSet<SingleVenue> subVenues=new HashSet<SingleVenue>();
}
