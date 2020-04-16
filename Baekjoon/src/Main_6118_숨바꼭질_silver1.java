import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6118_숨바꼭질_silver1 {

	static int N, M;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int ths = Integer.parseInt(st.nextToken());
			int tht = Integer.parseInt(st.nextToken());

			list[ths].add(tht);
			list[tht].add(ths);
		}

		int res = -1;
		
		int barn = -1;
		
		int barn_cnt = -1;

		Queue<int[]> queue = new LinkedList<int[]>();

		queue.offer(new int[] { 1, 0 });
		
		boolean[] visited = new boolean[N+1];
		
		visited[1] = true;

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();

			int ths = temp[0];
			// 거리
			int dist = temp[1];
			
			if(res < dist) {
				res = dist;
				barn_cnt = 1;
				barn  = ths;
			}else if(res == dist) {
				barn_cnt++;
				if(barn > ths) {
					barn  = ths;
				}
			}
			
			for (int j = 0; j < list[ths].size(); j++) {
				int tht = list[ths].get(j);
				if(!visited[tht]) {					
					queue.offer(new int[] {tht,dist+1});
				}
				visited[tht] = true;
			}
		}
		
		System.out.println(barn+" "+res+" "+barn_cnt);

	}

}
