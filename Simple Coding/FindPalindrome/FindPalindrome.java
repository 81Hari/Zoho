import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FindPalindrome {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.print("Enter 2-Digit or 3-Digit Number: ");
			String rawInput = br.readLine();
			
			if(rawInput.length() == 2 || rawInput.length() == 3) {
				int num = Integer.parseInt(rawInput);
				int revNum,temp;
				
				// 5-iterations
				for(int i=0;i<5;i++) {
					
					revNum = 0;
					temp = num;
					
					//reversing a Number
					while(temp>0) {
						revNum = 10*revNum + (temp%10);
						
						temp/=10;
					}
					
					
					num +=revNum; // sum of reversed and original number
					
					
					temp = num; // storing resultant number in temp 
					revNum = 0;
					
					// Reversing a resultant number
					while(temp>0) {
						revNum = 10*revNum + (temp%10);
						
						temp/=10;
					}
					
					//checking whether resultant number is equal to reversed number of resultant  
					if(revNum == num) {
						break;
					}
					
				}
				
				
				System.out.println(num);
			}
			else {
				System.out.println("Given Input is Neither a 2-Digit nor 3-Digit Number");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
