import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_d4_스타일리쉬들여쓰기 {
	
	static int[][] frm;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			frm = new int[N-1][4];
			// 
			Stack<Character> st1 = new Stack<Character>();
			Stack<Character> st2 = new Stack<Character>();


			char[] line = br.readLine().toCharArray();
			
			for (int i = 0; i < line.length; i++) {
				if(check(line[i])) {
					st1.add(line[i]);
				}
			}
			
			for (int j = 0; j < N-1; j++) {

				int count = 0;
				
				int rp = 0;
				int rm = 0;
				
				int cp = 0;
				int cm = 0;
				
				int sp = 0;
				int sm = 0;

				line = br.readLine().toCharArray();
				
				// 들여쓰기('.')의 갯수를 센다. 
				for (int i = 0; i < line.length; i++) {
					if(line[i] == '.') {
						count++;
					}else {
						break;
					}
				}
				
				int len = st1.size();
				
				for (int i = 0; i < len; i++) {
					if(st2.size() != 0 
					&& st2.peek() == paren(st1.peek())) {
						//괄호가 완성되면 둘다 pop
						st2.pop();
						st1.pop();
					}else {						
						st2.add(st1.pop());
					}
				}
				
				len = st2.size();
				
				for (int i = 0; i < len; i++) {
					if(st2.peek() == '(') {
						rp++;
					}else if(st2.peek() == ')'){
						rm++;
					}else if(st2.peek() == '{'){
						cp++;
					}else if(st2.peek() == '}'){
						cm++;
					}else if(st2.peek() == '['){
						sp++;
					}else if(st2.peek() == ']'){
						sm++;
					}
					// 다음 문장을 위해서 다시 st1으로 옮긴다.
					st1.add(st2.pop());
				}
				

				
				frm[j][0] = rp-rm;
				frm[j][1] = cp-cm;
				frm[j][2] = sp-sm;
				frm[j][3] = count;
				
				// 괄호를 앞에서 부터 모두 읽어서 stack에 넣는다.
				for (int i = 0; i < line.length; i++) {
					if(check(line[i])) {
						st1.add(line[i]);
					}
				}
			}//
			
			// 방정식계산
			
			int R = -1;
			int S = -1;
			int C = -1;
			
			for (int r = 1; r <= 20; r++) {
				boolean br1 = false;
				for (int c = 1; c <= 20; c++) {
					boolean br2 = false;
					for (int s = 1; s <= 20; s++) {
						boolean check = true;
						boolean check1 = false;
						boolean check2 = false;
						boolean check3 = false;
						
						for (int i = 0; i < N-1; i++) {
							if( r*frm[i][0] + c*frm[i][1] + s*frm[i][2] != frm[i][3]) {
								check = false;
							}else {
								if(frm[i][0] != 0) {
									check1 = true;
								}
								if(frm[i][1] != 0) {
									check2 = true;							
								}
								if(frm[i][2] != 0) {									
									check3 = true;
								}
							}
						}
						if(check) {
							if(check1) {								
								R = r;
							}
							if(check2) {		
								S = s;
							}
							if(check3) {	
								C = c;
							}
							br2 = true;
							break;
						}	
					}
					if(br2) {
						br1 = true;
						break;
					}
				}
				if(br1) {
					break;
				}
			}// end 방정식
			
			// 새로운 인풋
			st1 = new Stack<Character>();
			st2 = new Stack<Character>();
			
			int[] res = new int[M];
			
			line = br.readLine().toCharArray();
			
			// 괄호를 앞에서 부터 모두 읽어서 stack에 넣는다.
			for (int i = 0; i < line.length; i++) {
				if(check(line[i])) {
					st1.add(line[i]);
				}
			}
			
			for (int j = 1; j < M; j++) {
				int rp = 0;
				int rm = 0;
				
				int cp = 0;
				int cm = 0;
				
				int sp = 0;
				int sm = 0;
				
				int len = st1.size();
				
				for (int i = 0; i < len; i++) {
					if(st2.size() != 0 
					&& st2.peek() == paren(st1.peek())) {
						//괄호가 완성되면 둘다 pop
						st2.pop();
						st1.pop();
					}else {						
						st2.add(st1.pop());
					}
				}
				
				len = st2.size();
				
				for (int i = 0; i < len; i++) {
					if(st2.peek() == '(') {
						rp++;
					}else if(st2.peek() == ')') {
						rm++;
					}else if(st2.peek() == '{') {
						cp++;
					}else if(st2.peek() == '}') {
						cm++;
					}else if(st2.peek() == '['){
						sp++;
					}else if(st2.peek() == ']'){
						sm++;
					}
					// 다음 문장을 위해서 다시 st1으로 옮긴다.
					st1.add(st2.pop());
				}
				
				line = br.readLine().toCharArray();
				
				// 괄호를 앞에서 부터 모두 읽어서 stack에 넣는다.
				for (int i = 0; i < line.length; i++) {
					if(check(line[i])) {
						st1.add(line[i]);
					}
				}
				
				res[j] = R*(rp-rm) + C*(cp-cm) + S*(sp-sm);
				
				if( rp-rm != 0 && R == -1) {
					res[j] = -1;
				}
				
				if( cp-cm != 0 && C == -1) {
					res[j] = -1;
				}
				
				if( sp-sm != 0 && S == -1) {
					res[j] = -1;
				}
				
				for (int i = 0; i < N-1; i++) {
					if(rp-rm == frm[i][0] && cp-cm == frm[i][1]
							&& sp-sm == frm[i][2]) {
						res[j] = frm[i][3];
						break;
					}
				}
				
				
			}
			
			sb.append("#"+t+" ");
			
			for (int i = 0; i < res.length; i++) {
				sb.append(res[i]+" ");
			}
			sb.append("\n");
			
		}// end tc
		
		System.out.println(sb);

	}// end main
	
	static boolean check(char chr) {
		if(chr == '{' || chr == '}' || chr == '(' || chr == ')' || chr == '[' || chr == ']' ) {
			return true;
		}else {
			return false;
		}
	}
	
	static char paren(char chr) {
		if(chr == '(') {
			return ')';
		}else if(chr == '{') {
			return '}';
		}else if(chr == '[') {
			return ']';
		}else {
			return '0';
		}
	}

}
