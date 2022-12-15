import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LexicographicalSorting {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String nums[] = br.readLine().split(" ");
			int N = nums.length;
			int j;
			String ele;
			for(int i =1;i<N;i++) {
				j = i-1;
				ele = nums[i];
				while(j>=0 && ele.compareTo(nums[j])<0) {
					nums[j+1] = nums[j];
					j--;
				}
				nums[j+1] = ele;
				
			}
			
			for(int i=0;i<N;i++) {
				System.out.print(nums[i]+" ");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
