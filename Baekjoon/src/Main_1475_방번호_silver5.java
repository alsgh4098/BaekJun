import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1475_방번호_silver5 {
	
	static int[] arr = new int[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str_num = br.readLine();
		
		for (int i = 0; i < str_num.length(); i++) {
			arr[str_num.charAt(i)-'0']++;
		}
		
		// 6이나 9를 반쪽으로 취급한다. -> 나누기 2를해준다.
		
		arr[6] = (int) Math.round((double)arr[9]/2 + (double)arr[6]/2);
		
		arr[9] = arr[6];
		
		int max = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		System.out.println(max);

	}

}
