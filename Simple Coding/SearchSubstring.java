import java.util.Scanner;

public class SearchSubstring {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the String: ");
		String s = scan.next();
		
		int N; // size of matrix
		System.out.print("\nSize of Matrix: ");
		N = scan.nextInt();
		
		
		char[][] arr = new char[N][N]; // matrix
		int k =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(k<s.length()) {
					arr[i][j] = s.charAt(k++);
				}
				else {
					break;
				}
			}
		}
		//Initializing a matrix
		
		k=0;
		// printing a matrix
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(k<s.length()) {
					System.out.print(arr[i][j] + " ");
				}
				else {
					break;
				}
			}
			System.out.println();
		}
		
		// substring to be searched
		System.out.print("\nEnter the Substring to  be searched: ");
		String sS = scan.next();
		int flag =0;
		
		// searching horizontally
		for(int i=0;i<N;i++) {
			String S = new String(arr[i]); // considering each row as separate string
			
			for(int j =0;j+sS.length()-1<N;j++) {
				if(S.substring(j, j+sS.length()).compareTo(sS)==0) {
					flag =1;
					System.out.printf("Start index: <%d,%d>\n",i,j);
					System.out.printf("End index: <%d,%d>\n",i,j+sS.length()-1);
					
				}
			}
			
			
			
		}
		
		// searching vertically
		
		for(int i=0;i<N;i++) {
			StringBuilder S1 = new StringBuilder(); // Building a string vertically
			for(int j=0;j<N;j++) {
				S1.append(arr[j][i]);
			}
			String S = S1.toString();
			
			for(int j =0;j+sS.length()-1<N;j++) {
				if(S.substring(j, j+sS.length()).compareTo(sS)==0) {
					flag =1;
					System.out.printf("Start index: <%d,%d>\n",j,i);
					System.out.printf("End index: <%d,%d>\n",j+sS.length()-1,i);
					
				}
			}
			
			
			
			
		}
		// searching diagonally
		int i = N-1;
		int j =0;
		while(i!=0 || j!=N) {
			int x,y;
			x = i;
			y = j;
			StringBuilder S1 = new StringBuilder(); //Building a string diagonally
			while(x<N && y<N) {
				S1.append(arr[x++][y++]);
			}
			String S = S1.toString();
			
			for(x =0;x+sS.length()-1<S.length();x++) {
				if(S.substring(x, x+sS.length()).compareTo(sS)==0) {
					flag =1;
					System.out.printf("Start index: <%d,%d>\n",i,j);
					System.out.printf("End index: <%d,%d>\n",i+sS.length()-1,j+sS.length()-1);
					
				}
			}
			
			if(i == 0) {
				j++;
			}
			else {
				i--;
			}
		}
		scan.close();
		if(flag == 0) {
			System.out.println("Not Found");
		}

	}
}
