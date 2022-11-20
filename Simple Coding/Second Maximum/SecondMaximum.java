import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SecondMaximum {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			// User Input: size of the array
			System.out.print("Enter the size for the array: ");
			int N = Integer.parseInt(br.readLine());
			
			int arr[] = new int[N];
			
			// User Input: elements of the array
			System.out.print("\nEnter the elements for the array: ");
			String rawInput[] = br.readLine().split(" ");
			
			br.close();
			
			
			// is size of the array is greater than the number of elements entered. if yes reduce the size of the array else take first 'N' elements. 
			if(N>rawInput.length) {
				N = rawInput.length;
			}
			
			
			for(int i=0;i<N;i++) {	
				arr[i] = Integer.parseInt(rawInput[i]);
			}
			
			
			int f,s; // f--> First Largest Number, s--> Second Largest number
			int flag=0;
			f = s = Integer.MIN_VALUE;
			if(arr.length>=2) {
				
				for(int i=0;i<N;i++) {
					
					int lar = arr[i];
					int in = i;
					
					for(int j =i+1;j<N;j++){
						if(arr[j]>lar) {
							lar = arr[j];
							in =j;
						}
					}	
					arr[in] = arr[i];
					arr[i] = lar;
					
					if(flag == 0) {
						f =s= lar; // Storing First Largest Number in f and s 
						flag =1;
					}
					else {
						if(f!=lar) { // checking whether the first largest is equal to the next largest
							s = lar;
							break;
									
						}
					}
					
				}
				
				if(f!=s) { //  checking first largest and second largest are equal
					System.out.println("Second Largest Number: " + s);
				}
				else {
					System.out.println("No Second Maximum");
				}
			}
			else {
				System.out.println("No Second Maximum");
			}
			
		}
		catch(Exception e) {
		
			e.printStackTrace();
	
		}

	}

}
