import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2617_구슬찾기_silver1 {
	
	static boolean[] visited;
	static boolean[] visited2;
	static ArrayList<Integer>[] list;
	static ArrayList<Integer>[] list2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		list2 = new ArrayList[N+1];
		visited = new boolean[N+1];
		visited2 = new boolean[N+1];
		
		for (int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<Integer>();
			list2[i] = new ArrayList<Integer>();
		}
		
		// 연결된 노드들의 N/2+1 이상이면 안됨.
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int ths = Integer.parseInt(st.nextToken());
			int tht = Integer.parseInt(st.nextToken());
			
			list[ths].add(tht);
			list2[tht].add(ths);
		}
		
		int res = 0;
		
		for (int i = 1; i < N+1; i++) {
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(i);
			int check = 0;
			visited[i] = true;
			while(!q.isEmpty()) {
				int ths = q.poll();
				for (int j = 0; j < list[ths].size(); j++) {
					int that = list[ths].get(j);
					if(!visited[that]) {
						check++;
						visited[that] = true;
						q.offer(that);
					}
				}
			}
//			System.out.println(i+":"+check);
			if(check >= N/2+1) {
				res++;
			}
			visited = new boolean[N+1];
		}
		
		for (int i = 1; i < N+1; i++) {
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(i);
			int check = 0;
			visited[i] = true;
			while(!q.isEmpty()) {
				int ths = q.poll();
				for (int j = 0; j < list2[ths].size(); j++) {
					int that = list2[ths].get(j);
					if(!visited[that]) {
						check++;
						visited[that] = true;
						q.offer(that);
					}
				}
			}
//			System.out.println(i+":"+check);
			if(check >= N/2+1) {
				res++;
			}
			visited = new boolean[N+1];
		}
		
		System.out.println(res);
		
		
	}

}
