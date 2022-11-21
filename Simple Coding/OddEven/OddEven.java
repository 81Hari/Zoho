import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OddEven {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			// User Input: size of the array
			System.out.print("Enter the Number: ");
			Long N = Long.parseLong(br.readLine());
			
		
			
			br.close();
			
			int noOfOdd,noOfEven;
			noOfOdd = noOfEven = 0;
			int temp;
			while(N!=0) {
				temp = (int)(N%10);
				if(temp%2==0) {
					noOfEven++;
				}
				else {
					noOfOdd++;
				}
				N = N/10;
			}
			System.out.printf("ODD: %d EVEN: %d",noOfOdd,noOfEven);
		}
		catch(Exception e) {
		
			e.printStackTrace();
	
		}

	}

}
