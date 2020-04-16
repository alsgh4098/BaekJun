import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2644_촌수계산_silver2 {
	
	static int N;
	
	static ArrayList<Integer>[] list; 
	
	static boolean[] visited;
	
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		
		visited = new boolean[N+1];
		
		res = -1;
		
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 사람 1
		int me = Integer.parseInt(st.nextToken());
		// 사람 2
		int you = Integer.parseInt(st.nextToken());
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int ths = Integer.parseInt(st.nextToken());
			int tht = Integer.parseInt(st.nextToken());
			
			list[ths].add(tht);
			list[tht].add(ths);
		}
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.offer(new int[] {me,0});
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			int ths = temp[0];
			int count = temp[1];
			
			if(ths == you) {
				res = count;
				break;
			}
			
			visited[ths] = true;
			
			for (int i = 0; i < list[ths].size(); i++) {
				int tht = list[ths].get(i);
				if(!visited[tht]) {
					q.offer(new int[] {tht,count+1});
				}
			}
		}
		
		System.out.println(res);

	}

}
