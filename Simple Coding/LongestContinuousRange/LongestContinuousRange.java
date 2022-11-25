import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongestContinuousRange {

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
			
			quickSort(arr,0,N-1); // sorting the array
			
			
			int subarray[][] = new int[N][N];
			// creating 2D subarray to store all the continuous range of elements
			
			int sizeArray[] = new int[N];
			// creating sizeArray to store the size of the continuous range of elements
			
			
			int a =0,b=0;
			int k =0;
			for(int i=1;i<N;i++) {
				if(arr[i-1]+1 == arr[i]) {
					subarray[a][b++] = arr[i-1];
					k++;
				}
				else {
					subarray[a][b++] = arr[i-1];
					k++;
					sizeArray[a++] = k;
					b = k =0;
				}
			}
			// the above code will store continuous range of elements in different row
			
			k++;
			subarray[a][b++] = arr[N-1];
			sizeArray[a++] = k;
			
			// finding size of the longest continuous range of elements
			int longest =sizeArray[0];
			for(int i =1;i<a;i++) {
				if(longest<sizeArray[i]) {
					longest = sizeArray[i];
				}
			}
			
			
			//printing the longest continuous range of elements
			for(int i=0;i<a;i++) {
				
				if(longest == sizeArray[i]) {
					for(int j=0;j<longest;j++) {
						System.out.print(subarray[i][j] + " ");
					}
				}
				System.out.println();
			}
			
			
			
			
		}
		catch(Exception e) {
			
		}


	}

	private static void quickSort(int[] arr, int i, int N) {
		
		if(i<N) {
		
		int in = partition(arr,i,N);
		quickSort(arr,i,in-1);
		quickSort(arr,in+1,N);
		}
	}

	private static int partition(int[] arr, int i, int n) {
		
		int start = i;
		int end = n;
		int pivot = arr[i];
				
		while(start<end) {
			while(pivot>=arr[start] && start<end) {
				start++;
			}
			
			while(pivot<arr[end] && end>0) {
				end--;
			}
			
			if(start<end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
		}
		arr[i] = arr[end];
		arr[end] = pivot;
		
		
		return end;
	}

}
