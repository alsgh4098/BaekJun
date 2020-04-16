import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1436_영화감독숌_Silver5 {
	
	static boolean[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
//		while(true) {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int N = Integer.parseInt(br.readLine());
			
			arr = new boolean[9999999];
			
			String number = null;
			int count = 0;
			int res = 0;
			
			for (int i = 666; i < 9999999; i++) {
				number = Integer.toString(i);
				if(number.contains("666")) {
					count++;
				}
				if( count == N) {
					res = i;
					break;
				}
			}
			
			System.out.println(res);

			
//			}
		
	}

}
