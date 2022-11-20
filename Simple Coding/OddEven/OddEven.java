import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OddEven {

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
			
			int noOfOdd,noOfEven;
			noOfOdd = noOfEven = 0;
			
			for(int i=0;i<N;i++) {
				if(arr[i]%2==0) {
					noOfEven++;
				}
				else {
					noOfOdd++;
				}
			}
			System.out.printf("ODD: %d EVEN: %d",noOfOdd,noOfEven);
		}
		catch(Exception e) {
		
			e.printStackTrace();
	
		}

	}

}
