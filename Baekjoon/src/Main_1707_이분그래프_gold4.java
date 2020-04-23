import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1707_이분그래프_gold4 {
	
	static int V,E;
	static ArrayList<Integer>[] list;
	static int[] colors;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[V+1];

			
			for (int i = 1; i <= V; i++) {
				list[i] = new ArrayList<Integer>();
			}
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int ths = Integer.parseInt(st.nextToken());
				int tht = Integer.parseInt(st.nextToken());
				
				list[ths].add(tht);
				list[tht].add(ths);
			}
			
			String res = "YES";
			colors = new int[V+1];
			// 각 정점마다 확인
			for (int i = 1; i < V+1; i++) {
				if (colors[i] == 0) {
					if (dfs(i, 1)) {
						res = "NO";
						break;
					}
				}
			}
			
			System.out.println(res);
			
		}// end testcase

	}// end main

	private static boolean dfs(int number, int color) {
		colors[number] = color;
		
		for (int i = 0; i < list[number].size(); i++) {
			int tht = list[number].get(i);
			
			if (colors[tht] == color) {
				return true;
			}

			if (colors[tht] == 0) {
				if (dfs(tht, -color)) {
					return true;
				}
			}
		}
		
		return false;
	}

}
