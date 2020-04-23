import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1786_찾기_gold2 {
	
	static StringBuilder sb;
	static int cnt;
	static int[] pi;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		cnt = 0;
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		KMP(str1,str2);
		
		System.out.println(cnt);
		System.out.println(sb);
	}

	static void getPi(String pattern) {
		char[] ptrn = pattern.toCharArray();
		pi = new int[ptrn.length];
		int j = 0;
		for (int i = 1; i < ptrn.length; i++) {
			while( j > 0 && ptrn[i] != ptrn[j]) {
				j = pi[j-1];
			}
			if( ptrn[i] == ptrn[j]) {
				pi[i] = ++j;
			}
		}
		
	}

	static void KMP(String origin, String pattern) {
		getPi(pattern);
		char[] org = origin.toCharArray();
		char[] ptrn = pattern.toCharArray();
		
		int j = 0;
		for (int i = 0; i < org.length; i++) {
			while(j>0 && org[i] != ptrn[j]) {
				j = pi[j-1];
			}
			if(org[i] == ptrn[j]) {
				if(j == ptrn.length - 1) {
					j = pi[j];
					cnt++;
					sb.append((i-ptrn.length+2)+" ");
				}else {
					j++;
				}
			}
		}
	}
	
	static int[] getPI2(String pattern) {
		int[] pi2 = new int[pattern.length()];
		
		char[] ptrn = pattern.toCharArray();
		
		int j = 0;
		
		for (int i = 0; i < ptrn.length; i++) {
			while( j>0 && ptrn[i] != ptrn[j]) {
				j = pi2[j-1];
			}
			if(ptrn[i] == ptrn[j]) {
				pi2[i] = ++j;
			}
		}
		
		return pi2;
	}// end getpi
	
	static int KMP2(String orgin,String pattern) {
		char[] orgn = orgin.toCharArray();
		char[] ptrn = pattern.toCharArray();
		int j = 0;
		int[] pi2 = getPI2(pattern);
		for (int i = 0; i < orgn.length; i++) {
			while( j > 0 && orgn[i] != ptrn[j]) {
				j = pi2[j-1]++;
			}
			if(orgn[i] == ptrn[j]) {
				if( j == ptrn.length-1) {
					return i-ptrn.length+2;
				}else {
					j++;
				}
			}
		}
		
		return -1;
	}
}
