import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_1197_최소스패닝트리_크루스칼_gold5 {
	
	public static class Node implements Comparable<Node>{
		int idx;
		int weight;
		
		public Node(int idx, int weight) {
			super();
			this.idx = idx;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			if(this.weight > o.weight) {
				return 1;
			}else if(this.weight == o.weight) {
				return 0;
			}else {
				return -1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		ArrayList<Node>[] list = new ArrayList[V+1];
		
		for (int i = 1; i < V+1; i++) {
			list[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < E; i++) {
			int ths = sc.nextInt();
			int tht = sc.nextInt();
			int weight = sc.nextInt();
			list[ths].add(new Node(tht,weight));
			list[tht].add(new Node(ths,weight));
		}
		
		int[] dist = new int[V+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[1] = 0;
		
		boolean[] visited = new boolean[V+1];
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		pq.add(new Node(1,dist[1]));
		
		int res = 0;

		while(!pq.isEmpty()) {
			Node ths = pq.poll();
			
			visited[ths.idx] = true;
			
			for (Node tht : list[ths.idx]) {
                if(!visited[tht.idx]) {
					if(dist[tht.idx] > tht.weight) {
						dist[tht.idx] = tht.weight;
						pq.add(new Node(tht.idx,dist[tht.idx]));
					}
                }
			}
		}
		
		
		for (int i = 1; i < dist.length; i++) {
			res += dist[i];
		}
		
		System.out.println(res);
	}

}
