import java.util.Scanner;

public class Pattern2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int N1 = N;
		scan.close();
		
		if(N%2 == 0) {
			N1=N+1;
		}
		
		int arr[][] = new int[N1][N1];
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0) {
					arr[i][j] = 1;
				}
				else if(j==i) {
					arr[i][j] = 1;
				}
				else {
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			
			   for (int j=N-i; j>1; j--)
	            {
	                System.out.print(" ");
	            }
			
			for(int j=0;j<=i;j++) {
				System.out.print(arr[i][j]+ " ");
				
			}
			System.out.println();
			

		}
		
	}

}
