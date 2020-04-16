import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

public class Main_9327_상근이의여행_silver3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer>[] list = new ArrayList[N+1];
			for (int i = 1; i < N+1; i++) {
				list[i] = new ArrayList<Integer>();
			}
			boolean[] visited = new boolean[N+1];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int ths = Integer.parseInt(st.nextToken());
				int tht = Integer.parseInt(st.nextToken());
				
				list[ths].add(tht);
				list[tht].add(ths);
				
			}
			
			int res = 0;
			
			Queue<int[]> q = new LinkedList<int[]>();
			
			q.offer(new int[] {1,0});
			
			while(!q.isEmpty()) {
				int[] temp = q.poll();
				
				int ths = temp[0];
				
				visited[ths] = true;
				
				for (int i = 0; i < list[ths].size(); i++) {
					int tht = list[ths].get(i);
					
					if(!visited[tht]) {
						res ++;
						q.offer(new int[] {tht});
						visited[tht] = true;
					}
				}
			}			
			System.out.println(res);
		}

	}

}
