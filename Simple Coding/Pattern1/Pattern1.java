import java.util.Scanner;

public class Pattern1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("String : " );
		String s = scan.nextLine();
		scan.close();
		int N = s.length();
		char[][] mat = new char[N][N];
		
		for(int i=0;i<N;i++){
			mat[i][i] = s.charAt(i);
			mat[i][N-i-1] = s.charAt(N-1-i);
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i == j) {
					System.out.printf("%-3c",mat[i][j]);
				}
				else if(i+j == N-1) {
					System.out.printf("%-3c",mat[i][j]);
				}
				else {
					System.out.printf("%-3c",' ');
				}
			}
			System.out.println("");
		}
		

	}

}
