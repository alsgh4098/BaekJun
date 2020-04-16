import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_1197_최소스패닝트리_프림_gold4 {
	
	public static class Edge{
		int s;
		int e;
		int weight;
		
		public Edge(int s, int e, int weight) {
			super();
			this.s = s;
			this.e = e;
			this.weight = weight;
		}
		

	}
	
	static int[] parent;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		parent = new int[V+1];
		ArrayList<Edge> list = new ArrayList<Edge>();
		
		for (int i = 0; i < E; i++) {
			int ths = sc.nextInt();
			int tht = sc.nextInt();
			int weight = sc.nextInt();
			list.add(new Edge(ths,tht,weight));
		}
		
		Collections.sort(list,new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				if(o1.weight > o2.weight) {
					return 1;
				}else if(o1.weight < o2.weight) {
					return -1;
				}else {
					return 0;
				}
			}
			
		});
		
		for (int i = 1; i < V+1; i++) {
			parent[i] = i;
		}
		
		int res = 0;

		for (Edge edg : list) {
			int idx1 = edg.s;
			int idx2 = edg.e;
			if(union(idx1, idx2)) {
				res += edg.weight;
			}
			
		}
		System.out.println(res);
	}
	
	static int findRoot(int idx) {
		if(parent[idx] == idx) {
			return idx;
		}else{
			return parent[idx] = findRoot(parent[idx]);
		}
	}
	
	static boolean union(int idx1, int idx2) {
		
		idx1 = findRoot(idx1);
		idx2 = findRoot(idx2);
		
		if(idx1 != idx2) {
			parent[idx1] = idx2;
			return true;
		}
		
		return false;
		
	}

}
