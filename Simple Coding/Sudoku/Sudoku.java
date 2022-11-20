import java.util.Scanner;

public class Sudoku {
	int[][] puzzle;
	
	public Sudoku() {
		puzzle = new int[9][9];
	}
	
	private void getInput() {
		Scanner scan = new Scanner(System.in);
		int check =1;
		System.out.println("Enter the sudoku that to be evaluated: \n\n");
		for(int i=0;i<9;i++) {
			String[] rawInput = scan.nextLine().split(" ");
			
			if(rawInput.length != 9) {
				System.out.println("\n\nEnter only Nine Numbers\n\n");
				i--;
				continue;
			}
			
			for(int j=0;j<9;j++) {
				puzzle[i][j] = Integer.parseInt(rawInput[j]);
				if(!(puzzle[i][j]<=9 && puzzle[i][j]>=1)) {
					System.out.println("\n\nEnter Numbers b/w 1 and 9\n\n");
					check =0;
					break;
				}
			}
			
			if(check == 0) {
				i--;
				check =1;
				continue;
			}
			
		}
		
		scan.close();
		// Above code is to get input for 9X9 matrix
		
		if(isValid()) {
			System.out.println("\nValid Sudoku");
		}
		else {
			System.out.println("\nInvalid Sudoku");
		}
	}
	
	private boolean isValid() {
		
		// checking whether given sudoku is valid using the concept sum in each row,column and submatrix = 45
		int flag = 9*10/2;
		int temp;
		for(int i =0;i<9;i++) {
			temp=0;
			for(int j=0;j<9;j++) {
				temp=temp+puzzle[i][j];
			}
			if(temp!=flag) {
				return false;
			}
		}
		
		for(int i =0;i<9;i++) {
			temp=0;
			for(int j=0;j<9;j++) {
				temp=temp+puzzle[j][i];
			}
			if(temp!=flag) {
				return false;
			}
		}
		
		for(int k=0;k<3;k++) {
			temp=0;
			for(int i=k*3;i<3+k*3;i++) {
				for(int j=0;j<3;j++) {
					temp=temp+puzzle[i][j];
				}
			}
			
			if(temp!=flag) {
				return false;
			}
			
			temp=0;
			for(int i=k*3;i<3+k*3;i++) {
				for(int j=3;j<6;j++) {
					temp=temp+puzzle[i][j];
				}
			}
			
			if(temp!=flag) {
				return false;
			}
			
			temp=0;
			for(int i=k*3;i<3+k*3;i++) {
				for(int j=6;j<9;j++) {
					temp=temp+puzzle[i][j];
				}
			}
			
			if(temp!=flag) {
				return false;
			}
		}
		
		return true;
		
		
	}

	public static void main(String[] args) {
		
		Sudoku obj = new Sudoku();
		
		obj.getInput();

	}

	

}
