import java.util.LinkedHashSet;
import java.util.Scanner;

public class RemoveInvalidParentheses {

	static int k =0;
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the expression: ");
		String input = scan.next();
		scan.close();
		
		
		// n --> no of invalid parentheses
		int n = findNoOfInvalidParentheses(input);
	
		
		String output[] = new String[100]; 
		getValidExpressions(input,n,output);
		
		LinkedHashSet<String> out = new LinkedHashSet<String>();
		for(int i =0;i<k;i++) {
			out.add(output[i]);
		}
		
		System.out.println("Valid Expressions are: " + out);
		

	}

	private static void getValidExpressions(String input, int n, String[] output) {
		// basecase
		if(n<0) {
			return;
		}
		else if(n == 0) {
			if (isValidExpression(input)) {
				output[k++] = input;
			}
		}
		for(int i=0;i<input.length();i++) {
			if(input.charAt(i) =='(' || input.charAt(i) ==')' ) {
				String left = input.substring(0,i);
				String right = input.substring(i+1);
				getValidExpressions(left+right, n-1, output);
			}
		}
		
	}

	private static boolean isValidExpression(String s) {
		int n1 =0;
		for(int i =0;i<s.length();i++) {
			
			if(s.charAt(i) == '(' || s.charAt(i) == ')') {
				n1++;
			}
		}
		
		char stack[] = new char[n1];
		int j =0;
		
		for(int i =0;i<s.length();i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == ')') {
				if(stack.length == 0 || s.charAt(i) == '(') {
					stack[j++] = s.charAt(i); 
				}
				else if(s.charAt(i) == ')') {
					j--;
					
				}
			}
		}
		return (j ==0);
	}

	private static int findNoOfInvalidParentheses(String s) {
		// n1 --> no of parentheses
		int n1 =0;
		for(int i =0;i<s.length();i++) {
			
			if(s.charAt(i) == '(' || s.charAt(i) == ')') {
				n1++;
			}
		}
		
		char stack[] = new char[n1];
		int j =0;
		
		for(int i =0;i<s.length();i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == ')') {
				if(stack.length == 0 || s.charAt(i) == '(') {
					stack[j++] = s.charAt(i); 
				}
				else if(s.charAt(i) == ')') {
					j--;
					
				}
			}
		}
		stack = null;
		return j;
	}

}
