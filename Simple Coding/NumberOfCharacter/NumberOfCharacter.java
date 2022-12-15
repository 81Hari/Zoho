import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NumberOfCharacter {

	public static void main(String[] args) {
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			int noOfChar = 0;
			for(int i=1;i<=n;i++) {
				int num =i;
				while(num>0) {
					noOfChar++;
					num = (int)(num/10);
				}
			}
			System.out.println(noOfChar);
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
