import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SortUsingWeight {

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
			// above code is for input
			rawInput = null;
			
			// Before finding weight for each element, we should sort the array.So that after sorting elements using weight, The elements in the array are sorted not only by their weight but also by the element itself.   
			for(int i=1;i<N;i++) {
				int temp = arr[i];
				int j = i-1;
				while(j>=0 && arr[j]>temp) {
					arr[j+1] = arr[j];
					j--;
				}
				arr[j+1] = temp;
			}
			
			int[][] A = new int[N][2];
			
			
			
			
			for(int i =0;i<N;i++) {
				int temp = (int) Math.sqrt(arr[i]);
				if(temp*temp == arr[i]) {
					A[i][0] = arr[i];
					A[i][1] = 5;
				}
				else if(arr[i]%4 == 0 && arr[i]%6 ==0) {
					A[i][0] = arr[i];
					A[i][1] = 4;
				}
				else if(arr[i]%2 == 0) {
					A[i][0] = arr[i];
					A[i][1] = 3;
				}
				else {
					A[i][0] = arr[i];
					A[i][1] = 2;
				}
				
			}
			for(int i=1;i<N;i++) {
				int j =i-1;
				int temp=A[i][1];
				int temp1=A[i][0];
				while(j>=0 && temp<A[j][1]) {
					A[j+1][0] = A[j][0];
					A[j+1][1] = A[j][1];
					j--;
					
				}
				A[j+1][1] = temp;
				A[j+1][0] = temp1;
			}
			for(int i=0;i<N;i++) {	
				System.out.printf("<%-3d, %d>\n",A[i][0],A[i][1]);
			}
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		
	}

	}

}
