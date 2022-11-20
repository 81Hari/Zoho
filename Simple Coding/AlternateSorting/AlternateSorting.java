import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AlternateSorting {
	
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
			
			rawInput = null;
			
			// declaring two temp arrays and initializing that array to copy of original array
			int arr1[] = new int[N];
			int arr2[] = new int[N];
			
			arr1 = arr.clone();
			arr2 = arr.clone();
			
			AlternateSorting obj = new AlternateSorting(); 
			
			obj.mergeSort(arr1,0,N-1); //sorting one temp array in increasing order
			obj.quickSort(arr2,0,N-1); //another in decreasing order 
			
			int i,j,k;
			i = j = k = 0;
			
			while(k<N) {
				if(k%2 == 0) {
					arr[k++] = arr1[i++];
				}
				else {
					arr[k++] = arr2[j++];
				}
			}
			
			arr1 = arr2 = null;
			System.out.print("Alternate Sorted Array: ");
			
			for(i=0;i<N;i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println("");
		}
		catch(Exception e) {
			
				e.printStackTrace();
			
		}
	}

	private void quickSort(int[] arr2, int lb, int ub) {
		
		if(lb<ub) {
			int in = partition(arr2,lb,ub);
			quickSort(arr2,lb,in-1);
			quickSort(arr2,in+1,ub);
		}
	}

	private int partition(int[] arr2, int lb, int ub) {
		int start,end;
		int pivot = arr2[lb];
		start = lb;
		end = ub;
		
		while(start<end) {
			while(pivot<=arr2[start]) {
				start++;
			}
			
			while(pivot>arr2[end]) {
				end--;
			}
			if(start<end) {
				swap(arr2,start,end);
			}
		}
		
		swap(arr2,lb,end);
		
		return end;
	}

	private void swap(int[] arr2, int i, int j) {
		int temp = arr2[i];
		arr2[i] = arr2[j];
		arr2[j] = temp;
		
	}

	private void mergeSort(int[] arr1, int lb, int ub ) {
		
		if(lb<ub) {
			int mid = (int)(lb+ub)/2;
			
			mergeSort(arr1,lb,mid);
			mergeSort(arr1,mid+1,ub);
			merge(arr1,lb,mid,ub);
		}
		
	}

	private void merge(int[] arr1, int lb, int mid, int ub) {
		int temp[] = new int[ub-lb+1];
		
		int i,j,k;
		i = lb;
		j = mid+1;
		k = 0;
		
		while(i<=mid && j<=ub) {
			if(arr1[i]<arr1[j]) {
				temp[k++] = arr1[i++];
			}
			else {
				temp[k++] = arr1[j++];
			}
		}
		
		while(i<=mid) {
			temp[k++] = arr1[i++];
		}
		
		while(j<=ub) {
			temp[k++] = arr1[j++];
		}
		
		i = lb;
		k=0;
		while(i<=ub) {
			arr1[i++] = temp[k++];
		}
		
	}

}
