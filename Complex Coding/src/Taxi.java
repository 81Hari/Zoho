import java.util.ArrayList;
import java.util.List;

public class Taxi {
	
	int id;
	// Taxi Id 

	//Below are Lists, because single taxi can have many bookings 
	
	List<Integer> bookingId; 
	//To store the Booking id's allocated to the taxi
	
	List<Integer> customerId;	
	//To store the Customer's Customers id traveled in the taxi
	
	List<Character> pickup; 
	// To store the places where taxi picked up the customer 
	
	List<Character> drop; 
	// To store the places where taxi dropped the customer
	
	List<Integer> pickupTime; 
	// To store the timing of the pickup
	
	List<Integer> dropTime;	 
	// To store the timing of the drop
	
	List<Integer> amount; 
	// to store the Amount collected in each journey
	
	
	int totalEarning; 
	// Total Earnings (Sum of amount List)
	
	public Taxi(int id){
		
		this.id = id;
		this.bookingId = new ArrayList<Integer>();
		this.customerId = new ArrayList<Integer>();
		this.pickup = new ArrayList<Character>();
		this.drop = new ArrayList<Character>();
		this.pickupTime = new ArrayList<Integer>();
		this.dropTime = new ArrayList<Integer>();
		this.amount = new ArrayList<Integer>();
		this.totalEarning = 0;
		
	}	
	
	public Taxi(Taxi t) {
		this.id = t.id;
		this.bookingId = t.bookingId;
		this.customerId = t.customerId;
		this.pickup = t.pickup;
		this.drop = t.drop;
		this.pickupTime = t.pickupTime;
		this.dropTime = t.dropTime;
		this.amount = t.amount;
		this.totalEarning = t.totalEarning;
	}
	
	public void print() {
		System.out.printf("Taxi-%d \t Total Earnings: Rs. %d\n\n",id,totalEarning);
		
		System.out.printf("%-15s%-15s%-10s%-10s%-15s%-15s%-10s\n","BookingID","CustomerID", "From", "To", "PickupTime", "DropTime","Amount");
		for(int i=0;i<bookingId.size();i++) {
			System.out.printf("%-15d%-15d%-10c%-10c%-15d%-15d%-10d\n",bookingId.get(i),customerId.get(i),pickup.get(i),drop.get(i),pickupTime.get(i),dropTime.get(i),amount.get(i));
		}
		System.out.println("\n\n");
	}

}


