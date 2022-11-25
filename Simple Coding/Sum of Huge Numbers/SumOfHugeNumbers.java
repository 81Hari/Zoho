import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SumOfHugeNumbers {
	public static final int N = 100;
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("Enter the First Number: ");
			String rawInput = br.readLine(); //Read input as String
			
			int hNum1[] = new int[N]; 
			int n1 = rawInput.length();
			
			
			int j;
			for(int i =0;i<rawInput.length();i++) {
				j = N-1-i;
				hNum1[j] = Integer.parseInt(rawInput.substring(n1-1-i,n1-i)); // Storing the digits of the number in the array from the last 
			}
			
			System.out.print("Enter the Second Number: ");
			rawInput = br.readLine();
			int hNum2[] = new int[N]; 
			int n2 = rawInput.length(); //Read input as String
			
			for(int i =0;i<rawInput.length();i++) {
				j = N-1-i;
				hNum2[j] = Integer.parseInt(rawInput.substring(n2-1-i,n2-i)); // Storing the digits of the number in the array from the last 
			}
			
			
			int n3 =0; // to find the max number of digits of the result
			if(n1>n2) {
				n3 = n1 + 1;
			}
			else {
				n3 = n2 + 1;
			}
			
			int result[] = new int[n3]; // creating the third array, to store the digits of the result
			
			int temp,rem;
			rem =0; 
			for(int i =0;i<n3;i++) {
				temp = hNum2[N-1-i] + hNum1[N-1-i] +rem; // sum of two digits in the two array's and remaining part of the previous addition. 
				
				result[n3-1-i] = temp%10; // storing the resultant digit in the result array. (we are using mod10 to store single digit)
				rem = temp/10; // remaining part in the addition is stored in the remaining part
			}
			int i=0;
			if(result[0] == 0) {
				i=1;
			}
			for(;i<n3;i++) {
				
				System.out.print(result[i] + " ");
				
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		

	}

}
