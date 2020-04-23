import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1541_잃어버린괄호 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		String number = br.readLine();
		String plus_number = "";
		int plus = 0;
		int minus = 0;
		

		for (int i = 0; i < number.length(); i++) {
			if(number.charAt(i) == '-') {
				st = new StringTokenizer(number.substring(i+1).replaceAll("[-]|[+]", " "));
				while(st.hasMoreTokens()) {minus += Integer.parseInt(st.nextToken());}
				break;
			}else {
				plus_number += number.charAt(i);
			}
		}
		
		st = new StringTokenizer(plus_number,"+");
		while(st.hasMoreTokens()) { plus += Integer.parseInt(st.nextToken());}
		
		System.out.println(plus-minus);

	}

}


