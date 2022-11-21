import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubsetArray {
	
	static int k =0;
	
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
			
			int N1 = (int)Math.pow(2, N); // N1 --> Number of Subsets
			int subset[][] = new int[N1][N];
			
			
			findSubset(arr,0,N,subset);
			
			
			
			
			for(int i =0;i<N1;i++) {
				for(int j=0;j<N;j++) {
					
					if(subset[i][j] != Integer.MIN_VALUE) {
					System.out.print(subset[i][j] + " ");
					}
					
				}
				System.out.println();
			}
			
		}
		catch(Exception e) {
			
		}
		
	}

	private static void findSubset(int[] arr, int i, int N, int[][] subset) {
		
		if(i!=N) {
			int inArr[] = arr.clone(); // inArray --> In this array, element in the ith position is included 
			int exArr[] = arr.clone(); // inArray --> In this array, element in the ith position is not included
			
			exArr[i] = Integer.MIN_VALUE;
			
			findSubset(inArr, i+1, N, subset);
			findSubset(exArr, i+1, N, subset);
		}
		else {
			subset[k++] = arr.clone();
		}
		
	}
}
