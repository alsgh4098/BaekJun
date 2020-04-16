import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 태그로 감싸져 있는것은 순서를 바꾸지 않는다.

		String str_arr = br.readLine();

		char[] chr_arr = str_arr.toCharArray();
		
		boolean prnth = false;
		
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < chr_arr.length; i++) {
			if(chr_arr[i] == '<') {
				prnth = true;
				int len = stack.size();
				for (int j = 0; j < len; j++) {
					sb.append(stack.pop());
				}
			}
			
			// 지금은 괄호 안.
			if(prnth) {
				sb.append(chr_arr[i]);
				if(chr_arr[i] == '>') {
					prnth = false;
				}
			// 지금은 괄호 밖.
			}else{
				if(chr_arr[i] == ' ') {
					int len = stack.size();
					for (int j = 0; j < len; j++) {
						sb.append(stack.pop());
					}
					sb.append(' ');
				}else {
					stack.add(chr_arr[i]);
				}
			}
		}
		
		//남은게 있다면.
		int len = stack.size();
		for (int j = 0; j < len; j++) {
			sb.append(stack.pop());
		}
		
		System.out.println( sb.toString());

	}

}
