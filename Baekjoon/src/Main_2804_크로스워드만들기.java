import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2804_크로스워드만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str_ = br.readLine().split(" ");
		
		String str1 = str_[0];
		String str2 = str_[1];
		
		char[] str1_arr = str1.toCharArray();
		char[] str2_arr = str2.toCharArray();
		
		int str1_index = 0;
		int str2_index = 0;
		
		boolean finish_check = false;
		
		// 제일 먼저나오는 중복된 글자 찾기.
		for (int i = 0; i < str1_arr.length; i++) {
			for (int j = 0; j < str2_arr.length; j++) {
				if(str1_arr[i] == str2_arr[j]) {
					str1_index = i;
					str2_index = j;
					finish_check = true;
					break;
				}
			}
			
			if(finish_check) {
				break;
			}
		}
		
		char[][] str_map = new char[str2.length()][str1.length()];
		
		for (int i = 0; i < str_map.length; i++) {			
			Arrays.fill(str_map[i], '.');
		}
		
		
		for (int i = 0; i < str2.length(); i++) {
			str_map[i][str1_index] = str2_arr[i];
		}
		for (int i = 0; i < str1.length(); i++) {
			str_map[str2_index][i] = str1_arr[i];
		}
		
		for (int i = 0; i < str2.length(); i++) {
			for (int j = 0; j < str1.length(); j++) {
				System.out.print(str_map[i][j]);
			}
			System.out.println();
		}
		
	}

}
