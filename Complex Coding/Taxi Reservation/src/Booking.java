import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Booking {

	// -----BOOKING Elements-------
//----------------------------------------------------------------------------
	int id; 
	//Booking id
	
	int taxiId;
	//taxiId;
	
	int customerId;	
	//To store the Customer's Customers id
	
	char pickup; 
	// To store the place where the customer want to be picked up. 
	
	char drop; 
	// To store the place where the customer want to be dropped.
	
	int pickupTime; 
	// To store the time of the pickup.
	
	int dropTime;	 
	// To store the time of the drop.
	
	int amount; 
	// to store the Amount for the journey.
	
	
	
public Booking(int id, int taxiId, int custId, char pickup, char drop, int pickupTime, int dropTime, int amount) {
		this.id = id;
		this.taxiId = taxiId;
		this.customerId = custId;
		this.pickup = pickup;
		this.drop = drop;
		this.pickupTime = pickupTime;
		this.dropTime = dropTime;
		this.amount = amount;
		
		Taxis.get(taxiId-1).bookingId.add(id);
		Taxis.get(taxiId-1).customerId.add(custId);
		Taxis.get(taxiId-1).pickup.add(pickup);
		Taxis.get(taxiId-1).drop.add(drop);
		Taxis.get(taxiId-1).pickupTime.add(pickupTime);
		Taxis.get(taxiId-1).dropTime.add(dropTime);
		Taxis.get(taxiId-1).amount.add(amount);
		Taxis.get(taxiId-1).totalEarning += amount; 
		
	}
//----------------------------------------------------------------------------
	
	
	
	
	
	//--------STATIC Elements---------------------
	
//-----------------------------------------------------------------------------
	static List<Taxi> Taxis = new ArrayList<Taxi>();
	// Creating Object for Taxi Class
	
	static List<Customer> Customers = new ArrayList<Customer>();
	// Creating Object for Customer Class
	
	static List<Character> places = new ArrayList<Character>();
	// List of places
	
	static int noOfTaxi = 4;
	//Defining there are four taxi's
	
	static int noOfCustomer = 3;
	//Defining there are three taxi's
	
	static int noOfPlaces = 6;
	//Defining there are three taxi's
	
	//Initializing Taxi Objects and Customer objects
	static{
		
		for(int i =0;i<noOfTaxi;i++) {
			Taxis.add(new Taxi(i+1));
		}
		
		for(int i =0;i<noOfCustomer;i++) {
			Customers.add(new Customer(i+1));
		}
		
		for(char i ='A';i<('A'+ noOfPlaces);i++) {
			places.add(i);
		}
	}
	
	public static boolean isPlace(char pickup) {
		
		for(int i=0;i<places.size();i++) {
			
			if(places.get(i) == pickup) {
				return true;
			}
		
		}
		return false;
	}
	
	public static boolean isCustomer(int customerId) {
		
		for(int i=0;i<Customers.size();i++) {
			
			int tempId = Customers.get(i).id; // to store the id from the Customer list temporarily 
			
			if(tempId == customerId) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public static int allocateTaxi(char pickup, char drop, int pickupTime, int dropTime) {
		int i,j,noOfFreeTaxi;
		
		List<Taxi> FreeTaxi = new ArrayList<Taxi>();
		for(i=0;i<noOfTaxi;i++) {
			FreeTaxi.add(new Taxi(Taxis.get(i)));
		}
		
		List<Integer> indexTobeDeleted = new ArrayList<Integer>();
		
		noOfFreeTaxi = noOfTaxi;
		 
		for(i=0;i<noOfFreeTaxi;i++) {
			
			Taxi tempTaxi = FreeTaxi.get(i);
			int noOfJournies = tempTaxi.bookingId.size();
			
			for(j=0;j<noOfJournies;j++) {
				int tempPickupTime = tempTaxi.pickupTime.get(j);
				int tempdropTime = tempTaxi.dropTime.get(j);
				
				if( !( (pickupTime>tempPickupTime && pickupTime>tempdropTime) || (dropTime<tempPickupTime && dropTime<tempdropTime) ) ) {
					indexTobeDeleted.add(i);
					break;
				}
			}
		
		}
		
		for(i=0;i<indexTobeDeleted.size();i++) {
			int in = indexTobeDeleted.get(i);
			
			FreeTaxi.remove(in-i); //(in-i) Because if we delete one element, all the other element will move back one step
			
		}
		noOfFreeTaxi = FreeTaxi.size();
		indexTobeDeleted.clear();
		
		
		
		
		for(i=0;i<noOfFreeTaxi;i++) {
			
			Taxi tempTaxi = FreeTaxi.get(i);
			int noOfJournies = tempTaxi.bookingId.size();
			int time=Integer.MAX_VALUE;
			int in1= -1;
			for(j=0;j<noOfJournies;j++) {
				
				int tempdropTime = tempTaxi.dropTime.get(j);
				int tempTime = pickupTime - tempdropTime;
				if(tempTime>0) {
					if(time>tempTime) {
						time = tempTime;
						in1 = j;
					}
				}
				
			}
			
			if(noOfJournies !=0 && in1!=-1) {
				if(!( (pickupTime - tempTaxi.dropTime.get(in1)) >= Math.abs( (int)(pickup-tempTaxi.drop.get(in1)) ) ) ) {
					indexTobeDeleted.add(i);
					
				}
				
			}
			
			
			
			
		}
		
		for(i=0;i<indexTobeDeleted.size();i++) {
			int in = indexTobeDeleted.get(i);
			
			FreeTaxi.remove(in-i); //(in-i) Because if we delete one element, all the other element will move back one step
			
		}
		
		noOfFreeTaxi = FreeTaxi.size();
		
		indexTobeDeleted.clear();
		
		

		
		
		for(i=0;i<noOfFreeTaxi;i++) {
			
			Taxi tempTaxi = FreeTaxi.get(i);
			int noOfJournies = tempTaxi.bookingId.size();
			int time=Integer.MAX_VALUE;
			int in1= -1;
			for(j=0;j<noOfJournies;j++) {
				
				int temppickupTime = tempTaxi.pickupTime.get(j);
				int tempTime = temppickupTime - dropTime;
				
				if(tempTime>0) {
					if(time>tempTime) {
						time = tempTime;
						in1 = j;
					}
					
				}
				
			}
			if(noOfJournies !=0 && in1!=-1 ) {
				if(!( (tempTaxi.pickupTime.get(in1) - dropTime) >= Math.abs( (int)(drop-tempTaxi.pickup.get(in1)) ) ) ) {
					System.out.println((tempTaxi.pickupTime.get(in1)));
					
					indexTobeDeleted.add(i);
					
				}
			}
			
			
			
			
		}

		for(i=0;i<indexTobeDeleted.size();i++) {
			int in = indexTobeDeleted.get(i);
			
			FreeTaxi.remove(in-i); // (in-1)Because if we delete one element, all the other element will move back one step  
			
		}
		
		noOfFreeTaxi = FreeTaxi.size();
		
		indexTobeDeleted.clear();
		
		
		
		
		if(FreeTaxi.isEmpty()) {
			return -1;
		}
		else {
			
			
			return FreeTaxi.get(0).id;
		}
	}
	
//---------------------------------------------------------------------------	
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		List<Booking> book = new ArrayList<Booking>(); 
		// To store the Booking
		
		//Temporary Variables
		int taxiId;
		int customerId;
		char pickup;
		char drop;
		int pickupTime;
		int dropTime;
		int amt;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int i = 1;
		
		while(true) {
		
			System.out.println("\t \t TAXI RESERVATION\n");
			System.out.println("1) Call Taxi Booking");
			System.out.println("2) Display\n");
			
			
			// Choice for the User
			int ch;
			ch = Integer.parseInt(br.readLine());
			
			if(ch == 1) {
				System.out.print("Customer ID: ");
				customerId = Integer.parseInt(br.readLine());
				
				if(!isCustomer(customerId)) {
					System.out.println("Invalid Customer id, Please Rebook\n\n");
					continue;
				}
				
				
				System.out.print("Pickup Point: ");
				pickup = br.readLine().charAt(0);
				
				if(!isPlace(pickup)) {
					System.out.println("There is no place called: " + pickup + " Please Rebook\n\n");
					continue;
				}
				
				System.out.print("Drop Point: ");
				drop = br.readLine().charAt(0);
				
				if(!isPlace(drop)) {
					System.out.println("There is no place called: " + drop + " Please Rebook\n\n");
					continue;
				}
				
				System.out.print("Pickup Time: ");
				pickupTime = Integer.parseInt(br.readLine());
				
				dropTime = Math.abs((int)(drop - pickup))+pickupTime;
				
				taxiId = allocateTaxi(pickup,drop,pickupTime,dropTime);
				amt = 120 + 10*(Math.abs((int)(drop - pickup))-1);
				
				if(taxiId == -1) {
					System.out.println(" Booking is Rejected");
				}
				else {
					System.out.println("\nTaxi can be allotted.");
					System.out.println("Taxi-"+taxiId+" Alocatted\n");
					;
					book.add(new Booking(i++,taxiId, customerId, pickup, drop, pickupTime, dropTime, amt));
				}
			}
			
			if(ch == 2)
			{
				for(i=0;i<noOfTaxi;i++) {
					Taxis.get(i).print();
				}
			}
		}
		
	
		
		
	}



}
