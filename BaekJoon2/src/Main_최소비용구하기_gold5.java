import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_최소비용구하기_gold5 {
	
	static ArrayList<Node>[] list;
	
	static class Node implements Comparable<Node>{
		int idx;
		long val;
		
		public Node(int idx, long val) {
			super();
			this.idx = idx;
			this.val = val;
		}

		@Override
		public int compareTo(Node o) {
			if(this.val > o.val) {
				return 1;
			}else {
				return -1;
			}
		}
	}

	// dijkstra
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 노드의 수
		int N = sc.nextInt();
		// 연결된 수
		int V = sc.nextInt();
		
		list = new ArrayList[N+1];
		
		for (int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < V; i++) {
			int ths = sc.nextInt();
			int tht = sc.nextInt();
			int val = sc.nextInt();

			list[ths].add(new Node(tht,val));
			
		}// end input
		
		int start = sc.nextInt();
		int finish = sc.nextInt();
		
		long[] dist = new long[N+1];
		boolean[] visited = new boolean[N+1];
		
		Arrays.fill(dist, Long.MAX_VALUE);
		
		dist[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start,dist[start]));
		while(!pq.isEmpty()) {
			
			Node ths = pq.poll();
			
			if(visited[ths.idx]) {
				continue;
			}
			
			visited[ths.idx] = true;
			
			for (Node tht : list[ths.idx]) {
				if(dist[tht.idx] > tht.val + dist[ths.idx]) {
					dist[tht.idx] = tht.val + dist[ths.idx];
					pq.add(new Node(tht.idx,dist[tht.idx]));
				}
			}
		}//end logic
		
		System.out.println(dist[finish]);
		
	}
}
