import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16916_부분문자열_gold3 {
	
	static StringBuilder sb;
	static int cnt;
	static int[] pi;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		cnt = 0;
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		if(KMP(str1,str2)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}

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

	static boolean KMP(String origin, String pattern) {
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
					return true;
				}else {
					j++;
				}
			}
		}
		return false;
	}
}
