import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.xml.sax.InputSource;

public class Main_7568_덩치_silver_5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] x = new int[N];
		int[] y = new int[N];
		int[] rank = new int[N];
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			
		}
		
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			count = 0;
			for (int j = 0; j < N; j++) {
				if(i != j) {					
					if(x[i] < x[j]
							&& y[i] < y[j]) {
						count++;
					}
				}
			}
			rank[i] = count+1;
			System.out.printf("%d ",rank[i]);
		}
		
	}

}
